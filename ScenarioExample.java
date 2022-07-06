package birlasoft;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class ScenarioExample {

	public static void main(String[] args) throws IOException {
		
		CreateFile file = new CreateFile();
        file.createNewFile();
        
        Path fileName = Path.of("F:\\test\\result.txt");
        String str = Files.readString(fileName);
        String[] arr = str.split(" ");
        ArrayList<String> list = new ArrayList<String>(Arrays.asList(arr));
        System.out.println("arraylist: " + list);
	}
}

class CreateFile {
    public void createNewFile() {
        try {
            File myObj = new File("F:\\test\\result.txt");
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
        
                // get input from user
                Scanner sc = new Scanner(System.in);
                System.out.println("Enter a string");
                String generatedString = sc.nextLine();
                sc.close();
        
                // write to file
                FileWriter myWriter = new FileWriter("F:\\test\\result.txt");
                myWriter.write(generatedString);
                myWriter.close();
                System.out.println("Successfully wrote to the file.");
            } else {
                System.out.println("File already exists.");
            }
        } catch (Exception e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
