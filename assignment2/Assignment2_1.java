import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * The deadline of this assignment is 09/25/2020 23:59 PST.
 * Please feel free to contact Yafei and Yaqi for any questions.
 */

class Employee {
    String name;
    int age;
    Gender gender;
    double salary;// salary per month

    // Constructor. Please set all the data in constructor.
    public Employee(String name, int age, Gender gender, double salary) {
        //write your code here
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.salary = salary;
    }

    // Getter for `name`. Return the current `name` data
    public String getName() {
        //write your code here
        return this.name;
    }

    // Setter for `name`. Set `name` data
    public void setName(String name) {
        //write your code here
        this.name = name;
    }

    // Try to add a new method in Employee class: public void raiseSalary(double byPercent)
    public void raiseSalary(double byPercent) {
        /* pay attention, my parameter is the raised percentage,
        *  rather than the total number, if the original salary is 1,
        *  and the new salary is 3, then the parameter should be 2,
        *  instead of 3.
        * */
        this.salary = this.salary * (1 + byPercent/100.0);
    }

    @Override
    public String toString() {
        String pronoun = null;
        if (gender == Gender.MALE) {
            pronoun = "his";
        } else if (gender == Gender.FEMALE) {
            pronoun = "her";
        }
        return "Employee " + name + " is " + age + " years old, "
                + pronoun + " salary is " + salary;
    }

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}
}

enum Gender {
    MALE,
    FEMALE;
}

public class Assignment2_1 {
    // Assignment

    /**
     * Write a method to calculate the Social Security Tax of an employee and print it.
     * If the salary is less than or equal to 8900, the Social Security Tax is 6.2% of the salary.
     * If the salary is more than 8900, the Social Security Tax is 6.2% of 106,800.
     */
    public double socialSecurityTax(Employee employee) {
        //write your code here
        double tax = 0;
        if (employee.salary <= 8900) {
            // If the salary is less than or equal to 8900, the Social Security Tax is 6.2% of the salary.
            tax = employee.salary * 0.062;
        } else {
            // If the salary is more than 8900, the Social Security Tax is 6.2% of 106,800.
            tax = 106800 * 0.062;
        }
        // print it
        System.out.println("the Social Security Tax is " + tax);
        return tax;
    }

    /**
     * Write a method to calculate an employee's contribution for insurance coverage and print it.
     * Amount of deduction is computed as follows:
     * If the employee is under 35, rate is 3% of salary; if the employee is between 35 and 50(inclusive), rate is 4% of salary;
     * If the employee is between 50 and 60(exclusive), rate is 5% of salary; If the employee is above 60, rate is 6% of salary.
     */
    // if Jenny is 20 and her salary is 2000, the answer should be 2000*3%
    public double insuranceCoverage(Employee employee) {
        //write your code here
        double ans = 0;
        if (employee.age < 35) {
            ans = employee.salary * 0.03;
        } else if (employee.age <= 50) {
            ans = employee.salary * 0.04;
        } else if (employee.age <= 60) {
            ans = employee.salary * 0.05;
        } else {
            ans = employee.salary * 0.06;
        }
        // print it
        System.out.println("the contribution for insurance coverage is " + ans);
        return ans;
    }

