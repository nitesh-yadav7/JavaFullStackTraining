import java.util.*;

public class RandomStringGenerator {
    public static void main(String[] args) {
        // generate random string
        int lowerLimit = 97;
        int upperLimit = 122;
        Random random = new Random();
        StringBuffer r = new StringBuffer(100);

        for (int i = 0; i < 100; i++) {
            int nextRandomChar = lowerLimit + (int)(random.nextFloat() * (upperLimit - lowerLimit + 1));
            // append a character at the end of bs
            r.append((char)nextRandomChar);
        }

        String generatedString = r.toString();
        System.out.println(generatedString);
    }
}
