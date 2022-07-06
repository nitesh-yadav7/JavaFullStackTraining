import java.nio.file.*;
import java.nio.file.attribute.*;
import java.util.Scanner;

public class ListAttributes {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the file path: ");
		String s = sc.next();

		Path path = FileSystems.getDefault().getPath(s);

		BasicFileAttributeView view = Files.getFileAttributeView(path, BasicFileAttributeView.class);
		BasicFileAttributes attributes = view.readAttributes();

		System.out.println(attributes);
		sc.close();
	}
}
