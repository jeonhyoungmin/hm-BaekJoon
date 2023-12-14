import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		Deque<Integer> stack = new ArrayDeque<>();
		StringBuilder sb = new StringBuilder();
		boolean isValid = true;

		int num = 1;
		int prev = -1;
		for(int i=0; i<N; i++) {

			int input = Integer.parseInt(br.readLine());
			
			if(stack.isEmpty() || prev < input) {
				while(num <= input) {
					stack.offerLast(num++);
					sb.append("+" + "\n");
				}
			} else if (prev > input) {
				if(stack.peekLast() != input) {
					isValid = false;
					break;
				}
			}
			prev = stack.pollLast();
			sb.append("-" + "\n");

		}

		System.out.println(isValid ? sb : "NO");

	}

}
