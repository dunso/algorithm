import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.Test;

public class LeetCode0336 {
	
	public static class Trie{
		int index;
		List<Integer> list;
		Trie[] next;
		
		public Trie(){
			index = -1;
			list = new ArrayList<Integer>();
			next = new Trie[26];
		}
	}

	public List<List<Integer>> palindromePairs(String[] words) {
		
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		
		if(words == null || words.length == 0){
	        return res;
	    }
		
		Trie root = new Trie();
		
        for(int i = 0; i< words.length; i++){
        	trieAdd(root, words[i], i);
        }
        
        for(int i = 0; i< words.length; i++){
        	trieSearch(root, words, i, res);
        }
        return res;
    }
	
	private void trieAdd(Trie node, String word, int index){
		
		for(int i = word.length() - 1; i>=0; i --){
			int pos = word.charAt(i)- 'a';
			
			if(node.next[pos] == null){
				node.next[pos] = new Trie();
			}
			
			if(isPalindrome(word, 0, i)){
				node.list.add(index);
			}
			node = node.next[pos];
		}
		
		node.index = index;
		node.list.add(index);
	}
	
	private void trieSearch(Trie node, String[] words, int i, List<List<Integer>> res){
		
		for(int j = 0; j< words[i].length(); j++){
			
			if(node.index >= 0 && i != node.index && isPalindrome(words[i], j, words[i].length() -1)){
				res.add(Arrays.asList(i, node.index));
			}
			node = node.next[words[i].charAt(j) - 'a'];
			if(node == null){
				return;
			}
		}
		
		for(int j : node.list){
			if(i != j){
				res.add(Arrays.asList(i, j));
			}
		}
	}
	
	public boolean isPalindrome(String word, int start,int end){
		while(start <= end && word.charAt(start) == word.charAt(end)){
			start ++;
			end --;
		}
		return start > end;
	}
	
	@Test
	public void test(){
		String[] words = {
				"a", "abc", "ab"
		};
		System.out.println(palindromePairs(words));
	}
}
