import java.util.ArrayList;
import java.util.List;

public class UpgradedEmployeeBook {
    private List<Employee> employees;

    public UpgradedEmployeeBook() {
        employees = new ArrayList<>();
    }

    public void addNewEmployee(String fullName, double salary, int dept) {
        employees.add(new Employee(fullName, salary, dept));
    }

    public void showAllEmployees() {
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }

    public void removeEmployee(String fullName) {
        remove(getEmployeeByFullName(fullName));
    }

    public void removeEmployee(int id) {
        remove(getEmployeeById(id));
    }

    public void updateSalary(String fullName, double newSalary) {
        Employee target = getEmployeeByFullName(fullName);

        if (target == null) {
            throw new RuntimeException("Cant find this employee...");
        } else {
            target.setSalary(newSalary);
        }
    }

    public void updateDept(String fullName, int newDept) {
        Employee target = getEmployeeByFullName(fullName);

        if (target == null) {
            throw new RuntimeException("Cant find this employee...");
        } else {
            target.setDept(newDept);
        }
    }

    public void showEmployeesByDept() {
        for (int i = 1; i <= 5 ; i++) {
            showEmployeesByDept(i);
        }
    }

    public void showEmployeesByDept(int dept) {
        System.out.println("Employees of the " + dept + " department:");
        for (Employee employee : employees) {
            if (employee.getDept() == dept) {
                System.out.println(employee.getFullName());
            }
        }
    }

    public double calculatePaymentsAmount() {
        return calculatePaymentsAmountInDept(-1);
    }

    public double calculatePaymentsAmountInDept(int dept) {
        double sum = 0;

        for (Employee employee : employees) {
            if ((employee.getDept() == dept) || (dept == -1)) {
                sum += employee.getSalary();
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

    public void indexSalary(double percents) {
        indexSalaryInDept(percents, -1);
    }

    public void indexSalaryInDept(double percents, int dept) {
        for (Employee employee : employees) {
            if ((employee.getDept() == dept) || (dept == -1)) {
                employee.setSalary(employee.getSalary() * (100+percents)/100);
            }
        }
    }

    public void showEmployeesInDept(int dept) {
        for (Employee employee : employees) {
            if (employee.getDept() == dept) {
                System.out.printf("%d) %s, salary - %.2f\n", employee.getId(), employee.getFullName(),
                        employee.getSalary());
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

    public void showEmployeesWhichSalaryMore(double target) {
        System.out.println("Employees with salary more than " + target + ":");
        showEmployeesWhichSalaryMoreOrLow(true, target);
    }

    public void showEmployeesWhichSalaryLow(double target) {
        System.out.println("Employees with salary low than " + target + ":");
        showEmployeesWhichSalaryMoreOrLow(false, target);
    }

    public void showAllFullNames() {
        for (Employee employee : employees) {
            System.out.println(employee.getFullName());
        }
    }

    private void showEmployeesWhichSalaryMoreOrLow(boolean more, double target) {
        for (Employee employee : employees) {
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

    private Employee findEmployeeWithMaxOrMinSalaryInDept(boolean max, int dept) {
        Employee target = null;

        for (Employee employee : employees) {
            if ((employee.getDept() == dept) || (dept == -1)) {
                if (target == null) {
                    target = employee;
                } else {
                    if (max) {
                        if (target.getSalary() < employee.getSalary()) {
                            target = employee;
                        }
                    } else {
                        if (target.getSalary() > employee.getSalary()) {
                            target = employee;
                        }
                    }
                }
            }
        }

        return target;
    }

    private void remove(Employee target) {
        if (target == null) {
            throw new RuntimeException("Cant find this employee...");
        } else {
            employees.remove(target);
        }
    }

    private int employeesInDept(int dept) {
        int count = 0;

        for (Employee employee : employees) {
            if ((employee.getDept() == dept) || (dept == -1)) {
                count++;
            }
        }

        return count;
    }

    private Employee getEmployeeByFullName(String fullName) {
        for (Employee employee : employees) {
            if (employee.getFullName().equals(fullName)) {
                return employee;
            }
        }
        return null;
    }

    private Employee getEmployeeById(int id) {
        for (Employee employee : employees) {
            if (employee.getId() == id) {
                return employee;
            }
        }
        return null;
    }
}