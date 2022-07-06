import java.io.*;

public class ListAllFiles {
	public static void main(String args[]) {
		try {
			File f = new File("F:\\newFolder");
			String[] files = f.list();

            if (f.exists()) {
                System.out.println("Exists");
                System.out.println("Files are:");

			    // Display the names of the files
			    for (int i = 0; i < files.length; i++) {
				    System.out.println(files[i]);
			    }
            } else {
                System.out.println("Does not Exists");
            }
		}
		catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}
}
