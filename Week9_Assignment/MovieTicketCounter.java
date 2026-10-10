import java.util.Scanner;

abstract class Ticket {
    static final double FEE = 20;
    int count;

    Ticket(int count) {
        this.count = count;
    }

    abstract double calculatePrice();

    double calculateTotal() {
        return (calculatePrice() + FEE) * count;
    }
}

class Regular extends Ticket {
    Regular(int count) {
        super(count);
    }

    double calculatePrice() {
        return 150;
    }
}

class Premium extends Ticket {
    Premium(int count) {
        super(count);
    }

    double calculatePrice() {
        return 250;
    }
}

class Recliner extends Ticket {
    Recliner(int count) {
        super(count);
    }

    double calculatePrice() {
        return 400;
    }
}

public class MovieTicketCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String seat = sc.next().toUpperCase();
            int count = sc.nextInt();

            Ticket t;

            if (seat.equals("REGULAR")) {
                t = new Regular(count);
            } else if (seat.equals("PREMIUM")) {
                t = new Premium(count);
            } else if (seat.equals("RECLINER")) {
                t = new Recliner(count);
            } else {
                continue;
            }

            double amount = t.calculateTotal();
            System.out.printf("%s: %.2f%n", seat, amount);
            total += amount;
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}