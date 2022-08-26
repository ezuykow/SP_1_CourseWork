abstract class SuperEmloyeeBook {
    /**
     * Add a new Employee in EmployeeBook.
     * For adding uses a constructor of class Employee.
     * @param fullName full name of new employee
     * @param salary salary of new employee
     * @param dept department, where new employee work
     */
    abstract public void addNewEmployee(String fullName, double salary, int dept);

    /**
     * Remove employee from EmployeeBook by full name.
     * Throw a RuntimeException "Cant find this employee..." if there is no employee with target full name.
     * @param fullName full name of employee, which must be removed
     */
    abstract public void removeEmployee(String fullName);

    /**
     * Remove employee from EmployeeBook by id.
     * Throw a RuntimeException "Cant find this employee..." if there is no employee with target id.
     * @param id id of employee, which must be removed
     */
    abstract public void removeEmployee(int id);

    /**
     * @return Employee with target full name OR null if there is no employee with target full name
     * @param fullName target full name
     */
    abstract public Employee getEmployeeByFullName(String fullName);

    /**
     * Update the field salary of Employee with target full name.
     * Throw a RuntimeException "Cant find this employee..." if there is no employee with target full name.
     * @param fullName target full name of employee
     * @param newSalary salary, which must be placed in field
     */
    public void updateSalary(String fullName, double newSalary) {
        Employee target = getEmployeeByFullName(fullName);

        if (target == null) {
            throw new RuntimeException("Cant find this employee...");
        } else {
            target.setSalary(newSalary);
        }
    }

    /**
     * Update the field dept of Employee with target full name.
     * Throw a RuntimeException "Cant find this employee..." if there is no employee with target full name.
     * @param fullName target full name of employee
     * @param newDept dept, which must be placed in field
     */
    public void updateDept(String fullName, int newDept) {
        Employee target = getEmployeeByFullName(fullName);

        if (target == null) {
            throw new RuntimeException("Cant find this employee...");
        } else {
            target.setDept(newDept);
        }
    }

    /**
     * @return Employee with target id OR null if there is no employee with target id
     * @param id target id
     */
    abstract public Employee getEmployeeById(int id);

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
    abstract public void showEmployeesByDept(int dept);

    /**
     * Show all employees with all they data
     */
    abstract public void showAllEmployees();

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
    abstract public double calculatePaymentsAmountInDept(int dept);

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
    abstract public int employeesInDept(int dept);

    /**
     * Increase salary by target percent:
     * if (dept == 1..5) -  of all employees in target department,
     * if (dept == -1) -  of all employees.
     * @param percents target percent
     * @param dept target department
     */
    abstract public void indexSalaryInDept(double percents, int dept);

    /**
     * Increase salary of all employees by target percent
     * @param percents target percent
     */
    public void indexSalary(double percents) {
        indexSalaryInDept(percents, -1);
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
    abstract public Employee findEmployeeWithMaxOrMinSalaryInDept(boolean max, int dept);

    /**
     * @return Employee with maximal (max == true) or minimal (max == false) salary of two employees (always, if
     * dept == -1, but if dept of employee != dept -> return current buck).
     * @param max TRUE if needed to find max salary, FALSE is needed min salary
     * @param dept target department
     * @param current current Employee (may be null -> than current = employee)
     * @param employee employee, which should be compared in terms of salary
     */
    public Employee checkMinOrMaxSalaryOfTwoEmployees(boolean max, int dept, Employee current, Employee employee) {
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
    abstract public void showEmployeesWhichSalaryMoreOrLow(boolean more, double target);

    /**
     * print employee if his salary more (more == TRUE) or low (more == FALSE) than target.
     * @param more TRUE if needed to find salary that more than target, FALSE if needed salary low that target
     * @param target target salary
     * @param employee employee, which should be checked
     */
    public void showEmployeeIfSalaryMoreOrNot(boolean more, double target, Employee employee) {
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

    /**
     * Show employees with they data, which work in target department
     * @param dept target department
     */
    abstract public void showEmployeesInDept(int dept);

    /**
     * Show full names of all employees
     */
    abstract public void showAllFullNames();
}
