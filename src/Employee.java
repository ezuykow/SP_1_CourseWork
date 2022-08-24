class Employee {
    private static int count = 0; //Counter

    private int id;
    private String fullName;
    private double salary;
    private int dept;

    public Employee(String fullName, double salary, int dept) {
        this.fullName = fullName;
        this.salary = salary;
        this.dept = dept;
        this.id = ++count;
    }

    public int getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public double getSalary() {
        return salary;
    }

    public int getDept() {
        return dept;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setDept(int dept) {
        this.dept = dept;
    }
}
