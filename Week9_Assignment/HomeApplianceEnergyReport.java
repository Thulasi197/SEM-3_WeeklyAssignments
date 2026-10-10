import java.util.Scanner;

abstract class Appliance {
    double hours;

    Appliance(double hours) {
        this.hours = hours;
    }

    abstract double getPower();

    boolean supportsSaver() {
        return false;
    }

    double calculateUnits(boolean saver) {
        double units = getPower() * hours / 1000;

        if (saver && supportsSaver()) {
            units = units * 0.75;
        }

        return units;
    }
}

class Fridge extends Appliance {
    Fridge(double hours) {
        super(hours);
    }

    double getPower() {
        return 150;
    }
}

class AC extends Appliance {
    AC(double hours) {
        super(hours);
    }

    double getPower() {
        return 1500;
    }

    boolean supportsSaver() {
        return true;
    }
}

class TV extends Appliance {
    TV(double hours) {
        super(hours);
    }

    double getPower() {
        return 100;
    }
}

class Washer extends Appliance {
    Washer(double hours) {
        super(hours);
    }

    double getPower() {
        return 500;
    }

    boolean supportsSaver() {
        return true;
    }
}

public class HomeApplianceEnergyReport {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double totalCost = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next().toUpperCase();
            double hours = sc.nextDouble();

            boolean saver = false;

            if (sc.hasNextLine()) {
                String remaining = sc.nextLine().trim();
                saver = remaining.equalsIgnoreCase("SAVER");
            }

            Appliance a;

            if (type.equals("FRIDGE")) {
                a = new Fridge(hours);
            } else if (type.equals("AC")) {
                a = new AC(hours);
            } else if (type.equals("TV")) {
                a = new TV(hours);
            } else if (type.equals("WASHER")) {
                a = new Washer(hours);
            } else {
                continue;
            }

            if (saver && !a.supportsSaver()) {
                System.out.println(type + ": saver mode not supported");
            } else {
                double units = a.calculateUnits(saver);
                double cost = units * 8;

                System.out.printf(
                    "%s: Units=%.2f Cost=%.2f%n",
                    type, units, cost
                );

                totalCost += cost;
            }
        }

        System.out.printf("Total Cost: %.2f%n", totalCost);
        sc.close();
    }
}