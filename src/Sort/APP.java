package Sort;

import java.util.Random;

public class APP {
	
	public static void main(String[] args) {
		Random rand = new Random();
		
		final int SIZE = 10;
		
		int[] A =new int[SIZE];
		
		for(int i = 0; i < SIZE ; i ++) {
			A[i] = rand.nextInt(SIZE);
		}
		
		InsertionSort.display(A);
		InsertionSort.sort(A);
		InsertionSort.display(A);
	}
}
