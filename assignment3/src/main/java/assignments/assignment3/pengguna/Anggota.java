package assignments.assignment3.pengguna;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import assignments.assignment3.buku.Buku;
import assignments.assignment3.buku.Peminjaman;

public abstract class Anggota extends Pengguna implements Comparable <Anggota>{
    protected long denda;
    protected int poin;
    protected Peminjaman[] daftarPeminjaman;
    
    public Anggota (String id, String nama, long denda, int poin){
        super(id, nama);
        this.denda = denda;
        this.poin = poin;
    }

    @Override
    public int compareTo(Anggota other) {
        if (this.poin > other.getPoin()){
            return 1;
        } else if (this.poin < other.getPoin()){
            return -1;
        } else {
            return 0;
        }
    } //https://www.codejava.net/java-core/collections/sorting-arrays-examples-with-comparable-and-comparator#:~:text=Sorting%20an%20array%20of%20Objects&text=The%20natural%20ordering%20is%20defined,%3E%20obj2%20if%20x%20%3E%200.

    @Override
    public String toString() {
        return "ID Anggota: " + getId()
                + "\nNama Anggota: " + getNama()
                + "\nTotal poin: " + poin
                + "\nDenda: " + denda;
    }

    public void detail() {
        if (daftarPeminjaman != null) {
            for (int h = 1; h < daftarPeminjaman.length+1; h++) {
                for (int i = 0; i < daftarPeminjaman.length; i++) {
                    System.out.println("—------------- " + h + " —-------------");
                    Buku buku = daftarPeminjaman[i].getBuku();
                    System.out.println("Judul Buku: " + buku.getJudul());
                    System.out.println("Penulis Buku: " + buku.getPenulis());
                    System.out.println("Penerbit Buku: " + buku.getPenerbit());
                    System.out.println("Kategori: " + buku.getKategori().getNama());
                    System.out.println("Point: " + buku.getKategori().getPoin());
                    System.out.println("Tanggal Peminjaman: " + daftarPeminjaman[i].getTanggalPeminjaman());
                    System.out.println("Tanggal Pengembalian: " + daftarPeminjaman[i].getTanggalPengembalian());
                    System.out.println("Denda: Rp " + daftarPeminjaman[i].getDenda());

                }
            }
        }else{
            System.out.println("Belum pernah meminjam buku");
        }
    }

    public String bayarDenda(long jumlahBayar){
        if (denda==0){
            return getNama() + "tidak memiliki denda";
        }else if (jumlahBayar>denda){
            setDenda(0);
            return getNama() + " berhasil membayar lunas denda"
                    +"\nJumlah kembalian: Rp " + (jumlahBayar - denda);
        } else {
            setDenda(denda-jumlahBayar);
            return getNama() + " berhasil membayar denda sebesar Rp " + jumlahBayar
                    + "\nSisa denda saat ini: Rp " + denda;

        }
    }

    public String kembali(Buku buku, String tanggalPengembalian){
        String loanDate = "";
        int indexLoanBook = 0;
        for (int j = 0; j<daftarPeminjaman.length; j++){
            if (daftarPeminjaman[j].getBuku().equals(buku)){
                loanDate = daftarPeminjaman[j].getTanggalPeminjaman();
                indexLoanBook = j;
            }
        }
        if (daftarPeminjaman[indexLoanBook].getStatus() == true) {
            if (daftarPeminjaman != null) {
                String d1 = loanDate;
                String d2 = tanggalPengembalian;

                String pattern = "dd/MM/yyyy";
                SimpleDateFormat sdf = new SimpleDateFormat(pattern);

                try {
                    Date date1 = (Date) sdf.parse(d1);
                    Date date2 = (Date) sdf.parse(d2);

                    // get the difference between two dates in minutes
                    long elapsedms = date1.getTime() - date2.getTime();
                    long diff = TimeUnit.MINUTES.convert(elapsedms, TimeUnit.MILLISECONDS);
                    if (diff > 7) {
                        setDenda((diff - 7) * Peminjaman.DENDA_PER_HARI);
                    }
                    daftarPeminjaman[indexLoanBook].setStatus(false);
                    buku.setStok(buku.getStok() + 1);
                    setPoin(poin+buku.getKategori().getPoin());
                    return "Buku " + buku.getJudul() + " berhasil dikembalikan oleh " + getNama() + " dengan denda Rp " + denda + "!";
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
            
        }
        return "Buku " + daftarPeminjaman[indexLoanBook].getBuku().getJudul() + " tidak sedang dipinjam oleh " + getNama();
    }

    long getDenda(){
        return denda;
    }

    void setDenda(long denda) {
        this.denda = denda;
    }

    void setPoin(int poin) {
        this.poin = poin;
    }

    int getPoin(){
        return poin;
    }
    
    public Peminjaman[] getDaftarPeminjaman(){
        return daftarPeminjaman;
    }
}
