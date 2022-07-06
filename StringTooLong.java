import java.util.*;

public class  StringTooLong {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter a string of length 6 or smaller: ");
            String str = sc.nextLine();
            sc.close();
            if (str.length() > 6) {
                throw new StringTooLongException("String length should be less than or equal to 6");
            } else {
                System.out.println(str);
            }
            
        } catch (StringTooLongException e) {
            System.out.println(e);
        }
    }
}

class StringTooLongException extends Exception {  
    public StringTooLongException(String str) {   
        super(str);  
    }  
}
