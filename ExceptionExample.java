import java.util.*;

public class ExceptionExample {
    public static void main(String[] args) {
        Random rn = new Random();
        int num = rn.nextInt(3) + 1;
        try {
            switch (num) {
                case 1: int a=5, b=0; 
                        int c = a/b;
                        System.out.println(c);
                        break;
                case 2: int[] marks = new int[3]; 
                        System.out.println(marks[4]);
                        break;
                case 3: Integer n = null; 
                        int ans = (n > 0) ? 1 : -1;
                        System.out.println(ans);
            }
        } catch(ArithmeticException e) {
            System.out.println("Arithmetic Exception block");
        } catch(ArrayIndexOutOfBoundsException e) {
            System.out.println("Array Index Out of Bound Exception block");
        } catch(Exception e) {
            System.out.println("Exception block");
        }
    }
}
