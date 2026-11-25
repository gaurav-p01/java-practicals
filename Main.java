class employee{

     int empId ;
     String name; 
     String department;

    employee(int empId, String name, String department ){
         this.empId = empId;
         this.name = name;
         this.department = department;
    }

    
    void display(){

    }

    double calculateSalary(){
        return 0.0;
    }
}

class FullTimeEmployee extends employee{

        double basicSalary;
    double bonus;

    FullTimeEmployee(int empId, String name, String department,
                     double basicSalary, double bonus) {
        super(empId, name, department);   
        this.basicSalary = basicSalary;
        this.bonus = bonus;
    }

    @Override
    double calculateSalary() {            
        return basicSalary + bonus;
    }
}

class PartTimeEmployee extends employee {
    private int hoursWorked;
    private double hourlyRate;

    PartTimeEmployee(int empId, String name, String department,
                     int hoursWorked, double hourlyRate) {
        super(empId, name, department);
        this.hoursWorked = hoursWorked;
        this.hourlyRate = hourlyRate;
    }

    @Override
    double calculateSalary() {
        return hoursWorked * hourlyRate;
    }
}



public class Main {
    public static void main(String[] args) {   
        employee e1 = new FullTimeEmployee(1, "Aditya", "IT", 50000, 5000);
        employee e2 = new PartTimeEmployee(2, "Kartikey", "HR", 80, 300);

        e1.display();
        System.out.println("Salary: " + e1.calculateSalary());
        e2.display();
        System.out.println("Salary: " + e2.calculateSalary());
    }
}
