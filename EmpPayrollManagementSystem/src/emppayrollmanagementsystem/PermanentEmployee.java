package emppayrollmanagementsystem;

class PermanentEmployee extends Employee implements Payable 
{
    private double bonus;

    PermanentEmployee(String empId, String name, double basicSalary, double bonus) 
    {
        super(empId, name, basicSalary);
        this.bonus = bonus;
    }

    @Override
    double calculateTax() {
        return 0.10 * (getBasicSalary() + bonus);
    }

    @Override
    public double calculateNetSalary() {
        return (getBasicSalary() + bonus) - calculateTax();
    }

    @Override
    public void generatePayslip() 
    {
        System.out.println("----- Permanent Employee Payslip -----");
        System.out.println("ID: " + getEmpId());
        System.out.println("Name: " + getName());
        System.out.println("Basic Salary: " + getBasicSalary());
        System.out.println("Bonus: " + bonus);
        System.out.println("Tax: " + calculateTax());
        System.out.println("Net Salary: " + calculateNetSalary());
        System.out.println("--------------------------------------");
    }

    public double getBonus() { 
        return bonus; 
    }
}
