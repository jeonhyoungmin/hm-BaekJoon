import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

	public static boolean isMatch(char open, char close) {
		if (open == '(' && close == ')')
			return true;
		if (open == '[' && close == ']')
			return true;
		return false;
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			char[] str = br.readLine().toCharArray();
			if (str.length == 1 && str[0] == '.')
				break;

			Deque<Character> deq = new ArrayDeque<>();
			boolean isValid = true;

			for (char ch : str) {
				if (ch == '(' || ch == '[') {
					deq.offerLast(ch);
				} else if (ch == ')' || ch == ']') {
					if (deq.isEmpty() || !isMatch(deq.pollLast(), ch)) {
						isValid = false;
						break;
					}
				}
			}

			if (!deq.isEmpty())
				isValid = false;
			System.out.println(isValid ? "yes" : "no");
		}

	}

}