package assignments.assignment3.pengguna;

import assignments.assignment3.IdGenerator;
import assignments.assignment3.buku.Buku;
import assignments.assignment3.buku.Peminjaman;

public class Mahasiswa extends Anggota{
    private final int BATAS_JUMLAH_PEMINJAMAN_BUKU = 3;
    private final long BATAS_MAKSIMAL_DENDA = 5000;
    private String tanggalLahir;
    private String programStudi;
    private String angkatan;

    Mahasiswa(String id, String nama, long denda, int poin, Peminjaman[] daftarPeminjaman, String tanggalLahir, String programStudi, String angkatan){
        super(id, nama, denda, poin, daftarPeminjaman);
        this.tanggalLahir = tanggalLahir;
        this.programStudi = programStudi;
        this.angkatan = angkatan;
    }

    @Override
    public String generateId() {
        return IdGenerator.generateId(programStudi, angkatan, tanggalLahir);
    }

    String pinjam(Buku buku, String tanggalPeminjaman){
        Peminjaman[] daftarPeminjaman = getDaftarPeminjaman();
        Peminjaman[] tempArr = new Peminjaman[daftarPeminjaman.length + 1];
        for (int i = 0; i < daftarPeminjaman.length; i++) {
            tempArr[i] = daftarPeminjaman[i];
        }
        daftarPeminjaman = tempArr;
        daftarPeminjaman[daftarPeminjaman.length - 1] = new Peminjaman(this, buku, tanggalPeminjaman, "-", getDenda(), true);
        buku.setStok(buku.getStok() - 1);
        return getNama() + " berhasil meminjam Buku " + buku.getJudul() + "!";
    }

    public long getBATAS_MAKSIMAL_DENDA() {
        return BATAS_MAKSIMAL_DENDA;
    }

    public int getBATAS_JUMLAH_PEMINJAMAN_BUKU() {
        return BATAS_JUMLAH_PEMINJAMAN_BUKU;
    }
}
