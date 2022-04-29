package assignments.assignment3.buku;

import assignments.assignment3.pengguna.Anggota;
import assignments.assignment3.pengguna.CanBorrow;

public class Buku{
    private String judul;
    private String penulis;
    private String penerbit;
    private int stokAwal;
    private int stok;
    private Kategori kategori;
    private static CanBorrow[] daftarPeminjam;

    @Override
    public String toString() {
        return "Judul Buku: " + judul
                + "\nPenulis Buku: " + penulis
                + "\nPenerbit Buku: " + penerbit
                + "\n" + kategori.toString();
    }

    public Buku(String judul, String penulis, String penerbit, int stokAwal, Kategori kategori){
        this.judul = judul;
        this.penulis = penulis;
        this.penerbit = penerbit;
        this.stokAwal = stokAwal;
        this.kategori = kategori;
        this.stok = stokAwal;
    }

    public static void tambahPeminjam(Anggota peminjam){
        if (daftarPeminjam==null){
            CanBorrow[] dafarPeminjam = new CanBorrow[1];
            dafarPeminjam[0] = (CanBorrow) peminjam;
        }else {
            CanBorrow[] tempArr = new CanBorrow[daftarPeminjam.length + 1];
            for (int i = 0; i < daftarPeminjam.length; i++) {
                tempArr[i] = daftarPeminjam[i];
            }
            tempArr[daftarPeminjam.length] = peminjam;
            daftarPeminjam = tempArr;
            daftarPeminjam[daftarPeminjam.length - 1] = (CanBorrow) peminjam;
        }
    }

    public static CanBorrow[] getDaftarPeminjam(){
        return daftarPeminjam;
    }

    public String getJudul() {
        return judul;
    }

    public String getPenulis() {
        return penulis;
    }

    public String getPenerbit() {
        return penerbit;
    }

    public int getStokAwal() {
        return stokAwal;
    }

    public void setStok(int stok){
        this.stok = stok;
    }

    public int getStok(){
        return stok;
    }

    public Kategori getKategori(){
        return kategori;
    }
}
