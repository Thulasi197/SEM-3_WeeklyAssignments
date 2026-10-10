import java.util.Scanner;
abstract class Connection {
    double units;
    Connection(double units) {
        this.units = units;
    }
    abstract double calculateBill();
}
class Home extends Connection {
    Home(double units) {
        super(units);
    }
    double calculateBill() {
        if (units <= 100) {
            return units * 5;
        } else {
            return 100 * 5 + (units - 100) * 7;
        }
    }
}
class Shop extends Connection {
    Shop(double units) {
        super(units);
    }
    double calculateBill() {
        return units * 8 + 100;
    }
}
class Factory extends Connection {
    Factory(double units) {
        super(units);
    }
    double calculateBill() {
        return Math.max(units * 6, 1000);
    }
}
public class ElectricityConnectionBilling {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next().toUpperCase();
            double units = sc.nextDouble();
            Connection c;
            if (type.equals("HOME")) {
                c = new Home(units);
            } else if (type.equals("SHOP")) {
                c = new Shop(units);
            } else if (type.equals("FACTORY")) {
                c = new Factory(units);
            } else {
                continue;
            }
            double bill = c.calculateBill();
            System.out.printf("%s: %.2f%n", type, bill);
            total += bill;
        }
        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}
