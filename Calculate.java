public class Calculate {

    public static void main(String[] args) {
        Operations op = new Operations();
        System.out.println(op.add(1, 7));
        System.out.println(op.sub(8, 7));
    }
}

class Operations {
    public int add(int a, int b) {
        return a+b;
    }

    public int sub(int a, int b) {
        return a-b;
    }
}
