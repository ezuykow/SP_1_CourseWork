class EmployeeBook {
    private Employee[] employees;

    /**
     * Constructor of EmployeeBook
     * @param count max count of Employee in EmployeeBook
     */
    public EmployeeBook(int count) {
        employees = new Employee[count];
    }

    /**
     * Add a new Employee in array employees, if in this array there is empty (null) cell.
     * For adding uses a constructor of class Employee.
     * Throw a RuntimeException "No space in employees[]..." if array employees is full.
     * @param fullName full name of new employee
     * @param salary salary of new employee
     * @param dept department, where new employee work
     */
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

    /**
     * Remove employee from array employees by full name (set target Employee to null).
     * Throw a RuntimeException "Cant find this employee..." if there is no employee with target full name.
     * @param fullName full name of employee, which must be removed
     */
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

    /**
     * Remove employee from array employees by id (set target Employee to null).
     * Throw a RuntimeException "Cant find this employee..." if there is no employee with target id.
     * @param id id of employee, which must be removed
     */
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

    /**
     * Update the field salary of Employee with target full name.
     * Throw a RuntimeException "Cant find this employee..." if there is no employee with target full name.
     * @param fullName target full name of employee
     * @param newSalary salary, which must be placed in field
     */
    public void updateSalary(String fullName, double newSalary) {
        Employee e = getEmployeeByFullName(fullName);
        if (e != null) {
            e.setSalary(newSalary);
        } else {
            throw new RuntimeException("Cant find this employee...");
        }
    }

    /**
     * Update the field dept of Employee with target full name.
     * Throw a RuntimeException "Cant find this employee..." if there is no employee with target full name.
     * @param fullName target full name of employee
     * @param newDept dept, which must be placed in field
     */
    public void updateDept(String fullName, int newDept) {
        Employee e = getEmployeeByFullName(fullName);
        if (e != null) {
            e.setDept(newDept);
        } else {
            throw new RuntimeException("Cant find this employee...");
        }
    }

    /**
     * @return Employee with target full name OR null if there is no employee with target full name
     * @param fullName target full name
     */
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

    /**
     * Show full names of employees by department
     */
    public void showEmployeesByDept() {
        for (int i = 1; i < 5; i++) {
            showEmployeesByDept(i);
        }
    }

    /**
     * Show full names of employees of target department
     * @param dept target department
     */
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

    /**
     * Show all employees with all they data
     */
    public void showAllEmployees() {
        for (Employee employee : employees) {
            if (employee != null) {
                System.out.println(employee);
            }
        }
    }

    /**
     * @return a monthly payments amount of all employees
     */
    public double calculatePaymentsAmount() {
        return calculatePaymentsAmountInDept(-1);
    }

    /**
     * @return a monthly payment amount:
     *  if (dept == 1..5) - of all employees in target department,
     *  if (dept == -1) - of all employees.
     * @param dept target department
     */
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

    /**
     * Show an average salary of all employees
     */
    public void showAverageSalary() {
        System.out.printf("Average salary: %.2f\n", calculatePaymentsAmount()/employeesInDept(-1));
    }

    /**
     * Show an average salary of all employees in target department
     * @param dept target department
     */
    public void showAverageSalaryInDept(int dept) {
        System.out.printf("Average salary in %d department: %.2f\n", dept, calculatePaymentsAmountInDept(dept)/employeesInDept(dept));
    }

    /**
     * @param dept target department
     * @return count of employees in target department
     */
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

    /**
     * Increase salary of all employees by target percent
     * @param percents target percent
     */
    public void indexSalary(double percents) {
        indexSalaryInDept(percents, -1);
    }

    /**
     * Increase salary by target percent:
     * if (dept == 1..5) -  of all employees in target department,
     * if (dept == -1) -  of all employees.
     * @param percents target percent
     * @param dept target department
     */
    public void indexSalaryInDept(double percents, int dept) {
        for (Employee employee : employees) {
            if (employee != null) {
                if ((employee.getDept() == dept) || (dept == -1)) {
                    employee.setSalary(employee.getSalary() * (100+percents)/100);
                }
            }
        }
    }

    /**
     * Show employee with minimal salary
     */
    public void showEmployeeWithMinSalary() {
        System.out.println("Minimum salary has:");
        System.out.println(findEmployeeWithMaxOrMinSalaryInDept(false, -1));
    }

    /**
     * Show employee with maximal salary
     */
    public void showEmployeeWithMaxSalary() {
        System.out.println("Maximum salary has:");
        System.out.println(findEmployeeWithMaxOrMinSalaryInDept(true, -1));
    }

    /**
     * Show employee with minimal salary in target department
     * @param dept target department
     */
    public void showEmployeeWithMinSalaryInDept(int dept) {
        System.out.println("Minimum salary in " + dept + " department has:");
        System.out.println(findEmployeeWithMaxOrMinSalaryInDept(false, dept));
    }

    /**
     * Show employee with maximal salary in target department
     * @param dept target department
     */
    public void showEmployeeWithMaxSalaryInDept(int dept) {
        System.out.println("Maximum salary in " + dept + " department has:");
        System.out.println(findEmployeeWithMaxOrMinSalaryInDept(true, dept));
    }

    /**
     * @return Employee with maximal (max == true) or minimal (max == false) salary of all employees (dept == -1) or
     * target department (dept == 1..5)
     * @param dept target department
     * @param max TRUE if needed to find max salary, FALSE is needed min salary
     */
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

    /**
     * Show employees, which have the salary, that more than target
     * @param target target salary
     */
    public void showEmployeesWhichSalaryMore(double target) {
        System.out.println("Employees with salary more than " + target + ":");
        showEmployeesWhichSalaryMoreOrLow(true, target);
    }

    /**
     * Show employees, which have the salary, that low than target
     * @param target target salary
     */
    public void showEmployeesWhichSalaryLow(double target) {
        System.out.println("Employees with salary low than " + target + ":");
        showEmployeesWhichSalaryMoreOrLow(false, target);
    }

    /**
     * Show employees, which have the salary that more (more == TRUE) or low (more == false) that target
     * @param more TRUE if needed to find salary that more than target, FALSE if needed salary low that target
     * @param target target salary
     */
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

    /**
     * Show employees with they data, which work in target department
     * @param dept target department
     */
    public void showEmployeesInDept(int dept) {
        for (Employee employee : employees) {
            if ((employee != null) && (employee.getDept() == dept)) {
                System.out.printf("%d) %s, salary - %.2f\n", employee.getId(), employee.getFullName(),
                        employee.getSalary());
            }
        }
    }

    /**
     * Show full names of all employees
     */
    public void showAllFullNames() {
        for (Employee employee : employees) {
            if (employee != null) {
                System.out.println(employee.getFullName());
            }
        }
    }
}