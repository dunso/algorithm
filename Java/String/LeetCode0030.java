import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

public class LeetCode0030 {

	public List<Integer> findSubstring(String s, String[] words){
		
		List<Integer> result = new ArrayList<Integer>();
		
		int wordLength, wordsLength, sLength = s.length();
		
		if (sLength == 0 || (wordLength = words[0].length()) == 0 || (wordsLength = wordLength * words.length) == 0 ){
			return result;
		}
		
		Map<String, Integer> wordMap = new HashMap<String, Integer>();
		
		for(String word : words){
			wordMap.put(word, wordMap.containsKey(word) ? wordMap.get(word) + 1 :  1);
		}
			
		for(int i = 0; i< wordLength; i++){
			
			Map<String, Integer> map = new HashMap<String, Integer>();
			
			for(int j = i, start = i; j + wordLength <= sLength && start + wordsLength <= sLength; j+= wordLength){
				
				String str = s.substring(j, j + wordLength);
				
				if(!wordMap.containsKey(str)){
					map.clear(); 
					start = j + wordLength; 
					continue;
				}
				
				map.put(str, map.containsKey(str) ? map.get(str) + 1 : 1);
				
				if(map.get(str) == wordMap.get(str)){
					start = judge(start, j, wordLength, wordsLength,s, map, result);
				}else if(map.get(str) > wordMap.get(str)){
					start = skipFirstWordAfterStart(start, wordLength,wordsLength, s, map, str);
				}
			}
		}
		return result;
	}
	
	private int judge(int start, int j, int wordLength,  int wordsLength, String s, Map<String, Integer> map, List<Integer> result){
		if(start + wordsLength == j + wordLength){
			result.add(start);
			start = skipFirstWordAfterStart(start, wordLength, wordsLength, s, map, s.substring(start,start + wordLength));
		}
		return start;
	}
	
	private int skipFirstWordAfterStart(int start, int wordLength, int wordsLength, String s, Map<String, Integer> map, String toBeRemove){
		String tmp = null;
		while(start + wordsLength <= s.length() && !toBeRemove.equals(tmp = s.substring(start, start + wordLength))){
			map.put(tmp, map.get(tmp) - 1);
			start += wordLength;
		}
		if(start + wordsLength <= s.length()){
			map.put(toBeRemove, map.get(toBeRemove) - 1);
		}
		return start + wordLength;
	}
	
	@Test
	public void test(){
		String s = "barfoothefoobarman";
		String[] words = {"foo","bar"};
		List<Integer> results = findSubstring(s, words);
		for(int result : results){
			System.out.println(result);
		}
	}
}