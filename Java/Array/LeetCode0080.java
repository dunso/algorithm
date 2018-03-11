public class LeetCode0080 {
	public int removeDuplicates(int[] nums) {
        if(nums == null || nums.length == 0) {
        	return 0;
        }
        int pre = 0;
        int count = 1;
        for(int i = 1; i< nums.length; i++) {
        	if(nums[i] == nums[pre]) {
        		if(count >= 2) {
        			continue;
        		}else {
        			count ++;
        		}
        	}else {
        		count = 1;
        	}
        	nums[++ pre] = nums[i]; 
        }
        return pre + 1;
    }
	
	public static void main(String[] args) {
		LeetCode0080 leetcode = new LeetCode0080();
		System.out.println(leetcode.removeDuplicates(new int[] {1,1,1,2,2,3}));
	}
}