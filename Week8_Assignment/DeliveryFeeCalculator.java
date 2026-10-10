import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;

interface Delivery {
    double fee();
}

class StandardDelivery implements Delivery {
    private final double weight;
    private final double distance;

    StandardDelivery(double weight, double distance) {
        this.weight = weight;
        this.distance = distance;
    }

    public double fee() {
        return 5 + 0.50 * weight + 0.10 * distance;
    }
}

class ExpressDelivery implements Delivery {
    private final double weight;
    private final double distance;

    ExpressDelivery(double weight, double distance) {
        this.weight = weight;
        this.distance = distance;
    }

    public double fee() {
        return 15 + weight + 0.20 * distance;
    }
}

class InternationalDelivery implements Delivery {
    private final double weight;
    private final double distance;
    private final double customsFee;

    InternationalDelivery(double weight, double distance, double customsFee) {
        this.weight = weight;
        this.distance = distance;
        this.customsFee = customsFee;
    }

    public double fee() {
        return 25 + 2 * weight + 0.50 * distance + customsFee;
    }
}

public class DeliveryFeeCalculator {
    public static void main(String[] args) {
        Map<String, Function<String[], Delivery>> deliveryTypes = new HashMap<>();
        deliveryTypes.put("STANDARD", input -> new StandardDelivery(
                Double.parseDouble(input[1]), Double.parseDouble(input[2])));
        deliveryTypes.put("EXPRESS", input -> new ExpressDelivery(
                Double.parseDouble(input[1]), Double.parseDouble(input[2])));
        deliveryTypes.put("INTERNATIONAL", input -> new InternationalDelivery(
                Double.parseDouble(input[1]), Double.parseDouble(input[2]), Double.parseDouble(input[3])));

        Scanner scanner = new Scanner(System.in);
        int count = Integer.parseInt(scanner.nextLine().trim());
        double total = 0;

        for (int i = 0; i < count; i++) {
            String[] input = scanner.nextLine().trim().split("\\s+");
            double fee = deliveryTypes.get(input[0]).apply(input).fee();
            total += fee;
            System.out.printf(Locale.US, "%s: %.2f%n", input[0], fee);
        }

        System.out.printf(Locale.US, "Total: %.2f%n", total);
    }
}