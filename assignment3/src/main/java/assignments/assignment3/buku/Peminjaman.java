package assignments.assignment3.buku;

import assignments.assignment3.pengguna.Anggota;

public class Peminjaman {
    public final static long DENDA_PER_HARI = 3000;
    private Anggota anggota;
    private Buku buku;
    private String tanggalPeminjaman;
    private String tanggalPengembalian;
    private long denda;
    private boolean status;

    @Override
    public String toString() {
        return buku
                + "Tanggal Peminjaman: " + tanggalPeminjaman
                + "Tanggal Pengembalian: " + tanggalPengembalian
                + "Denda: Rp" + denda;
    }

    public Peminjaman(Anggota anggota, Buku buku, String tanggalPeminjaman, String tanggalPengembalian, long denda, boolean status){
        this.anggota = anggota;
        this.buku = buku;
        this.tanggalPeminjaman = tanggalPeminjaman;
        this.tanggalPengembalian = tanggalPengembalian;
        this.denda = denda;
        this.status = status;
    }
    
    public Anggota getAnggota() {
        return anggota;
    }

    public Buku getBuku() {
        return buku;
    }

    public String getTanggalPeminjaman() {
        return tanggalPeminjaman;
    }

    public String getTanggalPengembalian() {
        return tanggalPengembalian;
    }

    public long getDenda() {
        return denda;
    }

    public boolean getStatus(){
        return status;
    }

    public void setStatus(boolean status){
        this.status = status;
    }

}
