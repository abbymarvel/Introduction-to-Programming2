package assignments.assignment3;

import assignments.assignment3.buku.Buku;
import assignments.assignment3.buku.Kategori;
import assignments.assignment3.pengguna.Anggota;
import assignments.assignment3.pengguna.Dosen;
import assignments.assignment3.pengguna.Mahasiswa;
import assignments.assignment3.pengguna.Pengguna;
import assignments.assignment3.pengguna.Staf;

import java.time.temporal.JulianFields;
import java.util.Arrays;
import java.util.Scanner;

import javax.lang.model.element.Element;

public class SistakaNG {
    private static Scanner input = new Scanner(System.in);

    private static Pengguna penggunaLoggedIn;

    private static Staf[] daftarStaf;
    private static Anggota[] daftarAnggota;
    private static Kategori[] daftarKategori;
    private static Buku[] daftarbuku;


    public static void main(String[] args) {
        System.out.println("Start - Register Staf...");
        registerStaf();
        System.out.println("Done - Register Staf...\n");
        menu();
        input.close();
    }

    // Method ini digunakan untuk mendaftarkan staf-staf ketika program dijalankan
    private static void registerStaf() {
        String[] listNama = new String[]{"Dek Depe", "Dek DePram", "Dek Sofita", "Winter", "Boo"};
        daftarStaf = new Staf[listNama.length];
        for (int i = 0; i < listNama.length; i++) {
            daftarStaf[i] = new Staf("STAF-" + (i+1), listNama[i]);
            System.out.println("Berhasil menambahkan staf dengan data:");
            System.out.println(daftarStaf[i]);
        }
    }

    // Method ini digunakan untuk mencetak menu utama dari SistakaNG
    public static void menu() {
        boolean hasChosenExit = false;
        System.out.println("Selamat Datang di Sistem Perpustakaan SistakaNG!");
        while (!hasChosenExit) {
            int command = 0;
            System.out.println("================ Menu Utama ================\n");
            System.out.println("1. Login");
            System.out.println("2. Keluar");
            System.out.print("Masukkan pilihan menu: ");
            command = Integer.parseInt(input.nextLine());
            System.out.println();
            if (command == 1) {
                menuLogin();
            } else if (command == 2) {
                System.out.println("Terima kasih telah menggunakan SistakaNG. Sampai jumpa di lain kesempatan!");
                hasChosenExit = true;
            } else {
                System.out.println("Menu tidak dikenal!");
            }
            System.out.println();
        }
    }

    // Method ini digunakan untuk mencetak menu login
    public static void menuLogin() {
        boolean isLoginSuccess = false;
        while (!isLoginSuccess) {
            System.out.println("Masukkan ID Anda untuk login ke sistem");
            System.out.print("ID: ");
            String id = input.nextLine();

            // TODO: Implementasi login -> jika login berhasil, ubah nilai isLoginSuccess menjadi true
            if (daftarAnggota!=null){
                for (int i = 0; i < daftarAnggota.length; i++) {
                    if (daftarAnggota[i].getId().equals(id)) {
                        penggunaLoggedIn = daftarAnggota[i];
                        isLoginSuccess = true;
                    }
                }
            }
            if (daftarStaf!=null){
                for (int i = 0; i < daftarStaf.length; i++) {
                    if (daftarStaf[i].getId().equals(id)) {
                        penggunaLoggedIn = daftarStaf[i];
                        isLoginSuccess = true;
                    }
                }
            }
            System.out.println("Pengguna dengan ID " + id + " tidak ditemukan");
        }
        showMenu();
    }

    // Method ini digunakan untuk mencetak menu yang dapat diakses berdasarkan jenis penggunaLoggedIn
    private static void showMenu() {
        if (penggunaLoggedIn instanceof Staf) {
            showMenuStaf();
        } else {
            showMenuAnggota();
        }
    }

