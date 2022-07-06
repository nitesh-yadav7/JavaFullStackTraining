/* Task 6a - make a .txt file with random 100 character input  */

import java.io.*;
import java.util.*;

public class CreateFile {
    public static void main(String[] args) {
        try {
            File myObj = new File("D:\\JAVA Full Stack\\JAVA\\test\\result.txt");
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
        
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
        
                // write to file
                FileWriter myWriter = new FileWriter("D:\\JAVA Full Stack\\JAVA\\test\\result.txt");
                myWriter.write(generatedString);
                myWriter.close();
                System.out.println("Successfully wrote to the file.");
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
