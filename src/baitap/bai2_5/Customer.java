package bai2_5;

public class Customer {
    private int id;
    private String name;
    private char gender;

    Customer(int id, String name, char gender) {
        this.id = id;
        this.name = name;
        this.gender = gender;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public char getGender() {
        return gender;
    }
    @Override
    public String toString() {
        return "bai2_5.Customer [id=" + id + ", name=" + name + ", gender=" + gender + "]";
    }
}

