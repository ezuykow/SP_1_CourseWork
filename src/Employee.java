class Employee {
    private static int count = 0;

    private final int id;
    private String fullName;
    private double salary;
    private int dept;

    /**
     * Constructor for new object Employee
     * @param fullName - full name of new Employee
     * @param salary - salary of new Employee
     * @param dept - department, when new Employee working
     * Field id - unique id of new Employee. Initialized by static field count+1
     */
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

    @Override
    public String toString() {
        return String.format("%d) %s, salary - %.2f, department - %d", id, fullName, salary, dept);
    }
}
