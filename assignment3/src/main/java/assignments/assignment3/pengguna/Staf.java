package assignments.assignment3.pengguna;

public class Staf extends Pengguna{
    private static int jumlahStaff = 0;

    public Staf(String nama){
        super(nama);
        setId(generateId());
    }
    
    @Override
    public String generateId(){
        jumlahStaff++;
        return "STAF-" + jumlahStaff;
    }

    @Override
    public String toString(){
        return "ID Staf: " + getId()
                + "\nNama Staf: " + getNama();
    }
}
