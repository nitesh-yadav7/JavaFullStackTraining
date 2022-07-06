public class MultithreadExample {
    public static void main(String[] args) {
        OddThread odd = new OddThread();
        EvenThread even = new EvenThread();
        odd.start();
        even.start();
    }
}

class EvenThread extends Thread {
    public void run() {
        try {
            int i = 2;
            System.out.println("Thread even is running");
            while (i <= 1000) {
                System.out.println(i);
                i += 2;
            }
            System.out.println("Thread even completed its execution");
        } catch (Exception e) {
            System.out.println("Exception is caught");
        }
    }
}

class OddThread extends Thread {
    public void run() {
        try {
            int i = 1;
            System.out.println("Thread odd is running");
            while (i <= 1000) {
                System.out.println(i);
                i += 2;
            }
            System.out.println("Thread odd completed its execution");
        } catch (Exception e) {
            System.out.println("Exception is caught");
        }
    }
}
