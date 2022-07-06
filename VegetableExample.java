/*The abstract vegetable class has three subclasses 
named Potato, Brinjal and
Tomato. Write a java prog. 
That demonstrates how to establish this class hierarchy.
Declare one instance variable of type String 
that indicates the color of a vegetable.
Crete and display instances of these objects. Override t */

public class VegetableExample {
    public static void main(String[] args) {
        Brinjal b = new Brinjal();
        Potato p = new Potato();
        Tomato t = new Tomato();

        System.out.println(b.color);
        b.type();
        System.out.println(p.color);
        p.type();
        System.out.println(t.color);
        t.type();
    }
}

abstract class Vegetable {
    String color;
    public void type() {
        System.out.println("I am a Vegitable!");
    }
}

class Brinjal extends Vegetable {
    Brinjal() {
        super.color = "purple";
    }
    public void type() {
        System.out.println("I am a Brinjal");
    }
}

class Potato extends Vegetable {
    Potato() {
        super.color = "skin color";
    }
    public void type() {
        System.out.println("I am a Potato");
    }
}

class Tomato extends Vegetable {
    Tomato() {
        super.color = "red";
    }
    public void type() {
        System.out.println("I am a Tomato!");
    }
}
