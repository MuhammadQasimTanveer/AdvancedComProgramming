package emppayrollmanagementsystem;

abstract class Employee 
{
    private String empId;
    private String name;
    private double basicSalary;

    Employee(String empId, String name, double basicSalary) 
    {
        this.empId = empId;
        this.name = name;
        this.basicSalary = basicSalary;
    }

    // Getters & Setters
    public String getEmpId() { 
        return empId; 
    }
    public String getName() { 
        return name; 
    }
    public double getBasicSalary() { 
        return basicSalary; 
    }

    public void setBasicSalary(double basicSalary) 
    { 
        this.basicSalary = basicSalary; 
    }
    public void setEmpId(String empId){
        this.empId = empId;
    }
    public void setName(String name){
        this.name = name;
    }

    // Abstract method
    abstract double calculateTax();
}

