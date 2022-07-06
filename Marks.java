import java.util.Scanner;

public class Marks {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Marks: ");
        int p = sc.nextInt();
        String ans = (p >= 75) ? "Distinction" : 
            (p < 75 && p >= 60) ? "First Class" :
            (p < 60 && p >= 35) ? "Second Class" : "Failed";
        System.out.println(ans);
        sc.close();
    }
}
