import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

interface LibraryItem {
    String title();
    LocalDate dueDate();
}

abstract class BorrowedItem implements LibraryItem {
    private final String title;
    private final int borrowingDays;

    BorrowedItem(String title, int borrowingDays) {
        this.title = title;
        this.borrowingDays = borrowingDays;
    }

    public String title() {
        return title;
    }

    public LocalDate dueDate() {
        return LocalDate.of(2023, 10, 26).plusDays(borrowingDays);
    }
}

class BookItem extends BorrowedItem {
    BookItem(String title) {
        super(title, 14);
    }
}

class DvdItem extends BorrowedItem {
    DvdItem(String title) {
        super(title, 7);
    }
}

class MagazineItem extends BorrowedItem {
    MagazineItem(String title) {
        super(title, 3);
    }
}

public class LibraryDueDateCalculator {
    private static String[] tokens(String line) {
        Matcher matcher = Pattern.compile("\\\"([^\\\"]*)\\\"|(\\S+)").matcher(line);
        java.util.ArrayList<String> values = new java.util.ArrayList<>();
        while (matcher.find()) {
            values.add(matcher.group(1) != null ? matcher.group(1) : matcher.group(2));
        }
        return values.toArray(new String[0]);
    }

    public static void main(String[] args) {
        Map<String, Function<String, LibraryItem>> itemTypes = new HashMap<>();
        itemTypes.put("BOOK", BookItem::new);
        itemTypes.put("DVD", DvdItem::new);
        itemTypes.put("MAGAZINE", MagazineItem::new);

        Scanner scanner = new Scanner(System.in);
        int count = Integer.parseInt(scanner.nextLine().trim());

        for (int i = 0; i < count; i++) {
            String[] input = tokens(scanner.nextLine());
            LibraryItem item = itemTypes.get(input[0]).apply(input[1]);
            System.out.println(item.title() + ": " + item.dueDate());
        }
    }
}