import java.util.Scanner;

class Canteen {
    double amount;

    Canteen(double amount) {
        this.amount = amount;
    }

    double calculateBill() {
        return amount;
    }
}

class Student extends Canteen {
    Student(double amount) {
        super(amount);
    }

    double calculateBill() {
        return amount * 0.90;
    }
}

class Staff extends Canteen {
    Staff(double amount) {
        super(amount);
    }

    double calculateBill() {
        return amount * 0.95;
    }
}

class Guest extends Canteen {
    Guest(double amount) {
        super(amount);
    }

    double calculateBill() {
        return amount + 10;
    }
}

public class CanteenBilling {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String type = sc.next().toUpperCase();
        double amount = sc.nextDouble();

        Canteen c;

        if (type.equals("STUDENT")) {
            c = new Student(amount);
        } else if (type.equals("STAFF")) {
            c = new Staff(amount);
        } else if (type.equals("GUEST")) {
            c = new Guest(amount);
        } else {
            System.out.println("Invalid type");
            sc.close();
            return;
        }

        System.out.printf("Final Bill: %.2f%n", c.calculateBill());

        sc.close();
    }
}