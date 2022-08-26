class EmployeeBook extends SuperEmloyeeBook {
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

    public Employee getEmployeeByFullName(String fullName) {
        for (Employee employee : employees) {
            if (employee != null) {
                if (employee.getFullName().equals(fullName)) {
                    return employee;
                }
            }
        }
        return null;
    }

    public Employee getEmployeeById(int id) {
        for (Employee employee : employees) {
            if (employee != null) {
                if (employee.getId() == id) {
                    return employee;
                }
            }
        }
        return null;
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

    public int employeesInDept(int dept) {
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

    public void indexSalaryInDept(double percents, int dept) {
        for (Employee employee : employees) {
            if (employee != null) {
                if ((employee.getDept() == dept) || (dept == -1)) {
                    employee.setSalary(employee.getSalary() * (100+percents)/100);
                }
            }
        }
    }

    public Employee findEmployeeWithMaxOrMinSalaryInDept(boolean max, int dept) {
        Employee current = null;

        for (Employee employee : employees) {
            if (employee != null) {
                current = checkMinOrMaxSalaryOfTwoEmployees(max, dept, current, employee);
            }
        }

        return current;
    }

    public void showEmployeesWhichSalaryMoreOrLow(boolean more, double target) {
        for (Employee employee : employees) {
            if (employee != null) {
                showEmployeeIfSalaryMoreOrNot(more, target, employee);
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
}