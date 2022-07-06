abstract class Animal {
    abstract void makeSound();

    void eat() {
      System.out.println("I am eating...");
    }
}

class Dog extends Animal {
    public void makeSound() {
        System.out.println("Bow Bow!");
    }
}

public class InheritanceExample {
    public static void main(String[] args) {
        Dog d1 = new Dog();
        d1.makeSound();
        d1.eat();
    }
}
