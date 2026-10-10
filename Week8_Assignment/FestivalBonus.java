import java.util.Scanner;

class Employee {
    double salary;

    Employee(double salary) {
        this.salary = salary;
    }

    double calculateBonus() {
        return 0;
    }
}

class FullTime extends Employee {
    FullTime(double salary) {
        super(salary);
    }

    double calculateBonus() {
        return salary * 0.10;
    }
}

class PartTime extends Employee {
    PartTime(double salary) {
        super(salary);
    }

    double calculateBonus() {
        return salary * 0.05;
    }
}

class Intern extends Employee {
    Intern(double salary) {
        super(salary);
    }

    double calculateBonus() {
        return 2000;
    }
}

public class FestivalBonus {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String type = sc.next().toUpperCase();
        double salary = sc.nextDouble();

        Employee e;

        if (type.equals("FULLTIME")) {
            e = new FullTime(salary);
        } else if (type.equals("PARTTIME")) {
            e = new PartTime(salary);
        } else if (type.equals("INTERN")) {
            e = new Intern(salary);
        } else {
            System.out.println("Invalid type");
            sc.close();
            return;
        }

        System.out.printf("Festival Bonus: %.2f%n", e.calculateBonus());

        sc.close();
    }
}