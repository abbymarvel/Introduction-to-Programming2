package assignments.assignment3.pengguna;

import assignments.assignment3.IdGenerator;
import assignments.assignment3.buku.Buku;
import assignments.assignment3.buku.Peminjaman;

public class Mahasiswa extends Anggota{
    public final int BATAS_JUMLAH_PEMINJAMAN_BUKU = 3;
    public final long BATAS_MAKSIMAL_DENDA = 5000;
    private String tanggalLahir;
    private String programStudi;
    private String angkatan;

    public Mahasiswa(String nama, long denda, int poin, String tanggalLahir, String programStudi, String angkatan){
        super(nama, denda, poin);
        this.tanggalLahir = tanggalLahir;
        this.programStudi = programStudi;
        this.angkatan = angkatan;
        setId(generateId());
    }

    @Override
    protected String generateId() {
        return IdGenerator.generateId(getProgramStudi(), getAngkatan(), getTanggalLahir());
    }

    public String pinjam(Buku buku, String tanggalPeminjaman){
        if (daftarPeminjaman==null){
            daftarPeminjaman = new Peminjaman[1];
            daftarPeminjaman[0] = new Peminjaman(this, buku, tanggalPeminjaman, "-", getDenda(), true);
            buku.setStok(buku.getStok() - 1);
            Buku.tambahPeminjam(this);
            return getNama() + " berhasil meminjam Buku " + buku.getJudul() + "!";
        }else {
            Peminjaman[] tempArr = new Peminjaman[daftarPeminjaman.length + 1];
            for (int i = 0; i < daftarPeminjaman.length; i++) {
                tempArr[i] = daftarPeminjaman[i];
            }
            daftarPeminjaman = tempArr;
            daftarPeminjaman[daftarPeminjaman.length - 1] = new Peminjaman(this, buku, tanggalPeminjaman, "-", getDenda(), true);
            buku.setStok(buku.getStok() - 1);
            Buku.tambahPeminjam(this);
            return getNama() + " berhasil meminjam Buku " + buku.getJudul() + "!";
        }
    }

    public String getProgramStudi() {
        return programStudi;
    }

    public String getAngkatan(){
        return angkatan;
    }

    public String getTanggalLahir(){
        return tanggalLahir;
    }
}
