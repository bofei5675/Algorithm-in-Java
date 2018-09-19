package Backtracking;

import java.util.ArrayList;
import java.util.List;

public class ScheduleFinder {
	public ScheduleFinder() {
		
	}
	/**
	 * Find the schedules based on the given hours 
	 * Question from Pe***
	 * @param input
	 * @param hours
	 * @return
	 */
	public static List<List<Integer>> findSchedules(String input,int hours) {
		char[] hs = input.toCharArray();
		System.out.println("Start function");
		int sum = 0;
		int count = 0;
		for(char h: hs) {
			if(h != '?') {
				sum += Character.getNumericValue(h);
		//		System.out.println(h);
		//		System.out.println(sum);


			} else {
				count++;
			}
		}
		//System.out.println(sum);
		//System.out.println(count);


		int reminder = hours - sum;
		System.out.println(reminder);
		// then try backtracking 
		
		List<List<Integer>> ls = new ArrayList<>();
		
		backtracking(ls,new ArrayList<Integer>(),hs,reminder,count);
		
		// System.out.println("Start function");
		
		System.out.println(ls);
		
		while(!ls.isEmpty()) {
			List<Integer> sche = ls.remove(0);
			StringBuilder sb = new StringBuilder();
			
			for(int i = 0; i < hs.length; i ++) {
				if(hs[i] != '?') {
					sb.append(hs[i]);
				} else {
					sb.append(sche.remove(0));
				}
			}
			System.out.println(sb.toString());
			
		}
		return ls;
	}
	
	private static void backtracking(List<List<Integer>> ls, List<Integer> temp
			, char[] hs, int reminder,int count) {
		if(temp.size() == count && reminder == 0) {
			
			ls.add(new ArrayList<Integer>(temp));
			return;
		} else if (temp.size() == count && reminder != 0) {
			return;
		}
		
		for(int i = 0; i <= reminder; i ++) {
			System.out.println(i);
			temp.add(i);
			System.out.println(temp);
			backtracking(ls,temp,hs,reminder - i,count);
			temp.remove(temp.size() - 1);
		}
		
		
	}
}
