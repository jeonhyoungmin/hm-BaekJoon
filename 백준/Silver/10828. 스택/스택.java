import java.util.Scanner;
import java.util.Stack;

public class Main {

	private static Stack<Integer> stack = new Stack<>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {

			String c = sc.next();

			switch (c) {
			case "push":
				int integer = sc.nextInt();
				stack.push(integer);
				break;

			case "pop":
				if(stack.size() < 1) {
					sb.append(-1).append('\n');
					break;
				}
				
				int pop = stack.pop();
				sb.append(pop).append('\n');
				break;

			case "size":
				int size = stack.size();
				sb.append(size).append('\n');
				break;
				
			case "empty":
				if(stack.size() == 0) sb.append(1).append('\n');
				else sb.append(0).append('\n');
				break;
				
			case "top":
				if(stack.size() < 1) {
					sb.append(-1).append('\n');
					break;
				}
				
				int top = stack.peek();
				sb.append(top).append('\n');
				break;
			}
		}
		System.out.println(sb.toString());
	}
}
