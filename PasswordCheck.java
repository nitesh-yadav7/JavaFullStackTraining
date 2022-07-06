/* -> For a registration form kindly check password and confirm password are same or not */

import java.util.Scanner;

public class PasswordCheck {
    public static void main(String[] args) {
        String p, cp;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Password: ");
        p = sc.nextLine();
        System.out.println("Confirm Password: ");
        cp = sc.nextLine();
        String ans = (p.equals(cp)) ? "Password matched" : "Password not matched";
        System.out.println(ans);
        sc.close();
    }
}
