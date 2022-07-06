/*
 * 4. The Transport interface declares a deliver () method. 
 * The abstract class Animal is the super class of the Tiger,
 *  Camel, Deer and Donkey classes. The Transport 
 * interface is implemented by the Camel and Donkey classes.
 *  Write a test program that initialize an array of four 
 * Animal objects. If the object implements the Transport 
 * interface, the deliver () method is invoked.
 */

public class TransportExample {
    public static void main(String[] args) {
        Animal[] animals = new Animal[] { new Tiger(), new Camel(), new Donkey(), new Deer() };

        for(Animal a : animals) {
            System.out.println(a);
            if (a instanceof Transport) {
                ((Transport) a).deliver();
            }
        }
    }
}

interface Transport {
    void deliver();
}

abstract class Animal {
    public String name;
}

class Tiger extends Animal {
    String name;
    Tiger() {
        this.name = "Tiger";
    }
}

class Camel extends Animal implements Transport {
    String name;
    Camel() {
        this.name = "Camel";
    }

    public void deliver() {
        System.out.println("Camel delivers people");
    }
}

class Donkey extends Animal implements Transport {
    String name;
    Donkey() {
        this.name = "Donkey";
    }

    public void deliver() {
        System.out.println("Donkey delivers load");
    }
}

class Deer extends Animal {
    String name;
    Deer() {
        this.name = "Deer";
    }
}

