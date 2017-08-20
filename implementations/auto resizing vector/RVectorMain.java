import java.util.*;

public class RVectorMain {
	public static void main(String[] args) throws Exception{
		RVector<Integer> vector = new RVector<>();
		System.out.println(vector.size()); // should print 0
		for(int i = 0; i < 10; ++i) {
			vector.add(i); 
		}

		System.out.println(vector.size()); // should print 10 

		// Array will get resized
		for(int i = 19; i >= 10; --i) {
			vector.add(i); 
		}

		System.out.println(vector.size()); // should print 20 
		System.out.println(vector.get(10)); // should print 19

		vector.removeAtIndex(10);
		System.out.println(vector.size()); // should print 19
		System.out.println(vector.isEmpty()); // should print false
		System.out.println(vector.get(10)); // should print 18

		vector.remove(5);
		System.out.println(vector.size()); // should print 18
		System.out.println(vector.get(5)); // should print 6
		System.out.println(vector.get(10)); // should print 17
		vector.clear();
		System.out.println(vector.size()); // should print 0
		System.out.println(vector.isEmpty());// should print true
	}s
}