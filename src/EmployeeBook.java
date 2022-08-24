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

    public double calculatePaymentsAmount() {
        return calculatePaymentsAmountInDept(-1);
    }

    public double calculatePaymentsAmountInDept(int dept) {
        double sum = 0;

        for (Employee employee : employees) {
            if (employee != null) {
                if ((employee.getDept() == dept) || (dept == -1)) {
                    sum += employee.getSalary();
                }
            }
        }

        return sum;
    }

    public void showAverageSalary() {
        System.out.printf("Average salary: %.2f\n", calculatePaymentsAmount()/employeesInDept(-1));
    }

    public void showAverageSalaryInDept(int dept) {
        System.out.printf("Average salary in %d department: %.2f\n", dept, calculatePaymentsAmountInDept(dept)/employeesInDept(dept));
    }

    private int employeesInDept(int dept) {
        int count = 0;

        for (Employee employee : employees) {
            if (employee != null) {
                if ((employee.getDept() == dept) || (dept == -1)) {
                    count++;
                }
            }
        }

        return count;
    }

    public void indexSalary(double percents) {
        indexSalaryInDept(percents, -1);
    }

    public void indexSalaryInDept(double percents, int dept) {
        for (Employee employee : employees) {
            if (employee != null) {
                if ((employee.getDept() == dept) || (dept == -1)) {
                    employee.setSalary(employee.getSalary() * (100+percents)/100);
                }
            }
        }
    }

    public void showEmployeeWithMinSalary() {
        System.out.println("Minimum salary has:");
        System.out.println(findEmployeeWithMaxOrMinSalaryInDept(false, -1));
    }

    public void showEmployeeWithMaxSalary() {
        System.out.println("Maximum salary has:");
        System.out.println(findEmployeeWithMaxOrMinSalaryInDept(true, -1));
    }

    public void showEmployeeWithMinSalaryInDept(int dept) {
        System.out.println("Minimum salary in " + dept + " department has:");
        System.out.println(findEmployeeWithMaxOrMinSalaryInDept(false, dept));
    }

    public void showEmployeeWithMaxSalaryInDept(int dept) {
        System.out.println("Maximum salary in " + dept + " department has:");
        System.out.println(findEmployeeWithMaxOrMinSalaryInDept(true, dept));
    }

    private Employee findEmployeeWithMaxOrMinSalaryInDept(boolean max, int dept) {
        Employee current = null;

        for (Employee employee : employees) {
            if (employee != null) {
                if ((employee.getDept() == dept) || (dept == -1)) {
                    if (current == null) {
                        current = employee;
                    } else {
                        if (max) {
                            if (current.getSalary() < employee.getSalary()) {
                                current = employee;
                            }
                        } else {
                            if (current.getSalary() > employee.getSalary()) {
                                current = employee;
                            }
                        }
                    }
                }
            }
        }

        return current;
    }

    public void showEmployeesWhichSalaryMore(double target) {
        System.out.println("Employees with salary more than " + target + ":");
        showEmployeesWhichSalaryMoreOrLow(true, target);
    }

    public void showEmployeesWhichSalaryLow(double target) {
        System.out.println("Employees with salary low than " + target + ":");
        showEmployeesWhichSalaryMoreOrLow(false, target);
    }

    private void showEmployeesWhichSalaryMoreOrLow(boolean more, double target) {
        for (Employee employee : employees) {
            if (employee != null) {
                if (more) {
                    if (employee.getSalary() >= target) {
                        System.out.println(employee);
                    }
                } else {
                    if (employee.getSalary() < target) {
                        System.out.println(employee);
                    }
                }
            }
        }
    }
    public void showEmployeesInDept(int dept) {
        for (Employee employee : employees) {
            if ((employee != null) && (employee.getDept() == dept)) {
                System.out.printf("%d) %s, salary - %.2f\n", employee.getId(), employee.getFullName(),
                        employee.getSalary());
            }
        }
    }

    public void showAllFullNames() {
        for (Employee employee : employees) {
            if (employee != null) {
                System.out.println(employee.getFullName());
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
