package assignments.assignment3.buku;

public class Kategori {
    private String nama;
    private int poin;

    @Override
    public String toString() {
        return "Kategori: " + nama
                + "\nPoin: " + poin;
    }
    public Kategori(String nama, int poin){
        this.nama = nama;
        this.poin = poin;
    }

    public String getNama() {
        return nama;
    }

    public int getPoin() {
        return poin;
    }
}
