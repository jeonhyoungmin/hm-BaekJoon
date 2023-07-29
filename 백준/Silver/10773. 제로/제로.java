import java.util.Scanner;
import java.util.Stack;

public class Main {

	public static void main(String[] args) {
		
		// K 1~100,000
		// 주어진 값 1~1,000,000
		
		Scanner sc = new Scanner(System.in);
		
		int K = sc.nextInt();
		Stack<Integer> stack = new Stack<>();
		
		int data = 0;
		while(K-- > 0) {
			data = sc.nextInt();
			if(data == 0) {
				stack.pop();
				continue;
			}
			stack.push(data);
		}
		
		int ans = 0;
		while(stack.size() != 0) {
			ans += stack.pop();
		}
		System.out.println(ans);

	}

}
