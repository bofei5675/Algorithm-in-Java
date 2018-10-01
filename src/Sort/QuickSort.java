package Sort;
/**
 * Implementation of quick sort
 * @author bofeizhang
 */
public class QuickSort {
	public static void sort(int[] A,int start, int end ) {
		if(start < end) {
			System.out.println(A[end]);
			int mid = partition(A,start,end);
			
			display(A);
			sort(A,start ,mid - 1);
			sort(A, mid + 1, end);
		}
	}
	private static void display(int [] A) {
		for(int i = 0; i < A.length ; i ++) {
			System.out.print(A[i] + " ");
		}
		System.out.println("");
	}
	/**
	 * Partition the array into two parts where the smaller element is on
	 * the left, and larger element is on the right.
	 * @param A
	 * @param start
	 * @param end
	 * @return
	 */
	public static int partition(int[] A, int start, int end) {
		int target = A[end];
		int loc = start - 1;
		for(int i = start; i < end; i ++) {
			if(A[i] <= target) {
				// check each element, if smaller than the target
				// increment the loc and switch element
				loc++;
				swap(A, loc, i);
			}
		}
		// put the target into the array
		// all elements on the left would be smaller
		// all elements on the right would be larger.
		swap(A,loc + 1,end);
		
		return loc + 1;
	}
	/**
	 * Swap the element in position i and j.
	 * @param A
	 * @param i
	 * @param j
	 */
	private static void swap(int[] A, int i,int j) {
		int temp = A[i];
		
		A[i] = A[j];
		A[j] = temp;
	}
}
