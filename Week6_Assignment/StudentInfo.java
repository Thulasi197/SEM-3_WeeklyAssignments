package Week6_Assignment;
class StudentInfo {
    String name;
    double attendance;

    static String collegeName = "SRM Institute of Science and Technology";
    static int studentInfoCount = 0;

    StudentInfo(String name, double attendance) {
        this.name = name;
        this.attendance = attendance;
        studentInfoCount++;
    }

    static void printCollegeInfo() {
        System.out.println("College: " + collegeName);
        System.out.println("Students created: " + studentInfoCount);
    }

    public static void main(String[] args) {
        StudentInfo s1 = new StudentInfo("Ravi", 85);
        StudentInfo s2 = new StudentInfo("Anitha", 90);

        StudentInfo.printCollegeInfo();
    }
}