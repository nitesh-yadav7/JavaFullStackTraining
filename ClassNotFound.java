public class ClassNotFound {  
    public static void main(String[]  args) throws Exception {
        System.out.println("Loading some class");
        Class.forName("SomeClass");
    }
}
