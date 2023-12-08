import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		Deque<Integer> stack = new ArrayDeque<Integer>();
		StringBuilder sb = new StringBuilder();
		while (N-- > 0) {

			String[] cmd = br.readLine().split(" ");
			if (cmd[0].equals("push")) {
				int value = Integer.parseInt(cmd[1]);
				stack.offerLast(value);
			} else if (cmd[0].equals("pop")) {
				sb.append(stack.isEmpty() ? "-1\n" : stack.pollLast() + "\n");
			} else if (cmd[0].equals("size")) {
				sb.append(stack.size() + "\n");
			} else if (cmd[0].equals("empty")) {
				sb.append(stack.isEmpty() ? "1\n" : "0\n");
			} else if (cmd[0].equals("top")) {
				sb.append(stack.isEmpty() ? "-1\n" : stack.peekLast() + "\n");
			}

		}

		System.out.println(sb);
	}

}