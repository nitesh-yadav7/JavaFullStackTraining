import java.util.*;

public class Cricket {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Wickets: ");
        int wickets = sc.nextInt();
        System.out.println("Enter Runs: ");
        int runs = sc.nextInt();

        String ans = (wickets >= 3 && runs >= 50) ? "Man of the Match" : "You played well!";
        System.out.println(ans);
        sc.close();
    }
}
