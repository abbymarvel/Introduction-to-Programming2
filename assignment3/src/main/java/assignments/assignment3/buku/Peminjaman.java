package assignments.assignment3.buku;

import assignments.assignment3.pengguna.Anggota;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.text.SimpleDateFormat;

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
        buku.tambahPeminjam(anggota);
    }

    public long hitungDenda(){
        long denda = 0;
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

        try {
            Date tanggalMinjam = format.parse(getTanggalPeminjaman());
            Date tanggalBalik = format.parse(getTanggalPengembalian());

            // get the difference between two dates in minutes
            long diff = Math.abs(tanggalMinjam.getTime() - tanggalBalik.getTime()) / (1000*60*60*24);
            if (diff - 7 > 0) {
                denda = ((diff - 7) * Peminjaman.DENDA_PER_HARI);
            } 
        } catch (java.text.ParseException e) {
            e.printStackTrace();
        }
        return denda;
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

    public void setTanggalPengembalian(String tanggalPengembalian) {
        this.tanggalPengembalian = tanggalPengembalian;
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
