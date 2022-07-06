import java.io.*;

public class FileExist {
    public static void main(String[] args) {
        File f = new File("F:\\java\\Calculate.java");

        if (f.exists()) {
            System.out.println("Exists");
        } else {
            System.out.println("Does not Exists");
        }
    }
}
