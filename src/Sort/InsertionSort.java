package Sort;
/**
 * 
 * @author bofeizhang
 * Implement insertion sort
 * 
 */
public class InsertionSort {
	/**
	 * Insertion sort 
	 * @param A
	 */
	public static void sort(int[] A) {
		
		int len = A.length;
		int i = 0;
		
		for(int j = 1; j < len; j ++) {
			// System.out.println(j);
			int key = A[j];
			i = j - 1;
			while( i >= 0 && A[i] > key) {
				A[i + 1] = A[i];
				i--;
			}
			
			A[i + 1] = key; // do the insertion
		}
		
		
	}
	public static void display(int[] A) {
		StringBuilder sb = new StringBuilder();
		
		for(int i : A) {
			sb.append(i + " ");
		}
		
		System.out.println(sb.toString());
	}
}
