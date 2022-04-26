package assignments.assignment3.pengguna;

public class Staf extends Pengguna{
    private int jumlahStaff = 0;

    public Staf(String id, String nama){
        super(id, nama);
    }
    
    @Override
    public String generateId(){
        return "STAF-" + ++jumlahStaff;
    }

    @Override
    public String toString(){
        return "ID Staf: " + getId()
                + "\nNama Staf: " + getNama();
    }
}
