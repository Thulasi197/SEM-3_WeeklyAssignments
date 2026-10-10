import java.time.LocalDate;
import java.util.Scanner;

class Subscription {
    LocalDate startDate;

    Subscription(LocalDate startDate) {
        this.startDate = startDate;
    }

    LocalDate calculateRenewalDate() {
        return startDate;
    }
}

class Monthly extends Subscription {
    Monthly(LocalDate startDate) {
        super(startDate);
    }

    LocalDate calculateRenewalDate() {
        return startDate.plusDays(30);
    }
}

class Quarterly extends Subscription {
    Quarterly(LocalDate startDate) {
        super(startDate);
    }

    LocalDate calculateRenewalDate() {
        return startDate.plusDays(90);
    }
}

class Yearly extends Subscription {
    Yearly(LocalDate startDate) {
        super(startDate);
    }

    LocalDate calculateRenewalDate() {
        return startDate.plusDays(365);
    }
}

public class StreamingRenewal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String type = sc.next().toUpperCase();
        LocalDate date = LocalDate.parse(sc.next());

        Subscription s;

        if (type.equals("MONTHLY")) {
            s = new Monthly(date);
        } else if (type.equals("QUARTERLY")) {
            s = new Quarterly(date);
        } else if (type.equals("YEARLY")) {
            s = new Yearly(date);
        } else {
            System.out.println("Invalid type");
            sc.close();
            return;
        }

        System.out.println("Renewal Date: " + s.calculateRenewalDate());

        sc.close();
    }
}