package bai1_4;

public class Employee {
    private int id;
    private String firstName;
    private String lastName;
    private int salary;

    Employee(){
        //
    }
    public Employee(int id, String firstName, String lastName, int salary ) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;

    }
    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String lastName(){
        return lastName;
    }

    public String Name(){
        return firstName + lastName;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getAnnualSalary(){
        return 12*salary;
    }

    public int raiseSalary(int percent){
        return (salary/percent)*100;
    }

    @Override
    public String toString() {
        return "bai1_4.Employee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", salary=" + salary +
                '}';
    }
}
