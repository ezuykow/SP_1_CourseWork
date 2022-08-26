public class CompanyEmployees {
    public static void main(String[] args) {
        /*Creating employeeBook using EmployeeBook*/
//        int maxEmployeesCount = 10;
//        var employeeBook = new EmployeeBook(maxEmployeesCount);

        /*Creating employeeBook using UpgradedEmployeeBook*/
        var employeeBook = new UpgradedEmployeeBook();

        //Adding a new employees
        employeeBook.addNewEmployee("Ivanov Ivan Ivanovich", 165_000, 1);
        employeeBook.addNewEmployee("Smirnov Petr Sergeevich", 135_000, 2);
        employeeBook.addNewEmployee("Skorobogatov Evgeniy Sergeevich", 45_000, 3);
        employeeBook.addNewEmployee("King Kong Monkeyevich", 65_000, 4);
        employeeBook.addNewEmployee("Cezar Yuly Georgievich", 95_000, 5);
        employeeBook.addNewEmployee("Kukushka Fillip Egorovich", 145_000, 3);
        employeeBook.addNewEmployee("Krug Mikhail Sergeevich", 65_000, 2);

        /*Show:*/
        employeeBook.showAllEmployees();

        /*Delete employee:*/
//        String targetName = "Smirnov Petr Sergeevich";
//        int targetId = 3; //(Skorobogatov)
//        employeeBook.removeEmployee(targetName);
//        employeeBook.removeEmployee(targetId);
        /*Show:*/
//        employeeBook.showAllEmployees();

        /*Update employee:*/
//        String targetName = "Smirnov Petr Sergeevich";
//        double newSalary = 734_000.00;
//        int newDept = 1;
//        employeeBook.updateSalary(targetName, newSalary);
//        employeeBook.updateDept(targetName, newDept);
        /*Show:*/
//        employeeBook.showAllEmployees();

        /*Monthly payments amount:*/
//        double paymentsAmount = employeeBook.calculatePaymentsAmount();
        /*In department:*/
//        int targetDept = 2;
//        double paymentsAmountInDept = employeeBook.calculatePaymentsAmountInDept(targetDept);
//        System.out.println("paymentsAmount = " + paymentsAmount);
//        System.out.println("paymentsAmountInDept = " + paymentsAmountInDept);

        /*Employees with min/max salary:*/
//        employeeBook.showEmployeeWithMinSalary();
//        employeeBook.showEmployeeWithMaxSalary();
        /*In department:*/
//        int targetDept = 2;
//        employeeBook.showEmployeeWithMinSalaryInDept(targetDept);
//        employeeBook.showEmployeeWithMaxSalaryInDept(targetDept);

        /*Averge salary:*/
//        employeeBook.showAverageSalary();
        /*In department*/
//        int targetDept = 2;
//        employeeBook.showAverageSalaryInDept(targetDept);

        /*Show full names of employees:*/
//        employeeBook.showAllFullNames();

        /*Show full names of employees by department:*/
//        employeeBook.showEmployeesByDept();

        /*Indexing salary:*/
//        int percent = 10;
//        employeeBook.indexSalary(percent);
        /*Show:*/
//        employeeBook.showAllEmployees();
        /*In department:*/
//        int percent = 10;
//        int targetDept = 2;
//        employeeBook.indexSalaryInDept(percent, targetDept);
        /*Show:*/
//        employeeBook.showEmployeesInDept(targetDept);

        /*Show employees of target department:*/
//        int targetDept = 2;
//        employeeBook.showEmployeesInDept(targetDept);

        /*Show employees with salary that more/low than target:*/
//        int target = 70_000;
//        employeeBook.showEmployeesWhichSalaryMore(target);
//        employeeBook.showEmployeesWhichSalaryLow(target);
    }
}