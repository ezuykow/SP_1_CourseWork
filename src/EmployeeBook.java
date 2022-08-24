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

    public void updateSalary(String fullName, double newSalary) {
        Employee e = getEmployeeByFullName(fullName);
        if (e != null) {
            e.setSalary(newSalary);
        } else {
            throw new RuntimeException("Cant find this employee...");
        }
    }

    public void updateDept(String fullName, int newDept) {
        Employee e = getEmployeeByFullName(fullName);
        if (e != null) {
            e.setDept(newDept);
        } else {
            throw new RuntimeException("Cant find this employee...");
        }
    }

    private Employee getEmployeeByFullName(String fullName) {
        for (Employee employee : employees) {
            if (employee != null) {
                if (employee.getFullName().equals(fullName)) {
                    return employee;
                }
            }
        }

        return null;
    }

    public void showEmployeesByDept() {
        for (int i = 1; i < 5; i++) {
            showEmployeesByDept(i);
        }
    }

    public void showEmployeesByDept(int dept) {
        System.out.println("Employees of the " + dept + " department:");
        for (Employee employee : employees) {
            if (employee != null) {
                if (employee.getDept() == dept) {
                    System.out.println(employee.getFullName());
                }
            }
        }
    }

    public void showAllEmployees() {
        for (Employee employee : employees) {
            if (employee != null) {
                System.out.println(employee);
            }
        }
    }
}
