/* 2.Write a program that illustrates interface inheritance.
 Interface GrandParent is extended by Parent1 and Parent2.
  Interface child inherits from both Parent1 and Parent2.
   Each interface declares one method. Class Family implements child 
.Instantiate Family and invoke each of its methods. */

public class FamilyExample {
    public static void main(String[] args) {
        Family fam = new Family();
        fam.grandpa();
        fam.dad();
        fam.mom();
        fam.baby();
    }
}

interface GrandParent {
    void grandpa();
}

interface Parent1 extends GrandParent {
    void mom();
}

interface Parent2 extends GrandParent {
    void dad();
}

interface Child extends Parent1, Parent2 {
    void baby();
}

class Family implements Child {
    public void grandpa() {
        System.out.println("I am grandpa");
    }
    public void dad() {
        System.out.println("I am daddy");
    }
    public void mom() {
        System.out.println("I am mommy");
    }
    public void baby() {
        System.out.println("Baby: Bleh! Bleh!");
    }
}
