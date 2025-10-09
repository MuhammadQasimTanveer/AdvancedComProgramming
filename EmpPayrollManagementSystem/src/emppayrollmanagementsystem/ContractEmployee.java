package emppayrollmanagementsystem;

class ContractEmployee extends Employee implements Payable 
{
    private int contractDuration;

    ContractEmployee(String empId, String name, double basicSalary, int contractDuration) 
    {
        super(empId, name, basicSalary);
        this.contractDuration = contractDuration;
    }

    @Override
    double calculateTax() {
        return 0.05 * getBasicSalary();
    }

    @Override
    public double calculateNetSalary() {
        return getBasicSalary() - calculateTax();
    }

    @Override
    public void generatePayslip() 
    {
        System.out.println("----- Contract Employee Payslip -----");
        System.out.println("ID: " + getEmpId());
        System.out.println("Name: " + getName());
        System.out.println("Basic Salary: " + getBasicSalary());
        System.out.println("Contract Duration: " + contractDuration + " months");
        System.out.println("Tax: " + calculateTax());
        System.out.println("Net Salary: " + calculateNetSalary());
        System.out.println("------------------------------------");
    }

    public int getContractDuration() { 
        return contractDuration; 
    }
}
