public class CompanyEmployees {
    public static void main(String[] args) {
        int maxEmployeesCount = 10;

        var employeeBook = new EmployeeBook(maxEmployeesCount);

        employeeBook.addNewEmployee("Aasf gd FD", 65_000, 1);
        employeeBook.addNewEmployee("First Idiot", 65_000, 2);
        employeeBook.addNewEmployee("Second Ivan", 45_000, 3);
        employeeBook.addNewEmployee("Third Ivan", 65_000, 4);
        employeeBook.addNewEmployee("Forth Ivan", 65_000, 5);
        employeeBook.addNewEmployee("Five Ivan", 145_000, 1);
        employeeBook.addNewEmployee("Sixth Ivan", 65_000, 2);

        //Show all
        employeeBook.showAllEmployees();

        //Payments amount
        System.out.printf("Monthly payments amount - %.2f\n", employeeBook.calculatePaymentsAmount());

        //Employee with min salary
        employeeBook.showEmployeeWithMinSalary();

        //Employee with max salary
        employeeBook.showEmployeeWithMaxSalary();

        employeeBook.updateDept("Aasf gd FD", 5);
        employeeBook.updateSalary("First Idiot", 73_000);

        employeeBook.showAllEmployees();
        System.out.println();

        employeeBook.showEmployeesByDept();
    }
}
