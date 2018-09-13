package Sort;

public class MergeSort {
	public static void mergeSort(int [] A) {
		int start = 0;
		int end = A.length - 1;
		int m = start + (end - start) / 2;
		
		mergeSort(A,start,m);
		mergeSort(A,m + 1, end);
		merge(A,start,m,end);
		
	}
	
	private static void mergeSort(int[] A, int start, int end) {
		if(start < end) {
			int mid = start + (end - start) / 2;
			
			mergeSort(A,start,mid);
			mergeSort(A,mid + 1,end);
			merge(A,start,mid,end);
		}
	}
	
	private static void merge(int[] A,int start,int mid, int end) {
		int[] temp = new int[end - start + 1];
		int i = start;
		int j = mid + 1;
		
		// System.out.println(i);
		// System.out.println(j);
		for(int k = 0; k < temp.length; k ++) {
			// out of place to fill in Array
			if((j > end)|| (i <= mid && A[i] <= A[j])) {
				temp[k] = A[i];
				i ++;
			} else if(j <= end ) {
				temp[k] = A[j];
				j++;
			}
		}
		// we have sorted array in temp;
		for(int k = 0;k< temp.length; k++ ) {
			A[start + k] = temp[k]; 
		}
		
	}
}
