import java.io.*;

public class FileOutput {
    public static void main(String[] args) {
        try {
            FileOutputStream fout = new FileOutputStream("F:\\testout.txt");
            String s = "This is a output text";
            byte[] b = s.getBytes();
            fout.write(b);
            // fout.write(65);
            fout.close();
            System.out.println("Success!");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
