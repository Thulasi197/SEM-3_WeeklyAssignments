import java.util.Scanner;
abstract class LibraryItem {
    String title;
    int daysLate;
    LibraryItem(String title, int daysLate) {
        this.title = title;
        this.daysLate = daysLate;
    }
    abstract double calculateFine();
}
class Book extends LibraryItem {
    Book(String title, int daysLate) {
        super(title, daysLate);
    }
    double calculateFine() {
        return daysLate * 2.0;
    }
}
class DVD extends LibraryItem {
    DVD(String title, int daysLate) {
        super(title, daysLate);
    }
    double calculateFine() {
        return Math.min(daysLate * 5.0, 50.0);
    }
}
class Magazine extends LibraryItem {
    Magazine(String title, int daysLate) {
        super(title, daysLate);
    }
    double calculateFine() {
        return daysLate * 1.0;
    }
}
public class LibraryLateFineCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;
        for (int i = 0; i < n; i++) {
            String type = sc.next().toUpperCase();
            String title = sc.next();
            int days = sc.nextInt();
            LibraryItem item;
            if (type.equals("BOOK")) {
                item = new Book(title, days);
            } else if (type.equals("DVD")) {
                item = new DVD(title, days);
            } else if (type.equals("MAGAZINE")) {
                item = new Magazine(title, days);
            } else {
                continue;
            }
            double fine = item.calculateFine();
            System.out.printf("%s: %.2f%n", title, fine);
            total += fine;
        }
        System.out.printf("Total Fines: %.2f%n", total);
        sc.close();
    }
}