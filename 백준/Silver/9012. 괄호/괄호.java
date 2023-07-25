import java.util.Scanner;
import java.util.Stack;

public class Main {

	private static void vpsCheck(String s) {
		Stack<Character> stack = new Stack<>();

		int i = 0;
		while (i < s.length()) {
			char c = s.charAt(i);

			if (c == '(') {
				stack.push(c);
			} else {
				if (stack.size() < 1) {
					System.out.println("NO");
					return;
				}
				stack.pop();
			}
			i++;
		}

		if (stack.size() > 0) {
			System.out.println("NO");
		} else {
			System.out.println("YES");
		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for(int i=0; i<T; i++) {
			vpsCheck(sc.next());
		}
	}
}