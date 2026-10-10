import java.util.Locale;
import java.util.Scanner;

interface Transport {
    double fare(double distance);
    String type();
}

class Bus implements Transport {
    public double fare(double distance) {
        return Math.min(10, 2 + 0.10 * distance);
    }

    public String type() {
        return "BUS";
    }
}

class Train implements Transport {
    public double fare(double distance) {
        return 3 + 0.15 * distance;
    }

    public String type() {
        return "TRAIN";
    }
}

class Metro implements Transport {
    double factor;

    Metro(double factor) {
        this.factor = factor;
    }

    public double fare(double distance) {
        return (1.50 + 0.20 * distance) * factor;
    }

    public String type() {
        return "METRO";
    }
}

public class PublicTransportFareCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double distance = sc.nextDouble();
            Transport t;

            if (type.equalsIgnoreCase("BUS")) {
                t = new Bus();
            } else if (type.equalsIgnoreCase("TRAIN")) {
                t = new Train();
            } else {
                double factor = sc.nextDouble();
                t = new Metro(factor);
            }

            double fare = t.fare(distance);
            System.out.printf(Locale.US, "%s: %.2f%n", t.type(), fare);
            total += fare;
        }

        System.out.printf(Locale.US, "Total: %.2f%n", total);
    }
}
