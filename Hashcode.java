/* Task 4 - make a hascode of a sentence in java */

import java.util.Scanner;

public class Hashcode {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Sentence: ");
        String sentence = sc.nextLine();
        System.out.println("Hash: " + sentence.hashCode());
        sc.close();
    }
}
