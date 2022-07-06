import java.util.Scanner;

public class MultiplicationException {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter num1: ");
        Integer num1 = sc.nextInt();
        System.out.println("Enter num2: ");
        Integer num2 = sc.nextInt();
        sc.close();
        try {
            if (num1 == 0 || num2 == 0) {
                throw new Exception();
            } else {
                System.out.println("Multiplication Result: " + (num1 * num2));
            }
        } catch (Exception e) {
            System.out.println("Multiplication Zero Exception");
        }
        
    }
}
