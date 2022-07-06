/* Task 3 -make all the odd number of characters in a sentence capital */

import java.util.Scanner;

public class OddCharUpper {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter String: ");
        String name = sc.nextLine();
        String[] ans = name.split("");
        String result = "";
        boolean flag = true;
        for (String str : ans) {
            if (str.equals(" ")) {
                result += str;
                continue;
            }
            if (flag) {
                result += str.toUpperCase();
            } else {
                result += str;
            }
            flag = !flag;
        }
        System.out.print("Result: " + result);
        sc.close();
    }
}
