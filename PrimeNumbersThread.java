/* Find all the prime numbers form 1 to 100000 with the help of10 threads */
public class PrimeNumbersThread {
    public static void main(String[] args) {
        int sum = 0;
        for (int i = 1; i <= 10; i++) {
            new MyThread((sum + 1), sum + 10000, i).start();
            sum += 10000;
        }
    }
}

class Prime {
    public void calculate(int s, int e, int name) {
        for (int i = s; i <= e; i++) {
            if (checkPrime(i)) {
                System.out.println("From thread: " + name + ": " + i);
            }
        }
    }
    private static boolean checkPrime(int n) {
        for (int i = 2; i < n; i++) {
            if (n % i == 0 && n != 1) {
                return false;
            }
        }
        return true;
    }
}
class MyThread extends Thread {
    int start;
    int end;
    int id;
    MyThread(int s, int e, int id) {
        this.start = s;
        this.end = e;
        this.id = id;
    }
    public void run() {
        Prime p = new Prime();
        p.calculate(start, end, id);
    }
}
