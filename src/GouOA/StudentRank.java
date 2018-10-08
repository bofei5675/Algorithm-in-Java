package GouOA;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Random;

public class StudentRank {
	/**
	 * Give an array of student height, put them in order into another array.
	 * For each input, make sure the height is the smallest number, otherwise 
	 * you will need recreate an array.
	 * 
	 * 
	 * Idea of patience sort 
	 */
	
	public static PriorityQueue<Integer> getNewList(){
		return new PriorityQueue<Integer>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				if(o1 > o2) {
					return 1;
				} else if (o1 < o2) {
					return -1;
				} else {
					return 0;
				}
			}
		});
	}
	public static int solution(int[] height) {
		
		List<PriorityQueue<Integer>> res = new ArrayList<>();
		
		PriorityQueue<Integer> rank = getNewList();
		rank.add(height[0]);
		res.add(rank);
		int loc = 0;
		for(int i = 1; i < height.length; i ++) {
			boolean found = false;
			for(PriorityQueue<Integer> temp: res) {
				if(height[i] < temp.peek()) {
					temp.add(height[i]);
					found = true;
					break;
				}
			}
			if(!found) {
				res.add(getNewList());
				res.get(res.size() - 1).add(height[i]);
			}
		}
		System.out.println(res);
		return res.size();
	}
	
	public static void main(String[] args) {
		Random rand = new Random();
		int CONSTANT = 10;
		int[] A = new int[CONSTANT];
		for(int i = 0; i < A.length; i ++) {
			A[i] = rand.nextInt(CONSTANT);
			System.out.print(A[i]);
			System.out.print(",");
		}
		System.out.println("");
		solution(A);
	}
}
