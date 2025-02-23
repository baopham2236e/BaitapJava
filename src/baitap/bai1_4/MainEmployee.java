package bai1_4;

public class MainEmployee {
    public static void main(String[] args) {
        Employee e1 = new Employee(1,"tan", "tai", 1500);
        System.out.println(e1+" name " +e1.Name());
        e1.setSalary(999);
        System.out.println(e1+" name "+e1.Name());
        System.out.println("ID: "+e1.getId());
        System.out.println("First Name: "+e1.getFirstName());
        System.out.println("Last Name: "+e1.lastName());
        System.out.println("Name: "+e1.Name());
        System.out.println("Annual Salary: "+e1.getAnnualSalary());
        System.out.println(e1.raiseSalary(10));
        System.out.println(e1);
    }
}
