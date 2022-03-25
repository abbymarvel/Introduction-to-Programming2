package assignments.assignment2;

import java.util.HashMap;
import java.util.Scanner;

public class Library {
    static HashMap<Character, Integer> charToValue = new HashMap<>(36);
    static char[] valueToChar = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
    private Scanner input = new Scanner(System.in);
    private Member[] members;
    private Book[] books;
    private Category[] categories;

    public static void buildMapCharToValue() {
        for (int count=0; count < valueToChar.length; count++) {
            charToValue.put(valueToChar[count], count);
        }
    }

    private static char getCharFromValue(int value) {
        return valueToChar[value];
    }

    private static int getValueFromChar(char character) {
        return charToValue.get(character);
    }

    private static boolean isValidProgramStudi(String programStudi) {
        if (programStudi.length() != 3) return false;

        if (programStudi.equals("SIK")) return true;
        if (programStudi.equals("SSI")) return true;
        if (programStudi.equals("MIK")) return true;
        if (programStudi.equals("MTI")) return true;
        if (programStudi.equals("DIK")) return true;

        return false;
    }

    private static String checkAndGetAngkatanCode(String angkatan) {
        if (angkatan.length() != 4) return "Input tidak valid!";
        if (Integer.parseInt(angkatan) < 2000 || Integer.parseInt(angkatan) > 2021) return "Input tidak valid!";
        return angkatan.substring(2);
    }

    private static boolean isNumerik(String word) {
        if (word.isEmpty()) return false;

        for (char c : word.toCharArray()) {
            if (!Character.isDigit(c)) return false;
        }

        return true;
    }

    private static String checkAndGetTanggalLahirCode(String tanggalLahir) {
        String[] arrOfTanggalLahir = tanggalLahir.split("/");

        // Cek apakah ada 3 input (untuk dd, mm, dan yyyy)
        if (arrOfTanggalLahir.length != 3) {
            return "Input tidak valid!";
        }

        // Cek apakah semuanya numerik
        for (String s : arrOfTanggalLahir) {
            if (!isNumerik(s)) {
                return "Input tidak valid!";
            }
        }

        // Cek apakah jumlah digitnya memenuhi aturan (2 digit untuk tanggal dan bulan, serta 4 digit untuk year)
        if (arrOfTanggalLahir[0].length() != 2 || arrOfTanggalLahir[1].length() != 2 || arrOfTanggalLahir[2].length() != 4) {
            return "Input tidak valid!";
        }

        // Cek apakah memenuhi aturan tanggal (tanggal antara 1 - 31)
        int tanggal = Integer.parseInt(arrOfTanggalLahir[0]);
        if (tanggal < 1 || tanggal > 31) {
            return "Input tidak valid!";
        }

        // Cek apakah memenuhi aturan bulan (bulan antara 1 - 12)
        int bulan = Integer.parseInt(arrOfTanggalLahir[1]);
        if (bulan < 1 || bulan > 12) {
            return "Input tidak valid!";
        }

        return arrOfTanggalLahir[0] + arrOfTanggalLahir[1] + arrOfTanggalLahir[2].substring(2);
    }

    // Menghitung CheckSum untuk mengahsilkan ID Anggota
    private static char getChecksum(String data) {
        char[] arrayOfChar = data.toCharArray();

        int count = 0;
        for (int idx = 0; idx < arrayOfChar.length; idx++) {
            // Mendapatkan bobot
            int weight = arrayOfChar.length - idx;

            // Jumlah hasil kali value dan bobot setiap karakter
            count += getValueFromChar(arrayOfChar[idx]) * weight;
        }

        int checksum = count % 36;
        return getCharFromValue(checksum);
    }

    // Generate ID Anggota saat member baru terdaftar
    public static String generateId(String programStudi, String angkatan, String tanggalLahir){
        if (!isValidProgramStudi(programStudi)) return "Input tidak valid!";

        String angkatanCode = checkAndGetAngkatanCode(angkatan);
        if (angkatanCode.length() > 2) return angkatanCode; // Input tidak valid!

        String tanggalLahirCode = checkAndGetTanggalLahirCode(tanggalLahir);
        if (tanggalLahirCode.length() > 6) return tanggalLahirCode; // Input tidak valid!

        String nomorKeanggotaanStr = programStudi + angkatanCode + tanggalLahirCode;
        nomorKeanggotaanStr += getChecksum(nomorKeanggotaanStr); // Checksum "C"
        nomorKeanggotaanStr += getChecksum(nomorKeanggotaanStr); // Checksum "K"

        return nomorKeanggotaanStr;
    }

    public static void main(String[] args) {
        buildMapCharToValue();
        Library program = new Library();
        program.menu();
    }

