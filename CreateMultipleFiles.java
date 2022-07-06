/*
task 6b -  make 1000 .txt file files in your folder 1st with 
sequence and diplay time for creating all the files, then 
create it with threading and siplay the time needed.
 */

import java.io.*;
import java.util.*;

public class CreateMultipleFiles {
    public static void main(String[] args) {
        FileThread ft = new FileThread();
        ft.start();
        FileSequential fs = new FileSequential();
        fs.createFiles();
    }
}

class FileSequential {
    public void createFiles() {
        Long start = System.currentTimeMillis();
        try {
            int n = 1;
            while (n <= 1000) {
                File myObj = new File("D:\\JAVA Full Stack\\JAVA\\testx\\result" + n + ".txt");
                if (myObj.createNewFile()) {
                    //System.out.println("File created: " + myObj.getName());
        
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
                    FileWriter myWriter = new FileWriter("D:\\JAVA Full Stack\\JAVA\\testx\\result" + n + ".txt");
                    myWriter.write(generatedString);
                    myWriter.close();
                    //System.out.println("Successfully wrote to the file.");
                } else {
                    System.out.println("File already exists.");
                }
                n++;
            }
        } catch (Exception e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        Long end = System.currentTimeMillis();

        // execution time
        Long execution = end - start;
        System.out.println("Sequential Execution time: " + execution + " ms");
        System.out.println();
    }
}

class FileThread extends Thread {
    public void run() {
        Long start = System.currentTimeMillis();
        try {
            int n = 1;
            while (n <= 1000) {
                File myObj = new File("D:\\JAVA Full Stack\\JAVA\\testy\\result" + n + ".txt");
                if (myObj.createNewFile()) {
                    //System.out.println("File created: " + myObj.getName());
        
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
                    FileWriter myWriter = new FileWriter("D:\\JAVA Full Stack\\JAVA\\testy\\result" + n + ".txt");
                    myWriter.write(generatedString);
                    myWriter.close();
                    //System.out.println("Successfully wrote to the file.");
                } else {
                    System.out.println("File already exists.");
                }
                n++;
            }
        } catch (Exception e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        Long end = System.currentTimeMillis();

        // execution time
        Long execution = end - start;
        System.out.println("Thread Execution time: " + execution + " ms");
        System.out.println();
    }
}