    /**
     * Write a method to sort three employees' salary from low to high, and then print their name in order.
     * For example, Alice's salary is 1000, John's salary is 500, Jenny's salary is 1200, you should print:
     * John Alice Jenny
     */
    public void sortSalary(Employee e1, Employee e2, Employee e3) {
        //write your code here
        List<Employee> list = new ArrayList<>();
        list.add(e1);
        list.add(e2);
        list.add(e3);
        list.sort(new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                return Double.compare(o1.getSalary(), o2.getSalary());
            }
        });
        for (Employee e: list) {
            System.out.print(e.name + " ");
        }
        System.out.println();
    }

    /**
     * Write a method to raise an employee's salary to three times of his/her original salary.
     * Eg: original salary was 1000/month. After using this method, the salary is 3000/month.
     * Do not change the input of this method.
     * Try to add a new method in Employee class: public void raiseSalary(double byPercent)
     */
    public void tripleSalary(Employee employee) {
        //write your code here
        /* the input should be Employee and should change salary to the
            triple one by calling the method in Employee class.
        * */
        /* pay attention, my parameter is the raised percentage,
         *  rather than the total number, if the original salary is 2500,
         *  and the new salary is 7500, then the parameter should be 200,
         *   rather than 300.
         * */
        employee.raiseSalary(200);
    }

    //Extra credit

    /**
     * I have written some code below. What I want is to swap two Employee objects.
     * One is Jenny and one is John. But after running it, I got the result below:
     * Before: a=Jenny
     * Before: b=John
     * After: a=Jenny
     * After: b=John
     * There is no change after swap()! Do you know the reason why my swap failed?
     * Write your understanding of the reason and explain it.
     */
    /*
      Answer:
      Because Employee is a reference type.

      In the main method, variable a is the reference which will point to
      ""Jenny", 20, Gender.FEMALE, 2000", same as variable b.

      When passing parameter into methods, the reference types will
      only pass their address of reference to the method. So variable a
      will pass its address, and variable b will pass b's address.
      Therefore, in swap method, x is the copy of a's address, y is the
      copy of b's address, which means x will point to ""Jenny", 20, Gender.FEMALE, 2000",
      and y will point to "John", 30, Gender.MALE, 2500.

      Then, "Employee temp = x;" declares a variable temp and makes temp point to
      ""Jenny", 20, Gender.FEMALE, 2000". "x = y;" and "y = temp;" only makes x and
      y point to each other's object, but will not influence a and b.
    */
    // we should use the swap2 method to swap two Employee objects
    public static void swap2(Employee x, Employee y) {
    	Employee temp = new Employee(x.name, x.age, x.gender, x.salary);
        x.name = y.name;
        x.age = y.age;
        x.gender = y.gender;
        x.salary = y.salary;
        y.name = temp.name;
        y.age = temp.age;
        y.gender = temp.gender;
        y.salary = temp.salary;
    }

    public static void main(String[] args) {
    	Employee a = new Employee("Jenny", 20, Gender.FEMALE, 2000);
    	Employee b = new Employee("John", 30, Gender.MALE, 2500);
        System.out.println("Before: a=" + a.getName());
        System.out.println("Before: b=" + b.getName());
        swap(a, b);
        System.out.println("After: a=" + a.getName());
        System.out.println("After: b=" + b.getName());

        // my demo
        Employee c = new Employee("Alice", 50, Gender.FEMALE, 10000);
        Assignment2_1 obj = new Assignment2_1();

        // some output
        System.out.println("\nSome output to show the usage of method.");

        // show socialSecurityTax
        System.out.println("\nsocialSecurityTax method.");
        System.out.println(a);
        double aSocialSecurityTax = obj.socialSecurityTax(a);
        System.out.println(b);
        double bSocialSecurityTax = obj.socialSecurityTax(b);
        System.out.println(c);
        double cSocialSecurityTax = obj.socialSecurityTax(c);

        // insuranceCoverage
        System.out.println("\ninsuranceCoverage method.");
        System.out.println(a);
        double aInsuranceCoverage = obj.insuranceCoverage(a);
        System.out.println(b);
        double bInsuranceCoverage = obj.insuranceCoverage(b);
        System.out.println(c);
        double cInsuranceCoverage = obj.insuranceCoverage(c);

        // sortSalary
        System.out.println("\nsortSalary method.");
        System.out.println("The information of three employees:");
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println("The result of sortSalary method:");
        obj.sortSalary(a, b, c);

        // tripleSalary
        System.out.println("\ntripleSalary method.");
        System.out.println("Before calling the tripleSalary method:");
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println("After calling the tripleSalary method: ");
        obj.tripleSalary(a);
        obj.tripleSalary(b);
        obj.tripleSalary(c);
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);

        /*
        * Console output
Before: a=Jenny
Before: b=John
After: a=Jenny
After: b=John

Some output to show the usage of method.

socialSecurityTax method.
Employee Jenny is 20 years old, her salary is 2000.0
the Social Security Tax is 124.0
Employee John is 30 years old, his salary is 2500.0
the Social Security Tax is 155.0
Employee Alice is 50 years old, her salary is 10000.0
the Social Security Tax is 6621.6

insuranceCoverage method.
Employee Jenny is 20 years old, her salary is 2000.0
the contribution for insurance coverage is 60.0
Employee John is 30 years old, his salary is 2500.0
the contribution for insurance coverage is 75.0
Employee Alice is 50 years old, her salary is 10000.0
the contribution for insurance coverage is 400.0

sortSalary method.
The information of three employees:
Employee Jenny is 20 years old, her salary is 2000.0
Employee John is 30 years old, his salary is 2500.0
Employee Alice is 50 years old, her salary is 10000.0
The result of sortSalary method:
Jenny John Alice 

tripleSalary method.
Before calling the tripleSalary method:
Employee Jenny is 20 years old, her salary is 2000.0
Employee John is 30 years old, his salary is 2500.0
Employee Alice is 50 years old, her salary is 10000.0
After calling the tripleSalary method: 
Employee Jenny is 20 years old, her salary is 6000.0
Employee John is 30 years old, his salary is 7500.0
Employee Alice is 50 years old, her salary is 30000.0

Process finished with exit code 0
        * */
    }

    public static void swap(Employee x, Employee y) {
    	Employee temp = x;
        x = y;
        y = temp;
    }
}
