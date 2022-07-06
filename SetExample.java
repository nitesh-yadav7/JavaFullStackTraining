import java.util.*;

public class SetExample {
    public static void main(String[] args) {
        // Hashset
        HashSet<String> set = new HashSet<>();

        set.add("India");
        set.add("Australia");
        set.add("South Africa");
        set.add("Australia");
  
        System.out.println("Hashset" + set);

        // linked hashset
        LinkedHashSet<String> lset = new LinkedHashSet<>();

        lset.add("India");
        lset.add("Australia");
        lset.add("South Africa");
        lset.add("Australia");
  
        System.out.println("Linked Hashset" + lset);

        //Treeset
        TreeSet<String> tset = new TreeSet<>();

        tset.add("India");
        tset.add("Australia");
        tset.add("South Africa");
        tset.add("Australia");
  
        System.out.println("Treeset" + tset);
    }
}