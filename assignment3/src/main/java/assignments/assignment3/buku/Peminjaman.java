package assignments.assignment3.buku;

import assignments.assignment3.pengguna.Anggota;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

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
        String d1 = tanggalPeminjaman;
        String d2 = tanggalPengembalian;

        String pattern = "dd/MM/yyyy";
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);

        try {
            Date date1 = (Date) sdf.parse(d2);
            Date date2 = (Date) sdf.parse(d1);

            // get the difference between two dates in minutes
            long elapsedms = date1.getTime() - date2.getTime();
            long days_difference = (elapsedms / (1000*60*60*24)) % 365;
            if (days_difference > 7) {
                denda = ((days_difference - 7) * Peminjaman.DENDA_PER_HARI);
            } else {
                denda = 0;
            }
        } catch (ParseException e) {
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
