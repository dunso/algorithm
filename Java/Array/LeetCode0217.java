public class LeetCode217 {
    public boolean containsDuplicate(int[] nums) {

        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;
        for(int b: nums){
            if(b<min){
                min=b;
            }
            if(b>max){
                max=b;
            }
        }

        boolean record[] = new boolean[max-min+1];

        for(int num : nums){
            if(record[num-min]){
                return true;
            }else{
                record[num - min] = true;
            }
        }

        return false;
    }
}
