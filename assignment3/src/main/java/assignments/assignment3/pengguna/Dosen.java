package assignments.assignment3.pengguna;

import assignments.assignment3.buku.Buku;
import assignments.assignment3.buku.Peminjaman;

public class Dosen extends Anggota{
    int jumlahDosen = 0;
    int BATAS_JUMLAH_PEMINJAMAN_BUKU = 5;
    long BATAS_MAKSIMAL_DENDA = 10000;
    
    Dosen(String id, String nama, long denda, int poin, Peminjaman[] daftarPeminjaman){
        super(id, nama, denda, poin, daftarPeminjaman);
    }

    @Override
    public String generateId(){
        return "Dosen-" + jumlahDosen;
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
