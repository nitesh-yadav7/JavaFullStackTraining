import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class AnonymousClass {

	public static void main(String[] args) {
		
		System.out.println("Task 1");
		
		Polygon p = new Polygon() {
			@Override
			public void display() {
				System.out.println("I am Polygon");
			}
		};
		
		Rectangle r = new Rectangle() {
			@Override
			public void display() {
				System.out.println("I am Rectangle");
			}
		};
		
		Circle c = new Circle() {
			@Override
			public void display() {
				System.out.println("I am Circle");
			}
		};
		
		p.display();
		r.display();
		c.display();
		
		ArrayList<Integer> arr = new ArrayList<>();
		arr.add(4);
		arr.add(6);
		arr.add(2);
		arr.add(1);
		arr.add(9);
		
		Consumer<Integer> method = (n) -> System.out.println("from method: "+n);
		
		arr.forEach(method);
		
		List<String> collection = Arrays.asList("a", "b", "c");
		System.out.println(collection);
		
		System.out.println("---------------------------------");
		System.out.println("");
		System.out.println("Task 2");
		
		Operator<Integer> add = (a, b) ->  a + b;
		System.out.println("3 + 3 = " + add.calculate(3, 3));

		Operator<Integer> sub = (a, b) ->  a - b;
		System.out.println("6 - 3 = " + sub.calculate(6, 3));

		Operator<Integer> mul = (a, b) ->  a * b;
		System.out.println("3 * 3 = " + mul.calculate(3, 3));
		
		Operator<Integer> div = (a, b) ->  a / b;
		System.out.println("18 / 3 = " + div.calculate(18, 3));
		
		System.out.println("---------------------------------");
		System.out.println("");
		System.out.println("Task 3");
		
		List<Integer> list1 = IntStream.rangeClosed(1, 1000).boxed().toList();
		System.out.println(list1);
		
		List<Integer> listp = IntStream.rangeClosed(2, 100).boxed().toList();
		listp.stream().forEach(x -> {
			boolean isPrime = IntStream.rangeClosed(2, (int) (Math.sqrt(x)))
									.allMatch((n) -> x % n != 0);
			if (isPrime) {
				System.out.print(x + ", ");
			}
		});
		
		System.out.println();
		System.out.println("---------------------------------");
		System.out.println("");
		System.out.println("Task 4");
		
		List<Integer> list3 = IntStream.rangeClosed(1, 1000).boxed().toList();
		System.out.println(list3);
		
		List<Integer> list4 = IntStream.rangeClosed(2, 100)
				.filter(x -> IntStream.rangeClosed(2, (int) (Math.sqrt(x))).allMatch(n -> x % n != 0))
				.boxed()
				.collect(Collectors.toList());
		System.out.println(list4);
		
		System.out.println("---------------------------------");
		System.out.println("");
		System.out.println("Task 5");
		
		List<String> strArr = Arrays.asList("fredo", "vito", "michael", "tom", "santino");
		System.out.println(strArr.stream().map((x) -> x + "_birlasoft").collect(Collectors.toList()));
		
	}

}

interface Polygon {
   public void display();
}

interface Rectangle {
	public void display();
}

abstract class Circle {
	abstract void display();
}

@FunctionalInterface
interface Operator<T> {
    T calculate(T a, T b);
}

@FunctionalInterface
interface isPrime<T> {
	T process(T x);
}
