import java.util.Scanner;
class Electricity {
    double units;
    Electricity(double units) {
        this.units = units;
    }
    double calculateBill() {
        return 0;
    }
}
class Single extends Electricity {
    Single(double units) {
        super(units);
    }
    double calculateBill() {
        return units * 8;
    }
}
class Shared extends Electricity {
    int occupants;
    Shared(double units, int occupants) {
        super(units);
        this.occupants = occupants;
    }
    double calculateBill() {
        return (units * 6) / occupants;
    }
}

class AC extends Electricity {
    AC(double units) {
        super(units);
    }

    double calculateBill() {
        return units * 10 + 200;
    }
}
public class HostelElectricity {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String type = sc.next().toUpperCase();
        double units = sc.nextDouble();
        Electricity e;

        if (type.equals("SINGLE")) {
            e = new Single(units);
        } else if (type.equals("SHARED")) {
            int occupants = sc.nextInt();

            if (occupants <= 0) {
                System.out.println("Invalid occupants");
                sc.close();
                return;
            }

            e = new Shared(units, occupants);
        } else if (type.equals("AC")) {
            e = new AC(units);
        } else {
            System.out.println("Invalid type");
            sc.close();
            return;
        }

        System.out.printf("Electricity Bill: %.2f%n", e.calculateBill());

        sc.close();
    }
}