package MyPeekIterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class APP {
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		
		list.add(1);
		list.add(2);
		list.add(3);
		
		Iterator<Integer> iter = list.iterator();
		
		PeekIterator piter = new PeekIterator(iter);
		
		System.out.println(piter.next());
		System.out.println(piter.peek());
	}
}
