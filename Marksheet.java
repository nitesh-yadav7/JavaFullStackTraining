import java.util.*;

public class Marksheet {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[][] arr = new int[100][100];
        int studs, subs;

        System.out.println("Enter No. of Students");
        studs = sc.nextInt();

        System.out.println("Enter No. of subjects");
        subs = sc.nextInt();

        for (int i = 0; i < studs; i++) {
            System.out.println("Enter marks of student no." + (i + 1));
            for (int j = 0; j < subs; j++) {
                System.out.println("Enter marks for subject no. " + (j + 1));
                int marks = sc.nextInt();
                arr[i][j] = marks;
            }
        }

        for (int i = 0; i < studs; i++) {
            int sum = 0;
            for (int j = 0; j < subs; j++) {
                sum += arr[i][j];
            }
            System.out.println("The total marks scored by student " + (i + 1) + " is " + sum);
        }
        sc.close();
    }
}
