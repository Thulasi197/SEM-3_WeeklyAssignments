import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;

interface PaymentMethod {
    double adjustedAmount();
}

class CardPayment implements PaymentMethod {
    private final double amount;

    CardPayment(double amount) {
        this.amount = amount;
    }

    public double adjustedAmount() {
        return amount * 1.02;
    }
}

class WalletPayment implements PaymentMethod {
    private final double amount;

    WalletPayment(double amount) {
        this.amount = amount;
    }

    public double adjustedAmount() {
        return amount * 1.01;
    }
}

class BankTransferPayment implements PaymentMethod {
    private final double amount;

    BankTransferPayment(double amount) {
        this.amount = amount;
    }

    public double adjustedAmount() {
        return amount;
    }
}

public class PaymentSystem {
    public static void main(String[] args) {
        Map<String, Function<Double, PaymentMethod>> paymentMethods = new HashMap<>();
        paymentMethods.put("CARD", CardPayment::new);
        paymentMethods.put("WALLET", WalletPayment::new);
        paymentMethods.put("BANKTRANSFER", BankTransferPayment::new);

        Scanner scanner = new Scanner(System.in);
        int count = Integer.parseInt(scanner.nextLine().trim());
        double total = 0;

        for (int i = 0; i < count; i++) {
            String[] input = scanner.nextLine().trim().split("\\s+");
            PaymentMethod payment = paymentMethods.get(input[0]).apply(Double.parseDouble(input[1]));
            double adjustedAmount = payment.adjustedAmount();
            total += adjustedAmount;
            System.out.printf(Locale.US, "%s: %.2f%n", input[0], adjustedAmount);
        }

        System.out.printf(Locale.US, "Total: %.2f%n", total);
    }
}