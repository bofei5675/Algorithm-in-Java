package LC792NumberSubsequences;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

class Solution {
    public int numMatchingSubseq(String S, String[] words) {
    	// use double end queue to store words with certain start
    	// character
        Map<Character,Deque<String>> dict = new HashMap<>();
        // init dictionary for all letters
        for(char i = 'a'; i <='z'; i ++){
            dict.put(i,new LinkedList<String>());
        }
        // add each word to dictionary
        for(String word:words){
            dict.get(word.charAt(0)).addLast(word);
        }
        // count the number of elements.
        int count = 0;
        for(char c: S.toCharArray()){
        	// get the queue of words.
            Deque<String> q = dict.get(c);
            
            int size = q.size();
            for(int i = 0; i < size; i ++){
            	// remove one by one to see if the one is 
            	// a word
                String word = q.removeFirst();
                // it is the subsequence if there is only one letter
                if(word.length() == 1){
                    count++;
                } else {
                	// remove the first letter
                	// then count the subsequence in parallel
                    word = word.substring(1);
                    dict.get(word.charAt(0)).addLast(word);
                }
                
            }
            
        }
        return count;
    }
}