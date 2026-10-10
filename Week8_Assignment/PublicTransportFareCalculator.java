import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;

interface Transport {
    double fare();
}

class BusTransport implements Transport {
    private final double distance;

    BusTransport(double distance) {
        this.distance = distance;
    }

    public double fare() {
        return Math.min(2 + 0.10 * distance, 10);
    }
}

class TrainTransport implements Transport {
    private final double distance;

    TrainTransport(double distance) {
        this.distance = distance;
    }

    public double fare() {
        return 3 + 0.15 * distance;
    }
}

class MetroTransport implements Transport {
    private final double distance;
    private final double peakHourFactor;

    MetroTransport(double distance, double peakHourFactor) {
        this.distance = distance;
        this.peakHourFactor = peakHourFactor;
    }

    public double fare() {
        return (1.50 + 0.20 * distance) * peakHourFactor;
    }
}

public class PublicTransportFareCalculator {
    public static void main(String[] args) {
        Map<String, Function<String[], Transport>> transportTypes = new HashMap<>();
        transportTypes.put("BUS", input -> new BusTransport(Double.parseDouble(input[1])));
        transportTypes.put("TRAIN", input -> new TrainTransport(Double.parseDouble(input[1])));
        transportTypes.put("METRO", input -> new MetroTransport(
                Double.parseDouble(input[1]), Double.parseDouble(input[2])));

        Scanner scanner = new Scanner(System.in);
        int count = Integer.parseInt(scanner.nextLine().trim());
        double total = 0;

        for (int i = 0; i < count; i++) {
            String[] input = scanner.nextLine().trim().split("\\s+");
            double fare = transportTypes.get(input[0]).apply(input).fare();
            total += fare;
            System.out.printf(Locale.US, "%s: %.2f%n", input[0], fare);
        }

        System.out.printf(Locale.US, "Total: %.2f%n", total);
    }
}