/* MAKE A CLASS VEHICLE, MAKE A CHILD CLASS CAR. 
 VEHICLE CLASS MUST HAVE METHOD BRAND, ALSO CAR CLASS 
MUST HAVE BRAND, CALL THE BRAND METHOD FORM THE OBJECT OF CHILD CLASS
*/

class Vehicle {
  public void brand() {
    System.out.println("general");
  }
}

class Car extends Vehicle {
  public void brand() {
    super.brand();
    System.out.println("nissan");
  }
}

public class VehicleExample {
  public static void main(String[] args) {
    Car gtr = new Car();
    gtr.brand();
  }
}
