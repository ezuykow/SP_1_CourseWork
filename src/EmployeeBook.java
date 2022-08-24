class EmployeeBook {
    private Employee[] employees;

    public EmployeeBook(int count) {
        employees = new Employee[count];
    }

    public void addNewEmployee(String fullName, double salary, int dept) {
        boolean done = false;

        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) {
                employees[i] = new Employee(fullName, salary, dept);
                done = true;
                break;
            }
        }

        if (!done) {
            throw new RuntimeException("No space in employees[]...");
        }
    }

    public void removeEmployee(String fullName) {
        boolean done = false;

        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                if (employees[i].getFullName().equals(fullName)) {
                    employees[i] = null;
                    done = true;
                    break;
                }
            }
        }

        if (!done) {
            throw new RuntimeException("Cant find this employee...");
        }
    }

    public void removeEmployee(int id) {
        boolean done = false;

        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                if (employees[i].getId() == id) {
                    employees[i] = null;
                    done = true;
                    break;
                }
            }
        }

        if (!done) {
            throw new RuntimeException("Cant find this employee...");
        }
    }

    public void showAllEmployees() {
        for (Employee employee : employees) {
            if (employee != null) {
                System.out.printf("%d %s %.2f %d\n", employee.getId(), employee.getFullName(), employee.getSalary(),
                        employee.getDept());
            }
        }
    }
}
