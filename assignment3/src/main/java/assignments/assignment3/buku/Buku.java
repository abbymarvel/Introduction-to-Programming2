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
    private CanBorrow[] daftarPeminjam;

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

    public void tambahPeminjam(Anggota peminjam){
        if (daftarPeminjam==null){
            this.daftarPeminjam = new CanBorrow[1];
            this.daftarPeminjam[0] = peminjam;
        }else {
            CanBorrow[] tempArr = new CanBorrow[daftarPeminjam.length + 1];
            for (int i = 0; i < this.daftarPeminjam.length; i++) {
                tempArr[i] = this.daftarPeminjam[i];
            }
            tempArr[tempArr.length-1] = peminjam;
            this.daftarPeminjam = tempArr;
        }
    }

    public CanBorrow[] getDaftarPeminjam(){
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
