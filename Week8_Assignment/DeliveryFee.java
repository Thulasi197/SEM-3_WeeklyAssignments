import java.util.Scanner;

class Delivery {
    double weight;
    double distance;

    Delivery(double weight, double distance) {
        this.weight = weight;
        this.distance = distance;
    }

    double calculateFee() {
        return 0;
    }
}

class StandardDelivery extends Delivery {
    StandardDelivery(double weight, double distance) {
        super(weight, distance);
    }

    double calculateFee() {
        return 5 + (0.50 * weight) + (0.10 * distance);
    }
}

class ExpressDelivery extends Delivery {
    ExpressDelivery(double weight, double distance) {
        super(weight, distance);
    }

    double calculateFee() {
        return 15 + (1.00 * weight) + (0.20 * distance);
    }
}

class InternationalDelivery extends Delivery {
    double customsFee;

    InternationalDelivery(double weight, double distance, double customsFee) {
        super(weight, distance);
        this.customsFee = customsFee;
    }

    double calculateFee() {
        return 25 + (2.00 * weight) + (0.50 * distance) + customsFee;
    }
}

public class DeliveryFee {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double weight = sc.nextDouble();
            double distance = sc.nextDouble();

            Delivery delivery;

            if (type.equalsIgnoreCase("STANDARD")) {
                delivery = new StandardDelivery(weight, distance);
            } else if (type.equalsIgnoreCase("EXPRESS")) {
                delivery = new ExpressDelivery(weight, distance);
            } else {
                double customsFee = sc.nextDouble();
                delivery = new InternationalDelivery(weight, distance, customsFee);
            }

            double fee = delivery.calculateFee();
            System.out.printf("%s: %.2f%n", type, fee);
            total += fee;
        }

        System.out.printf("Total: %.2f%n", total);
    }
}