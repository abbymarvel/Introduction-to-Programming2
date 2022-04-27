package assignments.assignment3.pengguna;

import assignments.assignment3.buku.Buku;

public interface CanBorrow {
    public String pinjam(Buku buku, String tanggalPeminjaman);

    public String kembali(Buku buku, String tanggalPengembalian);
}
