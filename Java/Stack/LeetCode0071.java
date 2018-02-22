import java.util.Stack;

public class LeetCode0071 {
	public String simplifyPath(String path) {
		if (path == null || path.length() == 0) {
			return path;
		}

		Stack<Character> stack = new Stack<Character>();
		int pointCount = 0;

		for (int i = 0; i < path.length(); i++) {
			char c = path.charAt(i);
			
			if (c == '.') {
				pointCount++;
			}
			else if (c == '/') {

				if (pointCount == 2 && !stack.isEmpty()) {
					stack.pop();
					while (!stack.isEmpty() && stack.peek() != '/') {
						stack.pop();
					}
				}
				if(pointCount > 2) {
					for (; pointCount > 0; pointCount--)
						stack.push('.');
				}
				pointCount = 0;
				if (!stack.isEmpty() && stack.peek() == '/') {
					continue;
				}
				stack.push('/');
			} else {				
				for (; pointCount > 0; pointCount--)
					stack.push('.');
				stack.push(c);
			}
		}
		
		if(pointCount> 2) {
			for (; pointCount > 0; pointCount--)
				stack.push('.');
		}
		
		if (pointCount == 2 && !stack.isEmpty()) {
			if(stack.size() > 1) {
				stack.pop();
			}
			while (!stack.isEmpty() && stack.peek() != '/') {
				stack.pop();
			}
		}
		if (stack.size() > 1 && stack.peek() == '/')
		{
			stack.pop();
		}
		
		StringBuilder result = new StringBuilder(stack.size());

		for (int i = 0; i < stack.size(); i++) {
			result.append(stack.get(i));
		}

		return result.toString();

	}

	public static void main(String[] args) {
		LeetCode0071 leetCode = new LeetCode0071();
		System.out.println(leetCode.simplifyPath("/.."));
	}
}
