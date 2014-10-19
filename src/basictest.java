
import java.math.*;
public class basictest {

	public static void main(String[] args) {
		PriorityQueue<Integer> pq = new HeapPriorityQueue<Integer>();
		
		pq.add(15);
		System.out.println(pq);
		pq.add(25);
		System.out.println(pq);
		pq.add(30);
		System.out.println(pq);
		pq.add((int)Math.random());
		System.out.println(pq);
		pq.add(50);
		System.out.println(pq);
		pq.add(75);
		System.out.println(pq);
		pq.add(43);
		System.out.println(pq);
		pq.add(22);
		System.out.println(pq);
		pq.add(12);
		System.out.println(pq);
		pq.add(50);
		System.out.println(pq);
		System.out.println("this is the last one");
		pq.remove(50);
		System.out.println(pq);
	}

}
