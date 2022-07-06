/* TASK - 6 SUM OF 1-10000 RUN IT 100 TIMES AND 
CALCULATE TIME. COMPARE IT WITH: SUM OF 1-10000 
WITH 100 THREADS AND CALCULATE TIME */

public class MultithreadSum {
    public static void main(String[] args) {
        System.out.println("Without Using Threads");
        // get the start time
        Long startx = System.currentTimeMillis();

        // program
        int ix = 1;
        while (ix <= 100) {
            rangeSum();
            ix++;
        }

        // get the end time
        Long endx = System.currentTimeMillis();

        // execution time
        Long executionx = endx - startx;
        System.out.println("Execution time: " + executionx + " ms");
        System.out.println();

        System.out.println("Using Threads");
        // get the start time
        Long starty = System.currentTimeMillis();

        RangeSumThread rst = new RangeSumThread();
        // program
        int iy = 1;
        while (iy <= 100) {
            rst.run();
            iy++;
        }

        // get the end time
        Long endy = System.currentTimeMillis();

        // execution time
        Long executiony = endy - starty;
        System.out.println("Execution time: " + executiony + " ms");
        System.out.println();
    }

    public static void rangeSum() {
        // program
        int n = 10000;
        long sum = 0, i = 1;
        while (i <= n) {
            sum += i;
            i++;
        }
        System.out.println("Sum of first " + n + " numbers: " + sum);
    }
}

class RangeSumThread extends Thread {
    public void run() {
        try {
            // program
            int n = 10000;
            long sum = 0, i = 1;
            while (i <= n) {
                sum += i;
                i++;
            }
            System.out.println("Sum of first " + n + " numbers: " + sum);
        } catch (Exception e) {
            System.out.println("Exception is caught");
        }
    }
}
