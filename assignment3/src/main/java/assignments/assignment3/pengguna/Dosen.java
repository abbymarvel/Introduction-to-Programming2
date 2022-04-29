package assignments.assignment3.pengguna;

import javax.lang.model.element.Element;

import assignments.assignment3.buku.Buku;
import assignments.assignment3.buku.Peminjaman;

public class Dosen extends Anggota{
    private static int jumlahDosen = 0;
    public int BATAS_JUMLAH_PEMINJAMAN_BUKU = 5;
    public long BATAS_MAKSIMAL_DENDA = 10000;
    
    public Dosen(String nama, long denda, int poin){
        super(nama, denda, poin);
        setId(generateId());
    }

    @Override
    protected String generateId(){
        String id = "DOSEN-" + ++jumlahDosen;
        return id;
    }

    public String pinjam(Buku buku, String tanggalPeminjaman){
        int pemijamanAktif = 0;
        boolean apakahDiPinjam = false;
        if (daftarPeminjaman!=null){
            for (Peminjaman p: daftarPeminjaman){
                if (p.getStatus() == true){
                    pemijamanAktif++;
                }
                if (p.getBuku().equals(buku) && p.getStatus() == true){
                    apakahDiPinjam = true;
                }
            }
        }
        if (pemijamanAktif==BATAS_JUMLAH_PEMINJAMAN_BUKU){
            return "Jumlah buku yang sedang dipinjam sudah mencapai batas maksimal";
        } else{
            if (this.getDenda()<=BATAS_MAKSIMAL_DENDA){
                if (daftarPeminjaman == null){
                    daftarPeminjaman = new Peminjaman[1];
                    daftarPeminjaman[0] = new Peminjaman(this, buku, tanggalPeminjaman, "-", getDenda(), true);
                    return getNama() + " berhasil meminjam Buku " + buku.getJudul() + "!";
                } else{
                    if (apakahDiPinjam == false){
                    Peminjaman[] tempArr = new Peminjaman[daftarPeminjaman.length + 1];
                    for (int i = 0; i < daftarPeminjaman.length; i++) {
                        tempArr[i] = daftarPeminjaman[i];
                    }
                    daftarPeminjaman = tempArr;
                    daftarPeminjaman[daftarPeminjaman.length - 1] = new Peminjaman(this, buku, tanggalPeminjaman, "-", getDenda(), true);
                    buku.setStok(buku.getStok() - 1);
                    return getNama() + " berhasil meminjam Buku " + buku.getJudul() + "!";
                    } else{
                        return "Buku " + buku.getJudul() + " oleh " + buku.getPenulis() + " sedang dipinjam";
                    }
                }
            } else{
                return "Denda lebih dari Rp " + BATAS_MAKSIMAL_DENDA;
            }
        }
    }

    public long getBATAS_MAKSIMAL_DENDA() {
        return BATAS_MAKSIMAL_DENDA;
    }

    public int getBATAS_JUMLAH_PEMINJAMAN_BUKU() {
        return BATAS_JUMLAH_PEMINJAMAN_BUKU;
    }

}
