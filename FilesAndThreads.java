import java.io.File;
import java.io.FileWriter;
import java.util.Random;

public class FilesAndThreads {

	public static void main(String[] args) {
		createFilesWithLoop();
		createFilesWithThreads("xa", 2);
		createFilesWithThreads("xb", 4);
		createFilesWithThreads("xc", 6);
		createFilesWithThreads("xd", 10);
		createFilesWithThreads("xe", 20);
		createFilesWithThreads("xf", 50);
		createFilesWithThreads("xg", 100);
	}
	
	public static void createFilesWithLoop() {
		// start execution
		Long start = System.currentTimeMillis();
		
		int i = 1;
		while (i <= 1000) {
			createFile("loopfile", i);
			i++;
		}

        // execution time
		Long end = System.currentTimeMillis();
        Long execution = end - start;
        System.out.println("Loop Execution time: " + execution + " ms");
        System.out.println();
	}
	
	public static void createFilesWithThreads(String fileName, int totalThreads) {
		// start execution
		Long starty = System.currentTimeMillis();
				
		int thread = 1;
		int startx = 1;
		int endx = 1000 / totalThreads;
		int incrementor = endx;
		while (thread <= totalThreads) {
			FilesWithThreads ft = new FilesWithThreads(fileName, startx, endx);
			ft.start();
			startx += incrementor;
			endx += incrementor;
			thread++;
		}
		
		// execution time
		Long endy = System.currentTimeMillis();
		Long executiony = endy - starty;
		System.out.println(totalThreads + " Threads Execution time: " + executiony + " ms");
		System.out.println();
	}
	
	public static void createFile(String name, int n) {
		try {
            File myObj = new File("F:\\test\\" + name + n + ".txt");
            if (myObj.createNewFile()) {
                //System.out.println("File created: " + myObj.getName());
        
            	// generate random string
                int lowerLimit = 97;
                int upperLimit = 122;
                Random random = new Random();
                StringBuffer r = new StringBuffer(100);

                for (int i = 0; i < 100; i++) {
                    int nextRandomChar = lowerLimit + (int)(random.nextFloat() * (upperLimit - lowerLimit + 1));
                    // append a character at the end of string
                    r.append((char)nextRandomChar);
                }
                String generatedString = r.toString();
        
                // write to file
                FileWriter myWriter = new FileWriter("F:\\test\\" + name + n + ".txt");
                myWriter.write(generatedString);
                myWriter.close();
                //System.out.println("Successfully wrote to the file.");
            } else {
                System.out.println("File already exists.");
            }
        } catch (Exception e) {
            //System.out.println("An error occurred.");
            e.printStackTrace();
        }
	}
	
}

class FilesWithThreads extends Thread {	
	String filename;
	int start;
	int end;
	
	FilesWithThreads(String name, int i, int j) {
		this.filename = name;
		this.start = i;
		this.end = j;
	}
	
	public void run() {
		int n = start;
		while (n <= end) {
			FilesAndThreads.createFile(filename, n);
			n++;
		}
		
	}
}
