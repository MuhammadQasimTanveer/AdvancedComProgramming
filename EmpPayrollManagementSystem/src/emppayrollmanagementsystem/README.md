# Employee Payroll Management System

Console-based Java application designed to manage employees’ payroll, calculate net salaries, and generate payslips. Implements core Object-Oriented Programming concepts such as **Inheritance, Abstraction, and Interfaces**.

## Features

1. **Add Employee** – Add new Permanent or Contract employees with unique IDs, names, and salary details.  
2. **View All Employees** – Display details of all employees in a tabular format.  
3. **Search Employee** – Find and display a specific employee’s details using their employee ID.  
4. **Highest Net Salary** – Identify and display the employee with the highest net salary.  
5. **Average Salary** – Calculate and display the average net salary of all employees.  
6. **Generate Payslip** – Print a detailed payslip for a selected employee using the implemented interface method.  
7. **Exit** – End the program and show a summary of total employees and overall average net salary.  

## Classes Implemented

**Employee (Abstract Class)**  
- Base class containing common attributes like `empId`, `name`, and `basicSalary`.  
- Declares the abstract method `calculateTax()` for subclasses to implement.  

**PermanentEmployee (Subclass)**  
- Extends `Employee` and includes a `bonus` attribute.  
- Implements tax calculation (10% of salary + bonus) and net salary computation.  

**ContractEmployee (Subclass)**  
- Extends `Employee` and includes `contractDuration`.  
- Implements tax calculation (5% of basic salary) and net salary computation.  

**Payable (Interface)**  
- Declares `calculateNetSalary()` and `generatePayslip()`.  
- Both subclasses implement this interface to define their own salary and payslip logic.  

**EmpPayrollManagementSystem (Main Class)**  
- Handles menu-driven interaction with the user.  
- Implements key operations such as add, view, search, highest salary, average salary, and payslip generation.  

## Technical Details

### Constraints
- Maximum 5 employees allowed.  
- Salary, bonus, and other numeric values must be positive.  
- Employee IDs must be unique.  
- Console-based interface; no GUI implemented.  

### Data Structures Used
- `ArrayList<Employee>` – Stores all employee objects dynamically up to the maximum allowed.  
- Reference polymorphism used to call interface methods on employee objects.  

## How to Run
```bash
# Compile all Java files
javac *.java

# Run the main program
java EmpPayrollManagementSystem
