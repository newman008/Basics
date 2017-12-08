package Item1;

public class Employee {

    private String firstName;
    private String secondName;

    private Employee(String f, String s) {
        firstName = f;
        secondName = s;
    }

    public static Employee getInstance(String f, String s) {
        // cache or reuse instances
        return new Employee(f, s);
    }
    
    public String getFirstName() { return firstName; }
    public String getSecondName() { return secondName; }

    public static void main(String args[]) {
        Employee e = Employee.getInstance("John", "Wu");
        System.out.println(e.getFirstName() + " " + e.getSecondName());
    }
}

