import java.util.Scanner;
class Parking {
    int hours;
    Parking(int hours) {
        this.hours = hours;
    }
    double calculateFee() {
        return 0;
    }
}
class Bike extends Parking {
    Bike(int hours) {
        super(hours);
    }
    double calculateFee() {
        return hours * 10;
    }
}
class Car extends Parking {
    Car(int hours) {
        super(hours);
    }
    double calculateFee() {
        if (hours <= 1) {
            return 30;
        } else {
            return 30 + (hours - 1) * 20;
        }
    }
}
class Truck extends Parking {
    Truck(int hours) {
        super(hours);
    }
    double calculateFee() {
        return Math.max(hours * 50, 100);
    }
}
public class CampusParking {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String type = sc.next().toUpperCase();
        int hours = sc.nextInt();

        Parking p;

        if (type.equals("BIKE")) {
            p = new Bike(hours);
        } else if (type.equals("CAR")) {
            p = new Car(hours);
        } else if (type.equals("TRUCK")) {
            p = new Truck(hours);
        } else {
            System.out.println("Invalid type");
            sc.close();
            return;
        }
        System.out.printf("Parking Fee: %.2f%n", p.calculateFee());
        sc.close();
    }
}