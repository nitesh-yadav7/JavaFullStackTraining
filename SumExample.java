public class SumExample {
    
    public static void main(String[] args) {
        System.out.println("10^1");
        System.out.println("Using For loop");
        rangeSumFor(10);
        System.out.println("Using While loop");
        rangeSumWhile(10);
        System.out.println("Using Arithmetic Progression");
        seriesSum(10);
        
    }
    
    public static void rangeSumFor(long n) {
        // get the start time
        Long start = System.currentTimeMillis();

        // program
        long sum = 0;
        for (long i = 1; i <= n; i++) {
            sum += i;
        }

        System.out.println("Sum of first " + n + " numbers: " + sum);

        // get the end time
        Long end = System.currentTimeMillis();

        // execution time
        Long execution = end - start;
        System.out.println("Execution time: " + execution + " ms");
        System.out.println();
    }

    public static void rangeSumWhile(long n) {
        // get the start time
        Long start = System.currentTimeMillis();

        // program
        long sum = 0, i = 1;
        while (i <= n) {
            sum += i;
            i++;
        }
        
        System.out.println("Sum of first " + n + " numbers: " + sum);

        // get the end time
        Long end = System.currentTimeMillis();

        // execution time
        Long execution = end - start;
        System.out.println("Execution time: " + execution + " ms");
        System.out.println();
    }

    public static void seriesSum(long n) {
        Long start = System.currentTimeMillis();

        // program
        long Sn = (n/2) * (1 + n);
        System.out.println("Sum of first " + n + " numbers: " + Sn);

        Long end = System.currentTimeMillis();

        // execution time
        System.out.println("Execution time: " + (end - start) + " ms");
        System.out.println();
    }
}
