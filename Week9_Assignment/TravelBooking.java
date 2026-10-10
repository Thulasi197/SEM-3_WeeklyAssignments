import java.util.Scanner;

abstract class Travel {
    static final double BOOKING_FEE = 50;

    double distance;

    Travel(double distance) {
        this.distance = distance;
    }

    abstract double calculateFare();

    double calculateTotal() {
        return calculateFare() + BOOKING_FEE;
    }
}

class Bus extends Travel {
    Bus(double distance) {
        super(distance);
    }

    double calculateFare() {
        return distance * 2;
    }
}

class Train extends Travel {
    Train(double distance) {
        super(distance);
    }

    double calculateFare() {
        return distance * 1.5;
    }
}
class Flight extends Travel {
    Flight(double distance) {
        super(distance);
    }
    double calculateFare() {
        return 2500 + distance * 4;
    }
}
public class TravelBooking {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;
        for (int i = 0; i < n; i++) {
            String mode = sc.next().toUpperCase();
            double distance = sc.nextDouble();
            Travel t;
            if (mode.equals("BUS")) {
                t = new Bus(distance);
            } else if (mode.equals("TRAIN")) {
                t = new Train(distance);
            } else if (mode.equals("FLIGHT")) {
                t = new Flight(distance);
            } else {
                continue;
            }
            double fare = t.calculateTotal();
            System.out.printf("%s: %.2f%n", mode, fare);
            total += fare;
        }
        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}