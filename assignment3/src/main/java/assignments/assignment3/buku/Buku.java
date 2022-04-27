package assignments.assignment3.buku;

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
                + "\nKategori: " + kategori
                + "\nPoin: " + kategori.getPoin();
    }

    public Buku(String judul, String penulis, String penerbit, int stokAwal, Kategori kategori){
        this.judul = judul;
        this.penulis = penulis;
        this.penerbit = penerbit;
        this.stokAwal = stokAwal;
        this.kategori = kategori;
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
