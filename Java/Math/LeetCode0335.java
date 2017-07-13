import org.junit.Test;

public class LeetCode0335 {

	public boolean isSelfCrossing(int[] x){
		int length = x.length;
		
		if(length < 4){
			return false;
		}
		
		for(int i = 3; i< length;i++){
			if(x[i] >= x[i-2] && x[i-3] >= x[i-1]){
				return true;
			}
			if(i > 3 && x[i] + x[i-4] >= x[i-2] && x [i-1] == x[i-3]){
				return true;
			}
			if(i > 4 && x[i-1] + x[i-5] >= x[i-3] && x[i-3] >= x[i-1] 
					&& x[i] + x[i-4] >= x[i-2] && x[i-2] >= x[i-4]){
				return true;
			}
		}
		return false;
	}
	
	@Test
	public void test(){
		int [] x = {2, 1, 1, 2};
		System.out.println(isSelfCrossing(x));
	}
}
