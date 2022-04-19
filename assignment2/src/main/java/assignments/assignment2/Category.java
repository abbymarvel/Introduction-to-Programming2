package assignments.assignment2;

public class Category {
    private String name;
    private int point;

    @Override
    public String toString() {
        return "Kategori " + name + " dengan " + point + " point berhasil ditambahkan";
    }
    public Category(String name, int point){
        this.name = name;
        this.point = point;
    }

    public String getName() {
        return name;
    }

    public int getPoint() {
        return point;
    }
}
