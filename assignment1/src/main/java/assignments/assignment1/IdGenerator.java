package assignments.assignment1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class IdGenerator {
    static HashMap<Character, Integer> charToValue = new HashMap<>(36);
    static char[] valueToChar = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();

    /*
     * Code pada method main tidak boleh diganti sama sekali!
     */
    public static void main(String[] args) {
        buildMapCharToValue();
        Scanner input = new Scanner(System.in);
        System.out.println("Selamat Datang di Perpustakaan!");

        boolean shouldTerminateProgram = false;

        while (!shouldTerminateProgram) {
            printMenu();
            System.out.print("Menu yang anda pilih: ");
            int menu = input.nextInt();
            input.nextLine();

            if (menu == 1) {
                System.out.print("Program Studi: ");
                String programStudi = input.nextLine();
                System.out.print("Angkatan: ");
                String angkatan = input.nextLine();
                System.out.print("Tanggal Lahir: ");
                String tanggalLahir = input.nextLine();

                System.out.println(generateId(programStudi, angkatan, tanggalLahir));
            } else if (menu == 2) {
                System.out.print("ID Anggota: ");
                String idAnggota = input.nextLine();

                System.out.print("Validitas: ");
                System.out.println(checkValidity(idAnggota));
            } else {
                shouldTerminateProgram = true;
                System.out.println("Sampai jumpa!");
            }
        }

        input.close();
    }

    /*
     * Method buildMapCodeToNumber adalah method untuk membuat mapping reference numbers Code 93
     */
    public static void buildMapCharToValue() {
        for (int count = 0; count < valueToChar.length; count++) {
            charToValue.put(valueToChar[count], count);
        }
    }

    /*
     * Method getCharFromValue adalah method yang akan mengembalikan Code 93 dari value yang diberikan
     */
    private static char getCharFromValue(int value) {
        return valueToChar[value];
    }

    /*
     * Method getValueFromChar adalah method yang akan mengembalikan value dari Code 93 yang diberikan
     */
    private static int getValueFromChar(char character) {
        return charToValue.get(character);
    }

    private static void printMenu() {
        System.out.println("--------------------------------------------");
        System.out.println("Menu yang tersedia:");
        System.out.println("1. Generate ID anggota untuk anggota baru");
        System.out.println("2. Check validitas ID anggota");
        System.out.println("3. Keluar");
        System.out.println("--------------------------------------------");
    }

    /*
     * Method generateId adalah method untuk membuat ID keanggotaan perpustakaan
     * Parameter dan return type dari method ini tidak boleh diganti
     */
    public static String generateId(String programStudi, String angkatan, String tanggalLahir){
        // Beberapa line dibawah ini untuk melakukan validasi input (if statement)
        String[] prodi = {"SIK", "SSI", "MIK", "MTI", "DIK"};
        if (angkatan.length() != 4 || !Arrays.asList(prodi).contains(programStudi)
            || 2000 >= Integer.parseInt(angkatan) || Integer.parseInt(angkatan) > 2021
                || !tanggalLahir.matches("[0-9]{2}/[0-9]{2}/[0-9]{4}")) {
            return "Input tidak valid!";
        }

        // Menyiapkan 11 char pertama untuk menghitung Checksum C dan Checksum K
        String id = programStudi + angkatan.substring(2,4) + tanggalLahir.substring(0,2)
                + tanggalLahir.substring(3,5) + tanggalLahir.substring(8,10);

        int j = 11;
        int c = 0;
        for (int i = 0, n = id.length(); i < n; i++, j--) {         // For loop digunakan untuk menghitung Checksum C
            c += (getValueFromChar(id.charAt(i)) * j);
        }
        c %= 36;
        char checkSumC = getCharFromValue(c);
        id += checkSumC;

        int y = 12;
        int k = 0;
        for (int x = 0, n = id.length(); x < n; x++, y--) {         // For loop digunakan untuk menghitung Checksum K
            k += (getValueFromChar(id.charAt(x)) * y);
        }
        k %= 36;
        char checkSumK = getCharFromValue(k);
        id += checkSumK;

        return "ID Anggota: " + id;
    }

    /*
     * Method checkValidity adalah method untuk mengecek validitas ID keanggotaan perpustakaan
     * Parameter dan return type dari method ini tidak boleh diganti
     */
    public static boolean checkValidity(String idAnggota) {
        if (idAnggota.length() != 13) {         // Memastikan idAnggota memiliki 13 char
            return false;
        }
        int j = 11;
        int c = 0;
        for (int i = 0, n = 11; i < n; i++, j--) {
            c += (getValueFromChar(idAnggota.charAt(i)) * j);
        }
        c %= 36;
        char checkSumC = getCharFromValue(c);

        int y = 12;
        int k = 0;
        for (int x = 0, n = 12; x < n; x++, y--) {
            k += (getValueFromChar(idAnggota.charAt(x)) * y);
        }
        k %= 36;
        char checkSumK = getCharFromValue(k);

        // Jika digit ke-11 sama dengan checkSumC dan digit ke-12 sama dengan checkSumK maka validitas bernilai true
        return idAnggota.charAt(11) == checkSumC && idAnggota.charAt(12) == checkSumK;
    }
}
