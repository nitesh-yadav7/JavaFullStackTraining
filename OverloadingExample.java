public class OverloadingExample {
    public static void main(String[] args) {
        System.out.println(Adder.add(6, 7));
        System.out.println(Adder.add(6.5, 7.9));
        System.out.println(Adder.add(6, 2, 9));
    }
}

class Adder {
    public static int add(int a, int b) {
        return a + b;
    }

    public static double add(double a, double b) {
        return a + b;
    }

    public static int add(int a, int b, int c) {
        return a + b + c;
    }
}
