public class CompanyEmployees {
    public static void main(String[] args) {
        int maxEmployeesCount = 10;

        var employeeBook = new EmployeeBook(maxEmployeesCount);

        employeeBook.addNewEmployee("Aasf gd FD", 65_000, 3);
        employeeBook.addNewEmployee("First Idiot", 65_000, 3);
        employeeBook.addNewEmployee("Second Ivan", 65_000, 3);

        employeeBook.showAllEmployees();
    }
}
