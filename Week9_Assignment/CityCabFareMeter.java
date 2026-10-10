import java.util.Scanner;

abstract class Cab {
    double km;

    Cab(double km) {
        this.km = km;
    }

    abstract double getRate();

    boolean supportsNight() {
        return false;
    }

    double calculateFare(boolean night) {
        double fare = Math.max(km * getRate(), 100);

        if (night && supportsNight()) {
            fare = fare * 1.20;
        }

        return fare;
    }
}

class Mini extends Cab {
    Mini(double km) {
        super(km);
    }

    double getRate() {
        return 10;
    }
}

class Sedan extends Cab {
    Sedan(double km) {
        super(km);
    }

    double getRate() {
        return 14;
    }

    boolean supportsNight() {
        return true;
    }
}

class SUV extends Cab {
    SUV(double km) {
        super(km);
    }

    double getRate() {
        return 18;
    }

    boolean supportsNight() {
        return true;
    }
}

public class CityCabFareMeter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next().toUpperCase();
            double km = sc.nextDouble();
            String time = sc.next().toUpperCase();

            Cab c;

            if (type.equals("MINI")) {
                c = new Mini(km);
            } else if (type.equals("SEDAN")) {
                c = new Sedan(km);
            } else if (type.equals("SUV")) {
                c = new SUV(km);
            } else {
                continue;
            }

            if (time.equals("NIGHT") && !c.supportsNight()) {
                System.out.println(type + ": night service not available");
            } else {
                double fare = c.calculateFare(time.equals("NIGHT"));
                System.out.printf("%s: %.2f%n", type, fare);
                total += fare;
            }
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}
