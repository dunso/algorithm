public class LeetCode0018 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        final List<List<Integer>> res = new ArrayList<>();
        final int len;
        
        if (nums == null || (len = nums.length) < 4) {
            return res;
        }
        
        Arrays.sort(nums);
        
        if ((nums[0] << 2) > target || (nums[len - 1] << 2) < target) {
            return res;
        }
        
        final int max3x = nums[len - 1] * 3;
        
        for (int i = 0, end = len - 3; i < end; ++i) {
            final int cur = nums[i];
            int tmp;
            
            if (cur + max3x < target) {
                continue;
            } else if ((tmp = cur << 2) > target) {
                break;
            } else if (tmp == target && nums[i + 3] == cur) {
                res.add(Arrays.asList(cur, cur, cur, cur));
            } else {
                threeSum(nums, len, i + 1, target - cur, res, cur);
            }
            
            while (i < end && nums[i] == nums[i + 1]) {
                ++i;
            }
        }
        
        return res;
    }
    
    private void threeSum(int[] nums, int len, int start, int target, List<List<Integer>> res, int first) {
        if (nums[start] * 3 > target) {
            return;
        }
        
        final int max2x = nums[len - 1] << 1;
        
        for (int i = start, end = len - 2; i < end; ++i) {
            final int cur = nums[i];
            int tmp;
            
            if (cur + max2x < target) {
                continue;
            } else if ((tmp = cur * 3) > target) {
                break;
            } else if (tmp == target && nums[i + 2] == cur) {
                res.add(Arrays.asList(first, cur, cur, cur));
            } else {
                twoSum(nums, len, i + 1, target - cur, res, first, cur);
            }
            
            while (i < end && nums[i] == nums[i + 1]) {
                ++i;
            }
        }
    }
    
    private void twoSum(int[] nums, int len, int start, int target, List<List<Integer>> res, int first, int second) {
        if ((nums[start] << 1) > target) {
            return;
        }
        
        int end = len - 1;
        
        while (start < end) {
            final int cur = nums[start] + nums[end];
            
            if (cur > target) {
                --end;
            } else if (cur < target) {
                ++start;
            } else {
                res.add(Arrays.asList(first, second, nums[start], nums[end]));
                
                while (++start < end && nums[start] == nums[start - 1]);
                while (start < --end && nums[end] == nums[end + 1]);
            }
        }
    }
}
