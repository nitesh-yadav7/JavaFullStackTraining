import java.util.Scanner;

public class NameInitials {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Name: ");
        String name = sc.nextLine();
        String[] ans = name.split(" ");
        String result = "";
        for (String str : ans) {
            result += (" " + str.charAt(0));
        }
        System.out.print("Name Initials: " + result);
        sc.close();
    }
}