public class CompanyEmployees {
    public static void main(String[] args) {
        int maxEmployeesCount = 10;

        var employeeBook = new EmployeeBook(maxEmployeesCount);

        employeeBook.addNewEmployee("Aasf gd FD", 65_000, 1);
        employeeBook.addNewEmployee("First Idiot", 65_000, 2);
        employeeBook.addNewEmployee("Second Ivan", 45_000, 3);
        employeeBook.addNewEmployee("Third Ivan", 65_000, 3);
        employeeBook.addNewEmployee("Forth Ivan", 65_000, 5);
        employeeBook.addNewEmployee("Five Ivan", 145_000, 3);
        employeeBook.addNewEmployee("Sixth Ivan", 65_000, 2);


        //Show all full names
//        employeeBook.showAllFullNames();

        //Employee with min salary
//        employeeBook.showEmployeeWithMinSalary();

        //Employee with max salary
//        employeeBook.showEmployeeWithMaxSalary();

        //Employee with min salary in dept
//        employeeBook.showEmployeeWithMinSalaryInDept(3);

        //Employee with max salary in dept
//        employeeBook.showEmployeeWithMaxSalaryInDept(3);

        //Payments amount
//        System.out.printf("Monthly payments amount - %.2f\n", employeeBook.calculatePaymentsAmount());

        //Payments amount in dept
//        int dept = 3;
//        System.out.printf("Monthly payments amount in %d department - %.2f\n", dept, employeeBook.calculatePaymentsAmountInDept(dept));

        //Average salary
//        employeeBook.showAverageSalary();

        //Average salary in dept
//        int dept = 3;
//        employeeBook.showAverageSalaryInDept(dept);

        //Indexing salary
//        employeeBook.indexSalary(10);

        //Indexing salary in dept
//        employeeBook.indexSalaryInDept(10, 3);

        //Show employees in dept
//        int dept = 3;
//        employeeBook.showEmployeesInDept(dept);

        //Salary many than target
//        int target = 70_000;
//        employeeBook.showEmployeesWhichSalaryMore(target);
        //Low than target
//        employeeBook.showEmployeesWhichSalaryLow(target);

//        employeeBook.showAllEmployees();
    }
}
