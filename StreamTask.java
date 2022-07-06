import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamTask {

	public static void main(String[] args) {
		List<Integer> allno = IntStream.rangeClosed(1, 100).boxed().toList();
		allno.stream().forEach(x -> {
			if (x % 17 == 0) {
				System.out.print(x + ", ");
			}
		});
		System.out.println();
		
		List<Integer> allnums = IntStream.rangeClosed(1, 100).boxed().toList();
		List<Integer> DivisibleBy17 = allnums.stream()
				.filter(x -> x % 17 == 0)
				.collect(Collectors.toList());
		
		System.out.println(DivisibleBy17);
		
		List<Integer> list100 = IntStream.rangeClosed(1, 100).boxed().toList();
		List<Integer> DivisibleBy7 = list100.stream()
				.filter(x -> x % 7 == 0)
				.map(x -> x*x)
				.collect(Collectors.toList());
		
		System.out.println(DivisibleBy7);
	}
	
}
