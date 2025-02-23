package bai4_2;

public class Person {
    private String name;
    private String address;

    public Person(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public String getname(){
        return name;
    }

    public String getAddress(){
        return address;
    }

    public void setAdress(String address){
        this.address = address;
    }

    @Override
    public String toString() {
        return "bai4_2.Person[ name= "+ name +", address= " + address + "]";
    }
}


