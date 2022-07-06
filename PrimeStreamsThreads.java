import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PrimeStreamsThreads {

	public static void main(String[] args) throws InterruptedException {
		ExecutorService es = Executors.newFixedThreadPool(10);
		
		PrimeThread t1 = new PrimeThread(2, 50);
		PrimeThread t2 = new PrimeThread(51, 100);
		PrimeThread t3 = new PrimeThread(501, 1000);
		
		es.execute(t1);
		es.execute(t2);
		es.execute(t3);
		
		es.shutdown();
		es.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
		
		System.out.println("2 to 50:\t" + t1.no_prime_count);
		System.out.println("51 to 100:\t" + t2.no_prime_count);
		System.out.println("501 to 1000:\t" + t3.no_prime_count);
	}

}

class PrimeThread extends Thread {
	int start;
	int end;
	int no_prime_count;
	
	PrimeThread(int s, int d) {
		this.start = s;
		this.end = d;
	}
	
	@Override
	public void run() {
		List<Integer> list = IntStream.rangeClosed(start, end)
				.filter(x -> IntStream.rangeClosed(2, (int) (Math.sqrt(x))).allMatch(n -> x % n != 0))
				.boxed()
				.collect(Collectors.toList());
		
		this.no_prime_count = list.size();
	}
}