import java.util.Scanner;
import java.util.Stack;

public class Main {

	private static Stack<Integer> stack = new Stack<>();
	
	private static void push(int i) {
		stack.push(i);
	}
	
	private static int pop() {
		if(stack.size() < 1) return -1;
		return stack.pop();
	}
	
	private static int size() {
		return stack.size();
	}
	
	private static int empty() {
		if(stack.size() == 0) return 1;
		return 0;
	}
	
	private static int top() {
		if(stack.size() < 1) return -1;
		return stack.peek();
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 명령의 수 N
		int N = sc.nextInt();
		
		// Scanner와 System.out.println을 같이 사용하면 시간 초과를 받는다
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < N; i++) {

			String c = sc.next();

			switch (c) {
			case "push":
				push(sc.nextInt());
				break;

			case "pop":
				sb.append(pop()).append('\n');
				break;

			case "size":
				sb.append(size()).append('\n');
				break;
				
			case "empty":
				sb.append(empty()).append('\n');
				break;
				
			case "top":
				sb.append(top()).append('\n');
				break;
			}
		}
		System.out.println(sb.toString());
	}
}
