package bai4_2;

public class Staff extends Person{
    private  String school;
    private  double pay;

    Staff(String school, double pay, String name, String address) {
        super(name, address);
        this.school = school;
        this.pay = pay;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public double getPay() {
        return pay;
    }

    public void setPay(double pay) {
        this.pay = pay;
    }

    public String toString(){
        return "bai4_2.Staff[ person " + super.toString() + " ] school: " + school + ", pay: " + pay + " ]";
    }
}
