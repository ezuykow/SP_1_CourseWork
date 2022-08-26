import java.util.ArrayList;
import java.util.List;

class UpgradedEmployeeBook extends SuperEmloyeeBook{
    private List<Employee> employees;

    public UpgradedEmployeeBook() {
        employees = new ArrayList<>();
    }

    public void addNewEmployee(String fullName, double salary, int dept) {
        employees.add(new Employee(fullName, salary, dept));
    }

    public void removeEmployee(String fullName) {
        remove(getEmployeeByFullName(fullName));
    }

    public void removeEmployee(int id) {
        remove(getEmployeeById(id));
    }

    public Employee getEmployeeByFullName(String fullName) {
        for (Employee employee : employees) {
            if (employee.getFullName().equals(fullName)) {
                return employee;
            }
        }
        return null;
    }

    public Employee getEmployeeById(int id) {
        for (Employee employee : employees) {
            if (employee.getId() == id) {
                return employee;
            }
        }
        return null;
    }

    public void showEmployeesByDept(int dept) {
        System.out.println("Employees of the " + dept + " department:");
        for (Employee employee : employees) {
            if (employee.getDept() == dept) {
                System.out.println(employee.getFullName());
            }
        }
    }

    public void showAllEmployees() {
        for (Employee employee : employees) {
            System.out.println(employee);
        }
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

    public int employeesInDept(int dept) {
        int count = 0;

        for (Employee employee : employees) {
            if ((employee.getDept() == dept) || (dept == -1)) {
                count++;
            }
        }

        return count;
    }

    public void indexSalaryInDept(double percents, int dept) {
        for (Employee employee : employees) {
            if ((employee.getDept() == dept) || (dept == -1)) {
                employee.setSalary(employee.getSalary() * (100+percents)/100);
            }
        }
    }

    public Employee findEmployeeWithMaxOrMinSalaryInDept(boolean max, int dept) {
        Employee current = null;

        for (Employee employee : employees) {
            current = checkMinOrMaxSalaryOfTwoEmployees(max, dept, current, employee);
        }

        return current;
    }

    public void showEmployeesWhichSalaryMoreOrLow(boolean more, double target) {
        for (Employee employee : employees) {
            showEmployeeIfSalaryMoreOrNot(more, target, employee);
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

    public void showAllFullNames() {
        for (Employee employee : employees) {
            System.out.println(employee.getFullName());
        }
    }

    /**
     * remove target employee if it is not null, else throw exception "Cant find this employee..."
     * @param target target employee
     */
    private void remove(Employee target) {
        if (target == null) {
            throw new RuntimeException("Cant find this employee...");
        } else {
            employees.remove(target);
        }
    }
}