public class SleepThreadExample {
    public static void main(String[] args) {
        SleeperThread st = new SleeperThread();
        NonSleeperThread nst = new NonSleeperThread();
        st.start();
        nst.start();
    }
}

class SleeperThread extends Thread {
    public void run() {
        try {
            int i = 1;
            while(i <= 10) {
                System.out.println("Sleeper Thread: "+i);
                Thread.sleep(500);
                i++;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

class NonSleeperThread extends Thread {
    public void run() {
        try {
            int i = 1;
            while(i <= 10) {
                System.out.println("NonSleeper Thread: "+i);
                i++;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}