    // Method ini digunakan untuk mencetak menu staf dari SistakaNG
    private static void showMenuStaf() {
        int command = 0;
        boolean hasChosenExit = false;
        while (!hasChosenExit) {
            System.out.println("================ Menu Staf ================\n");
            System.out.println("1. Tambah Anggota");
            System.out.println("2. Tambah Kategori");
            System.out.println("3. Tambah Buku");
            System.out.println("4. Hapus Buku");
            System.out.println("5. 3 Peringkat Pertama");
            System.out.println("6. Detail Anggota");
            System.out.println("7. Daftar Peminjam Buku");
            System.out.println("99. Logout");
            System.out.print("Masukkan pilihan menu: ");
            command = Integer.parseInt(input.nextLine());
            System.out.println();
            if (command == 1) {
                // TODO: Implementasikan menu-nya
                System.out.println("---------- Tambah Anggota ----------");
                System.out.print("Tipe Anggota: ");
                String tipeAnggota = input.nextLine();
                if (tipeAnggota.equals("Mahasiswa")) {
                    System.out.print("Nama : ");
                    String nama = input.nextLine();
                    System.out.print("Program Studi (SIK/SSI/MIK/MTI/DIK): ");
                    String programStudi = input.nextLine();
                    System.out.print("Angkatan: ");
                    String angkatan = input.nextLine();
                    System.out.print("Tanggal Lahir (dd/mm/yyyy): ");
                    String tanggalLahir = input.nextLine();
                    String hasilGenerate = IdGenerator.generateId(programStudi, angkatan, tanggalLahir);
                    if (hasilGenerate.equalsIgnoreCase("Input tidak valid!")){
                        System.out.println("Tidak dapat menambahkan anggota silahkan periksa kembali input anda!");
                    }else {
                        if (daftarAnggota == null){
                            daftarAnggota = new Anggota[1];
                            daftarAnggota[0] = new Mahasiswa("-", nama, 0, 0, tanggalLahir, programStudi, angkatan);
                            System.out.println("Member " + nama + " berhasil ditambahkan dengan data:");
                            System.out.println(daftarAnggota[daftarAnggota.length - 1].toString());
                        } else {
                            Anggota[] tempArr = new Anggota[daftarAnggota.length + 1];
                            for (int i = 0; i < daftarAnggota.length; i++) {
                                tempArr[i] = daftarAnggota[i];
                            }
                            daftarAnggota = tempArr;
                            daftarAnggota[daftarAnggota.length - 1] = new Mahasiswa("-", nama, 0, 0, tanggalLahir, programStudi, angkatan);
                            System.out.println("Member " + nama + " berhasil ditambahkan dengan data:");
                            System.out.println(daftarAnggota[daftarAnggota.length - 1].toString());
                        }
                    }
                } else if (tipeAnggota.equals("Dosen")) {
                    System.out.print("Nama : ");
                    String nama = input.nextLine();
                    if (daftarAnggota == null){
                        daftarAnggota = new Anggota[1];
                        daftarAnggota[0] = new Dosen("-", nama, 0, 0);
                        System.out.println("Member " + nama + " berhasil ditambahkan dengan data:");
                        System.out.println(daftarAnggota[daftarAnggota.length - 1].toString());
                    } else {
                        Anggota[] tempArr = new Anggota[daftarAnggota.length + 1];
                        for (int i = 0; i < daftarAnggota.length; i++) {
                            tempArr[i] = daftarAnggota[i];
                        }
                        daftarAnggota = tempArr;
                        daftarAnggota[daftarAnggota.length - 1] = new Dosen("-", nama, 0, 0);
                        System.out.println("Member " + nama + " berhasil ditambahkan dengan data:");
                        System.out.println(daftarAnggota[daftarAnggota.length - 1].toString());
                    }
                } else{
                    System.out.println("Tipe Anggota "+ tipeAnggota +" tidak valid!");
                }
            } else if (command == 2) {
                // TODO: Implementasikan menu-nya
                System.out.println("---------- Tambah Kategori ----------");
                System.out.print("Nama Kategori: ");
                String kategori = input.nextLine();
                System.out.print("Point: ");
                String point = input.nextLine();
                if (daftarKategori == null) {
                    daftarKategori = new Kategori[1];
                    daftarKategori[0] = new Kategori(kategori, Integer.valueOf(point));
                    System.out.println(daftarKategori[0].toString());
                } else {
                    boolean statusCategory = false;
                    for (int i=0; i<daftarKategori.length; i++) {
                        if (daftarKategori[i].getNama().equalsIgnoreCase(kategori)){
                            statusCategory = true;
                            System.out.println("Kategori " + daftarKategori[i] + " sudah pernah ditambahkan");
                        }
                    }
                    if (statusCategory == false){
                        Kategori[] tempArr = new Kategori[daftarKategori.length+1];
                        for (int j=0; j<daftarKategori.length; j++) {
                            tempArr[j] = daftarKategori[j];
                        }
                        daftarKategori = tempArr;
                        System.out.println(daftarKategori[0].toString());
                    }
                }
            } else if (command == 3) {
                // TODO: Implementasikan menu-nya
                System.out.println("---------- Tambah Buku ----------");
                System.out.print("Judul : ");
                String judul = input.nextLine();;
                System.out.print("Penulis: ");
                String penulis = input.nextLine();
                System.out.print("Penerbit: ");
                String penerbit = input.nextLine();
                System.out.print("Kategori: ");
                String kategori = input.nextLine();
                System.out.print("Stok: ");
                int stok = Integer.parseInt(input.nextLine());
                boolean statusCategory = false;
                boolean statusTitle = true;
                int index = 0;

                if (daftarKategori != null && daftarbuku != null) {
                    for (int i = 0; i < daftarKategori.length; i++) {
                        if (daftarKategori[i].getNama().equalsIgnoreCase(kategori)) {
                            statusCategory = true;
                            index = i;
                        }
                    }
                    for (int i = 0; i < daftarbuku.length; i++) {
                        if (daftarbuku[i].getJudul().equalsIgnoreCase(judul)) {
                            statusTitle = false;
                        }
                    }
                }

                if (statusCategory = false){
                    System.out.println("Kategori " + kategori + " tidak ditemukan");
                } else if (statusTitle = false) {
                    System.out.println("Buku " + judul + " oleh " + penulis + " sudah pernah ditambahkan");
                } else if (Integer.valueOf(stok) > 0){
                    System.out.println("Stok harus lebih dari 0");
                } else {
                    if (daftarbuku == null) {
                        daftarbuku = new Buku[1];
                        daftarbuku[0] = new Buku(judul, penulis, penerbit, Integer.valueOf(stok), daftarKategori[index]);
                        System.out.println("Buku " + judul + " oleh " + penulis + " berhasil ditambahkan");
                    } else {
                        Buku[] tempArr = new Buku[daftarbuku.length + 1];
                        for (int j = 0; j < daftarbuku.length; j++) {
                            tempArr[j] = daftarbuku[j];
                        }
                        daftarbuku = tempArr;
                        daftarbuku[daftarbuku.length-1] = new Buku(judul, penulis, penerbit, Integer.valueOf(stok), daftarKategori[index]);
                        System.out.println("buku " + judul + " oleh " + penulis + " berhasil ditambahkan");
                    }
                }

            } else if (command == 4) {
                // TODO: Implementasikan menu-nya
            } else if (command == 5) {
                // TODO: Implementasikan menu-nya
                Arrays.sort(daftarAnggota);
                System.out.println(Arrays.toString(daftarAnggota));
            } else if (command == 6) {
                // TODO: Implementasikan menu-nya
                System.out.println("---------- Detail Anggota ----------");
                System.out.print("ID Anggota: ");
                String IDAnggota = input.nextLine();
                boolean statusAnggota;
                int indexMember = 0;
                if (daftarAnggota != null){
                    for (int i = 0; i < daftarAnggota.length; i++) {
                        if (daftarAnggota[i].getId().equalsIgnoreCase(IDAnggota)) {
                            System.out.println(daftarAnggota[indexMember].toString());
                            System.out.println("Riwayat Peminjaman Buku :");
                            daftarAnggota[indexMember].detail();
                            statusAnggota = true;
                        }
                    }
                        if (statusAnggota = false){
                            System.out.println("Anggota dengan ID " + IDAnggota + " tidak ditemukan");
                        }
                } else {
                    System.out.println("Anggota dengan ID " + IDAnggota + " tidak ditemukan");
                }
            } else if (command == 7) {
                // TODO: Implementasikan menu-nya
                System.out.println("---------- Daftar Peminjam Buku ----------");
                System.out.print("Judul: ");
                String judul = input.nextLine();
                System.out.print("Penulis: ");
                String penulis = input.nextLine();
                boolean statusTitle;
                for (int i = 0; i < daftarbuku.length; i++) {
                    if (daftarbuku[i].getJudul().equalsIgnoreCase(judul)) {
                        if (daftarbuku[i].getDaftarPeminjam() != null){
                            System.out.println(daftarbuku[i]);
                            System.out.println("---------- Daftar Peminjam ----------");
                            for (int j = 0; j < daftarbuku[i].getDaftarPeminjam().length; j++){
                                System.out.println("-----------------" + j+1 + "-----------------");
                                System.out.print(daftarbuku[i].getDaftarPeminjam()); // masukin peminjam ke array daftar peminjam terlebih dahulu
                            }
                        } else{
                            System.out.println(daftarbuku[i]);
                            System.out.println("Belum ada anggota yang meminjam buku " + daftarbuku[i].getJudul());
                        }
                    }
                }
            } else if (command == 99) {
                System.out.println("Terima kasih telah menggunakan SistakaNG!");
                hasChosenExit = true;
            } else {
                System.out.println("Menu tidak dikenal!");
            }
            System.out.println();
        }
    }

    // Method ini digunakan untuk mencetak menu anggota dari SistakaNG
    private static void showMenuAnggota() {
        int command = 0;
        boolean hasChosenExit = false;
        while (!hasChosenExit) {
            System.out.println("================ Menu Anggota ================\n");
            System.out.println("1. Peminjaman");
            System.out.println("2. Pengembalian");
            System.out.println("3. Pembayaran Denda");
            System.out.println("4. Detail Anggota");
            System.out.println("99. Logout");
            System.out.print("Masukkan pilihan menu: ");
            command = Integer.parseInt(input.nextLine());
            System.out.println();
            if (command == 1) {
                // TODO: Implementasikan menu-nya
            } else if (command == 2) {
                // TODO: Implementasikan menu-nya
            } else if (command == 3) {
                // TODO: Implementasikan menu-nya
            } else if (command == 4) {
                // TODO: Implementasikan menu-nya
            } else if (command == 99) {
                System.out.println("Terima kasih telah menggunakan SistakaNG!");
                hasChosenExit = true;
            } else {
                System.out.println("Menu tidak dikenal!");
            }
            System.out.println();
        }
    }
}