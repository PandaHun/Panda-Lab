package chapter2.item1;

public class Employee {

    private String name;

    public Employee(String name) {
        this.name = name;
    }

    public static Employee withName(String name) {
        return new Employee(name);
    }
}
