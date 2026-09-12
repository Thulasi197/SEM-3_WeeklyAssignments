import java.util.*;
class RockPaperScissors {
    static String playRound(String p, String c) {
        if (p.equals(c)) return "Draw";
        if ((p.equals("Rock") && c.equals("Scissors")) ||
            (p.equals("Paper") && c.equals("Rock")) ||
            (p.equals("Scissors") && c.equals("Paper")))
            return "Player Wins";
        return "Computer Wins";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] a = {"Rock","Paper","Scissors"};
        int w=0,l=0,d=0;

        for(int i=0;i<5;i++) {
            System.out.print("Enter move: ");
            String p=sc.next();
            String c=a[new Random().nextInt(3)];
            String r=playRound(p,c);
            System.out.println("Computer: "+c+" Result: "+r);

            if(r.equals("Player Wins")) w++;
            else if(r.equals("Computer Wins")) l++;
            else d++;
        }
        System.out.println("Wins: "+w+" Losses: "+l+" Draws: "+d);
    }
}