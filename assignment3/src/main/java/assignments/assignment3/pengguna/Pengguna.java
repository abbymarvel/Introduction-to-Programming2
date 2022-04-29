package assignments.assignment3.pengguna;

public abstract class Pengguna {
    private String id;
    private String nama;

     public Pengguna(String nama){
        this.nama = nama;
    }

    protected abstract String generateId();
    public abstract String toString();

    public void setId(String id){
        this.id = id;
    }

    public String getId() {
        return id;
    }
    
    public String getNama() {
        return nama;
    }
}
