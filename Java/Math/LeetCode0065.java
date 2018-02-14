
public class LeetCode0065 {
	
	public boolean isNumber(String s) {
		if (s == null) {
			return false;
		}

		s = s.trim();
		
		if (s.length() == 0) {
			return false;
		}
		
		s = removeSign(s);
		
		if (s.length() == 0) {
			return false;
		}
		
		if(s.length() == 1 && !Character.isDigit(s.charAt(0))) {
			return false;
		}
		
		if(s.contains("e")) {
			return handleE(s);
		}
		
		return handlePoint(s);
	}
	
	private String removeSign(String s) {
		if(s.charAt(0) == '+' || s.charAt(0) == '-') {
			s = s.substring(1, s.length());
		}
		return s;
	}
	
	
	private boolean handlePoint(String s) {
		for(int i = 0; i< s.length(); i++) {
			char c = s.charAt(i);
			if(!Character.isDigit(c) && c != '.') {
				return false;
			}
		}
		
		int pIndex = s.indexOf('.');
		if(pIndex == -1) {
			return true;
		}
		
		if(s.lastIndexOf('.') != pIndex) {
			return false;
		}
		
		if(pIndex == 0 || pIndex == s.length() -1) {
			if(s.length() == 1) {
				return false;
			}
		}
		return true;
	}
	
	private boolean handleE(String s) {
		
		int eIndex = s.indexOf('e');
		if(s.lastIndexOf('e') != eIndex) {
			return false;
		}
		
		String base = s.substring(0, eIndex);
		String power = s.substring(eIndex + 1, s.length());
		
		if(base.length() == 0) {
			return false;
		}
		
		if(power.length() == 0) {
			return false;
		}
		
		power = removeSign(power);
		
		if(power.length() == 0) {
			return false;
		}
		
		for(int i = 0; i< power.length();i++) {
			if(!Character.isDigit(power.charAt(i))) {
				return false;
			}
		}
		
		return handlePoint(base);	
	}

	public static void main(String[] args) {
		LeetCode0065 leetcode = new LeetCode0065();
		System.out.println(leetcode.isNumber("2e0"));
	}
}
