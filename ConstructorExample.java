// Online Java Compiler
// Use this editor to write, compile and run your Java code online

public class ConstructorExample {
    
    int id;
    String name;
    
    ConstructorExample(int i, String n) {
        id = i;
        name = n;
    }
    
    public void display() {
        System.out.println(id + " " + name);
    }
    
    public static void main(String[] args) {
        ConstructorExample ce = new ConstructorExample(1, "Nitesh Yadav");
        ce.display();
    }
}
