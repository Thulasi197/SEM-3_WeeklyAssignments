import java.util.*;
class StudentRecord {
    static void parse(String s) {
        String[] a = s.split(",");
        if (a.length != 3) {
            System.out.println("Invalid Record");
            return;
        }
        System.out.println("Name: " + a[0]);
        System.out.println("Roll No: " + a[1]);
        System.out.println("Dept: " + a[2]);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter record: ");
        parse(sc.nextLine());
    }
}