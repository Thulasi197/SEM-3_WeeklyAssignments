package Week6_Assignment;
class IDCard {
    String name;
    int booksIssued;
    IDCard(String name, int booksIssued) {
        this.name = name;
        this.booksIssued = booksIssued;
    }
    public static void main(String[] args) {
        IDCard Thulasi = new IDCard("Thulasi", 0);
        IDCard duplicate = Thulasi;
        duplicate.booksIssued = 3;
        IDCard separate = new IDCard("Thulasi", 3);
        System.out.println("Thulasii's booksIssued (via first variable): " + Thulasi.booksIssued);
        System.out.println("duplicate == Thulasi: " + (duplicate == Thulasi));
        System.out.println("separate == Thulasi: " + (separate == Thulasi));
    }
}