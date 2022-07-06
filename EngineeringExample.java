/* The abstract class Engineering is the super class of the Computer and Mechanical
classes. Define abstract method void display() in Engineering class. The
Programming interface declares a coding() method. The Programming interface is
implemented by the Computer class. The Drawing interface declares a draw()
method. The Drawing interface is implemented by the Mechanical class. Create
object of Child class and call its method. */

public class EngineeringExample {
    public static void main(String[] args) {
        Computer cse = new Computer();
        cse.display();
        cse.coding();

        Mechanical mech = new Mechanical();
        mech.display();
        mech.draw();
    }
}

abstract class Engineering {
    void display() {
        System.out.println("Engineering");
    }
}

interface Programming {
    void coding();
}

interface Drawing {
    void draw();
}

class Computer extends Engineering implements Programming {
    public void coding() {
        System.out.println("coding...");
    }

    void display() {
        System.out.println("Computer Engineering");
    }
}

class Mechanical extends Engineering implements Drawing {
    public void draw() {
        System.out.println("drawing...");
    }
}
