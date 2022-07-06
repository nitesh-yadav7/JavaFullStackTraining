import java.util.ArrayList;
import java.util.List;

/* Find all the prime numbers form 1 to 100000 with the help of10 threads */

public class PrimeNumbers {
    public static void main(String[] args) {
        // for calculation
        int[] nums = new int[100001];
        // for storing prime numbers;
        List<Integer> primeNumbers = new ArrayList<Integer>(); 
        
        // base case
        nums[2] = 1;
        primeNumbers.add(2);

        for (int i=2; i <= 100000; i++) {
            if (nums[i] == 0) {
                primeNumbers.add(i);
                int j = i;
                while (j < 100001) {
                    nums[j] = 1;
                    j += i;
                }
            }
        }

        System.out.println(primeNumbers);
    }
}
