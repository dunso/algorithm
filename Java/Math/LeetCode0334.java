public class LeetCode0334 {
    public boolean increasingTriplet(int[] nums) {
        if(nums == null || nums.length < 3){
            return false;
        }
        int x = Integer.MAX_VALUE;
        int y = Integer.MAX_VALUE;
        for(int i =0; i< nums.length;i++){
            if(x >= nums[i]){
                x = nums[i];
            }else if(y >= nums[i]){
                y = nums[i];
            }else{
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        LeetCode0334 leetcode = new LeetCode0334();
        int[] nums = new int[]{5, 4, 3, 2, 1};
        System.out.println(leetcode.increasingTriplet(nums));
    }
}
