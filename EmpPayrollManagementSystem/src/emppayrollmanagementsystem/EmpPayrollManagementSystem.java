package emppayrollmanagementsystem;

import java.util.*;

public class EmpPayrollManagementSystem {
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        
        // Using ArrayList to store employees
        // Condition in Switch Statement ensures only up to 5 employees can be added
        ArrayList<Employee> employees = new ArrayList<>();
        
        while (true) 
        {
            System.out.println("\n--- Employee Payroll Management System ---");
            System.out.println("1. Add Employee");
            System.out.println("2. View All Employees");
            System.out.println("3. Search Employee");
            System.out.println("4. Highest Net Salary");
            System.out.println("5. Average Salary");
            System.out.println("6. Generate Payslip");
            System.out.println("7. Exit");
            System.out.print("\nChoose an option: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) 
            {
                case 1:
                    if (employees.size() >= 5) //if size of Arraylist reached 5, do not add more
                    {
                        System.out.println("Maximum 5 employees allowed!");
                        return;
                    }
                    System.out.print("Enter Employee Type (Permanent/Contract): ");
                    String type = sc.nextLine().toLowerCase();

                    System.out.print("Enter ID: ");
                    String id = sc.nextLine();

                    // Check for duplicate ID
                    boolean exists = false;
                    for (Employee e : employees) 
                    {
                       if (e.getEmpId().equals(id)) 
                       {
                           exists = true;
                           break;
                        }
                    }
                    if (exists) 
                    {
                        System.out.println("Error: Employee ID already exists!");
                        break;
                    }

                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Basic Salary: ");
                    double salary = sc.nextDouble();

                    if (salary <= 0) 
                    {
                        System.out.println("Invalid salary!");
                        break;
                    }

                    if (type.equals("permanent")) 
                    {
                        System.out.print("Enter Bonus: ");
                        double bonus = sc.nextDouble();
                        if (bonus < 0) 
                        {
                            System.out.println("Invalid bonus!");
                            break;
                        }
                        employees.add(new PermanentEmployee(id, name, salary, bonus));
                    } 
                    else if (type.equals("contract")) 
                    {
                        System.out.print("Enter Contract Duration (months): ");
                        int duration = sc.nextInt();
                        employees.add(new ContractEmployee(id, name, salary, duration));
                    } 
                    else 
                    {
                        System.out.println("Invalid type!");
                        break;
                    }
                    
                    System.out.println("Employee added successfully!");
                    break;

                    
                case 2:
                    System.out.printf("%-10s %-10s %-12s %-12s %-16s %-12s %-12s\n",
                            "ID", "Name", "Type", "Salary", "Bonus/Duration", "Tax", "Net Salary");
                    System.out.println("----------------------------------------------------------------------------------------");

                    
                    for (Employee e : employees) 
                    {
                        if (e instanceof PermanentEmployee p) 
                        {
                            System.out.printf("%-10s %-10s %-12s %-12.2f %-16.2f %-12.2f %-12.2f\n",
                                    e.getEmpId(), e.getName(), "Permanent", e.getBasicSalary(),
                                    p.getBonus(), p.calculateTax(), p.calculateNetSalary());
                        } 
                        else if (e instanceof ContractEmployee c) 
                        {
                            System.out.printf("%-10s %-10s %-12s %-12.2f %-16d %-12.2f %-12.2f\n",
                                    e.getEmpId(), e.getName(), "Contract", e.getBasicSalary(),
                                    c.getContractDuration(), c.calculateTax(), c.calculateNetSalary());
                        }
                    }
                    System.out.println("----------------------------------------------------------------------------------------");
                    break;

                    
                case 3:
                    System.out.print("Enter Employee ID: ");
                    String searchId = sc.nextLine();
                    
                    boolean found = false;
                    
//                    System.out.printf("%-10s %-10s %-12s %-12s %-16s %-12s %-12s\n",
//                            "ID", "Name", "Type", "Salary", "Bonus/Duration", "Tax", "Net Salary");
//                    System.out.println("----------------------------------------------------------------------------------------");

                    
                    for (Employee e : employees) 
                    {
                        if (e.getEmpId().equals(searchId)) 
                        {
                            System.out.printf("%-10s %-10s %-12s %-12s %-16s %-12s %-12s\n",
                            "ID", "Name", "Type", "Salary", "Bonus/Duration", "Tax", "Net Salary");
                            System.out.println("----------------------------------------------------------------------------------------");
                            
                            // Check if employee is PermanentEmployee and assign to p
                            if (e instanceof PermanentEmployee p) 
                            {
                                System.out.printf("%-10s %-10s %-12s %-12.2f %-16.2f %-12.2f %-12.2f\n",
                                    e.getEmpId(), e.getName(), "Permanent", e.getBasicSalary(),
                                    p.getBonus(), p.calculateTax(), p.calculateNetSalary());
                            } 
                            // Check if employee is ContractEmployee and assign to c
                            else if (e instanceof ContractEmployee c) 
                            {
                                 System.out.printf("%-10s %-10s %-12s %-12.2f %-16d %-12.2f %-12.2f\n",
                                    e.getEmpId(), e.getName(), "Contract", e.getBasicSalary(),
                                    c.getContractDuration(), c.calculateTax(), c.calculateNetSalary());
                            }
                            System.out.println("----------------------------------------------------------------------------------------");
                            found = true;
                            break;
                        }
                    }
                    
                    if (!found) 
                        System.out.println("Employee not found!");
                    
                    break;

                    
                case 4:
                    if (employees.isEmpty()) 
                    {
                        System.out.println("No employees found!");
                        break;
                    }
                    
                    Employee highest = employees.get(0);  // assume first employee as highest

                   for(Employee e : employees) 
                   {
                        if(((Payable) e).calculateNetSalary() > ((Payable) highest).calculateNetSalary()) 
                        {
                            highest = e;  // update highest if current employee has more net salary
                        }
                   }
                    
                    System.out.println("Employee with Highest Net Salary:");
                    // Cast to Payable to call the generatePayslip() method from the correct subclass at runtime
                    ((Payable) highest).generatePayslip();
                    
                    break;

                    
                case 5:
                    if (employees.isEmpty()) 
                    {
                        System.out.println("No employees to calculate average!");
                        break;
                    }
                    
                    double total = 0;
                    for (Employee e : employees) 
                             total += ((Payable) e).calculateNetSalary();
                    
                    System.out.println("Average Net Salary: " + (total / employees.size()));
                    break;

                    
                case 6:
                    System.out.print("Enter Employee ID: ");
                    String pid = sc.nextLine();
                    
                    boolean exist = false;
                    
                    for (Employee e : employees) 
                    {
                        if (e.getEmpId().equals(pid)) 
                        {
                            // Check if employee is PermanentEmployee and assign to p
                            if (e instanceof PermanentEmployee p) 
                            {
                                p.generatePayslip();
                            } 
                            // Check if employee is ContractEmployee and assign to c
                            else if (e instanceof ContractEmployee c) 
                            {
                                c.generatePayslip();
                            }
                            exist = true;
                            break;
                        }
                    }
                    
                    if (!exist) 
                        System.out.println("Employee not found!");
                    
                    break;
                    

                case 7:
                    System.out.println("Total Employees: " + employees.size());
                    
                    double totalSalary = 0;
                    for (Employee e : employees) 
                             totalSalary += ((Payable) e).calculateNetSalary();
                    
                    if (employees.isEmpty()) 
                        System.out.println("Overall Average Salary: 0");
                    else
                        System.out.println(" Overall Average Salary: " + (totalSalary / employees.size()));
                    
                    System.out.println("Thank you!");
                    
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
     
    } 
}