    public void menu() {
        int command = 0;
        boolean hasChosenExit = false;
        System.out.println("Selamat Datang di Sistem Perpustakaan SistakaNG!");
        while (!hasChosenExit) {
            System.out.println("================ Menu Utama ================\n");
            System.out.println("1. Tambah Anggota");
            System.out.println("2. Tambah Kategori");
            System.out.println("3. Tambah Buku");
            System.out.println("4. Peminjaman");
            System.out.println("5. Pengembalian");
            System.out.println("6. Pembayaran Denda");
            System.out.println("7. Detail Anggota");
            System.out.println("8. 3 Peringkat Pertama");
            System.out.println("99. Keluar");
            System.out.print("Masukkan pilihan menu: ");
            command = Integer.parseInt(input.nextLine());
            System.out.println();
            if (command == 1) {
                // Menambahkan Anggota Baru ke dalam Class Member dan Membuat ID Anggota Baru
                System.out.println("---------- Tambah Anggota ----------");
                System.out.print("Nama : ");
                String nama = input.nextLine();
                System.out.print("Program Studi (SIK/SSI/MIK/MTI/DIK): ");
                String programStudi = input.nextLine();
                System.out.print("Angkatan: ");
                String angkatan = input.nextLine();
                System.out.print("Tanggal Lahir (dd/mm/yyyy): ");
                String tanggalLahir = input.nextLine();

                String hasilGenerate = generateId(programStudi, angkatan, tanggalLahir);
                if (hasilGenerate.equalsIgnoreCase("Input tidak valid!")){
                    System.out.println("Input tidak valid!");
                }else {
                    String nomorKeanggotaanStr = hasilGenerate;
                    if (members == null){
                        members = new Member[1];
                        members[0] = new Member(nomorKeanggotaanStr, nama, tanggalLahir, programStudi, angkatan, 0, 0);
                        System.out.println("Member " + nama + " berhasil ditambahkan dengan data:");
                        System.out.println(members[members.length - 1].toString());
                    } else {
                        Member[] tempArr = new Member[members.length + 1];
                        for (int i = 0; i < members.length; i++) {
                            tempArr[i] = members[i];
                        }
                        members = tempArr;
                        members[members.length - 1] = new Member(nomorKeanggotaanStr, nama, tanggalLahir, programStudi, angkatan, 0, 0);
                        System.out.println("Member " + nama + " berhasil ditambahkan dengan data:");
                        System.out.println(members[members.length - 1].toString());
                    }
                }
                // Menambahkan Kategori Baru Beserta Pointnya ke dalam Class Category
            } else if (command == 2) {
                // TODO
                System.out.println("---------- Tambah Kategori ----------");
                System.out.print("Nama Kategori: ");
                String category = input.nextLine();
                System.out.print("Point: ");
                String point = input.nextLine();
                if (categories == null) {
                    categories = new Category[1];
                    categories[0] = new Category(category, Integer.valueOf(point));
                    System.out.println(categories[0].toString());
                } else {
                    boolean statusCategory = false;
                    for (int i=0; i<categories.length; i++) {
                        if (categories[i].getName().equalsIgnoreCase(category)){
                            statusCategory = true;
                            System.out.println("Kategori " + categories[i] + " sudah pernah ditambahkan");
                        }
                    }
                    if (statusCategory == false){
                        Category[] tempArr = new Category[categories.length+1];
                        for (int j=0; j<categories.length; j++) {
                            tempArr[j] = categories[j];
                        }
                        categories = tempArr;
                        System.out.println(categories[0].toString());
                    }
                }
                // Menambahkan Buku Baru ke dalam Class Book, Nantinya Akan Dipinjam oleh Anggota
            } else if (command == 3) {
                // TODO
                System.out.println("---------- Tambah Buku ----------");
                System.out.print("Judul : ");
                String title = input.nextLine();;
                System.out.print("Penulis: ");
                String author = input.nextLine();
                System.out.print("Penerbit: ");
                String publisher = input.nextLine();
                System.out.print("Kategori: ");
                String category = input.nextLine();
                System.out.print("Stok: ");
                int stok = Integer.parseInt(input.nextLine());
                boolean statusCategory = false;
                int index = 0;
                if (categories != null) {
                    for (int i = 0; i < categories.length; i++) {
                        if (categories[i].getName().equalsIgnoreCase(category)) {
                            statusCategory = true;
                            index += i;
                            break;
                        }
                    }
                }

                boolean statusTitle = true;
                if (books != null) {
                    for (int i = 0; i < books.length; i++) {
                        if (books[i].getTitle().equalsIgnoreCase(title)) {
                            statusTitle = false;
                        }
                    }
                }

                if (statusCategory == true) {
                    if (statusTitle == true) {
                        if (Integer.valueOf(stok) > 0) {
                            if (books == null) {
                                books = new Book[1];
                                books[0] = new Book(title, author, publisher, Integer.valueOf(stok), categories[index]);
                                System.out.println("Buku " + title + " oleh " + author + " berhasil ditambahkan");
                            } else {
                                Book[] tempArr = new Book[books.length + 1];
                                for (int j = 0; j < books.length; j++) {
                                    tempArr[j] = books[j];
                                }
                                books = tempArr;
                                books[books.length-1] = new Book(title, author, publisher, Integer.valueOf(stok), categories[index]);
                                System.out.println("buku " + title + " oleh " + author + " berhasil ditambahkan");
                            }
                        } else {
                            System.out.println("Stok harus lebih dari 0");
                        }
                    } else {
                        System.out.println("Buku " + title + " oleh " + author + " sudah pernah ditambahkan");
                    }
                } else {
                        System.out.println("Kategori " + category + " tidak ditemukan");
                    }
                // Memproses Peminjaman Buku oleh Anggota Perpus
            } else if (command == 4) {
                // TODO
                System.out.println("---------- Peminjaman Buku ----------");
                System.out.print("ID Anggota: ");
                String IDAnggota = input.nextLine();
                System.out.print("Judul Buku: ");
                String title = input.nextLine();
                System.out.print("Penulis Buku: ");
                String author = input.nextLine();
                System.out.print("Tanggal Peminjaman: ");
                String loanDate = input.nextLine();
                int indexMember = 0;
                int indexBook = 0;
                boolean statusAnggota = false;
                boolean statusPeminjam = false;
                boolean statusDenda = true;
                boolean statusBukuSedangPinjam = true;
                if (members == null){
                    statusAnggota = false;
                }else {
                    for (int i = 0; i < members.length; i++) {
                        if (members[i].getId().equalsIgnoreCase(IDAnggota)) {
                            statusAnggota = true;
                            indexMember = i;
                            if (members[i].getBookLoans() == null){
                                statusPeminjam = true;
                                break;
                            }else if (members[i].getBookLoans().length == 3){
                                statusPeminjam = false;
                                break;
                            }else {
                                statusPeminjam = true;
                                for (int j = 0; j<members[i].getBookLoans().length; j++){
                                    if (!members[i].getBookLoans()[j].equals(title)){
                                        statusBukuSedangPinjam = false;
                                        break;
                                    }
                                }
                            }
                            if (members[i].getFine() >= 5000){
                                statusDenda = false;
                            }else{
                                statusDenda = true;
                            }
                        }
                    }
                }
                boolean statusBuku = false;
                boolean statusStok = false;
                if (books == null){
                    statusBuku = false;
                }else {
                    for (int i = 0; i < books.length; i++) {
                        if (books[i].getTitle().equalsIgnoreCase(title) && books[i].getAuthor().equalsIgnoreCase(author)) {
                            title = String.valueOf(books[i]);
                            author = String.valueOf(books[i].getAuthor());
                            statusBuku = true;
                            if (books[i].getStok() > 0) {
                                statusStok = true;
                                indexBook = i;
                                break;
                            }
                        }
                    }
                }
                if (statusAnggota == true){
                    if (statusBuku == true){
                        if (statusStok == true){
                            if (statusPeminjam == true){
                                if (statusDenda == true){
                                    if (statusBukuSedangPinjam == true){
                                        members[indexMember].pinjam(books[indexBook], loanDate);
                                    }else {
                                        System.out.println("Buku " + title + " oleh " + author + " sedang dipinjam");
                                    }
                                }else {
                                    System.out.println("Denda lebih dari Rp 5000");
                                }
                            }else {
                                System.out.println("Jumlah buku yang sedang dipinjam sudah mencapai batas maksimal");
                            }
                        }else {
                            System.out.println("Buku " + title + " oleh " + author + " tidak tersedia");
                        }
                    }else {
                        System.out.println("Buku " + title + " oleh " + author + " tidak ditemukan");
                    }
                }else {
                    System.out.println("Anggota dengan ID "+ IDAnggota + " tidak ditemukan");
                }

                // Memproses Pengembalian Buku oleh Anggota Perpus
            } else if (command == 5) {
                // TODO
                System.out.println("---------- Pengembalian Buku ----------");
                System.out.print("ID Anggota: ");
                String IDAnggota = input.nextLine();
                System.out.print("Judul Buku: ");
                String title = input.nextLine();
                System.out.print("Penulis Buku: ");
                String author = input.nextLine();
                System.out.print("Tanggal Pengembalian: ");
                String returnDate = input.nextLine();
                boolean statusAnggota = false;
                boolean statusBuku = false;
                boolean statusMeminjam = false;
                int indexMember = 0;
                int indexBook = 0;
                if (members == null){
                    statusAnggota = false;
                }else {
                    for (int i = 0; i < members.length; i++) {
                        if (members[i].getId().equalsIgnoreCase(IDAnggota)) {
                            indexMember = i;
                            statusAnggota = true;
                            for (int j = 0; j < members[i].getBookLoans().length; j++) {
                                if (!members[i].getBookLoans()[j].equals(title)) {
                                    statusMeminjam = true;
                                    break;
                                }
                            }
                        }
                    }
                }

                for (int i = 0; i < books.length; i++) {
                    if (books[i].getTitle().equalsIgnoreCase(title)) {
                        indexBook = i;
                        title = String.valueOf(books[i]);
                        author = String.valueOf(books[i].getAuthor());
                        statusBuku = true;
                        }
                    }

                if (statusAnggota == true){
                    if (statusBuku == true){
                        if (statusMeminjam == true){
                            members[indexMember].kembali(books[indexBook], returnDate);
                        } else {
                            System.out.println("Buku " + title + " tidak sedang dipinjam");
                        }
                    } else {
                        System.out.println("Buku " + title + " oleh " + author + " tidak ditemukan");
                    }
                } else {
                    System.out.println("Anggota dengan ID " + IDAnggota + " tidak ditemukan");
                }

                // Memproses pembayaran denda yang akan dilakukan oleh anggota
            } else if (command == 6) {
                System.out.println("---------- Pembayaran Denda ----------");
                System.out.print("ID Anggota: ");
                String IDAnggota = input.nextLine();
                System.out.print("Jumlah: ");
                String amount = input.nextLine();
                boolean statusAnggota = false;
                boolean statusDenda = false;
                int indexMember = 0;
                if (members == null){
                    statusAnggota = false;
                }else {
                    for (int i = 0; i < members.length; i++) {
                        if (members[i].getId().equalsIgnoreCase(IDAnggota)) {
                            statusAnggota = true;
                            indexMember = i;
                            if (members[i].getFine() != 0){
                                statusDenda = true;
                            }
                                }
                            }
                        }
                if (statusAnggota == true){
                    if (statusDenda == true){
                        members[indexMember].bayarDenda(Long.valueOf(amount));
                    } else {
                        System.out.println(members[indexMember].getName() + " tidak memiliki denda");
                    }
                }else {
                    System.out.println("Anggota dengan ID " + IDAnggota + " tidak ditemukan");
                }
                // Mencetak detail anggota sesuai dengan ID anggota perpus dari input
            } else if (command == 7) {
                System.out.println("---------- Detail Anggota ----------");
                System.out.print("ID Anggota: ");
                String IDAnggota = input.nextLine();
                boolean statusAnggota = false;
                int indexMember = 0;
                if (members == null){
                    statusAnggota = false;
                } else {
                    for (int i = 0; i < members.length; i++) {
                        if (members[i].getId().equalsIgnoreCase(IDAnggota)) {
                            statusAnggota = true;
                            indexMember = i;
                            }
                        }
                    }
                if (statusAnggota == true) {
                    System.out.println(members[indexMember].toString());
                    System.out.println("Riwayat Peminjaman Buku :");
                    members[indexMember].detail();
                }else {
                    System.out.println("Anggota dengan ID " + IDAnggota + " tidak ditemukan");
                }

                // Mencetak 3 angggota perpus dengan point terbanyak
            } else if (command == 8) {
                System.out.println("---------- Peringkat Anggota ----------");
                Member[] tempArr = new Member[members.length];
                for (int i = 0; i< members.length; i++){
                    tempArr[i]= members[i];
                }
                //sorting logic
                for (int i = 0; i < tempArr.length; i++)
                {
                    for (int j = i + 1; j < tempArr.length; j++)
                    {
                        int tmp = 0;
                        if (tempArr[i].getPoint() > tempArr[j].getPoint())
                        {
                            tmp = tempArr[i].getPoint();
                            tempArr[i] = tempArr[j];
                            tempArr[j].setPoint(tmp);
                        }
                    }
                    //prints the sorted element of the array
                    System.out.println(tempArr[i]);
                }
                // Keluar dari program
            } else if (command == 99) {
                System.out.println("Terima kasih telah menggunakan SistakaNG!");
                hasChosenExit = true;
            } else {
                System.out.println("Menu tidak dikenal!");
            }
            System.out.println();
        }

        input.close();
    }
}
