import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			char[] str = br.readLine().toCharArray();
			if (str.length == 1)
				break;

			Deque<Character> deq = new ArrayDeque<>();
			boolean isValid = true;

			for (int i = 0; i < str.length; i++) {
				char data = str[i];
				if (data == '(') {
					deq.offerLast(data);
				} else if (data == ')') {
					if (deq.isEmpty() || deq.pollLast() != '(') {
						isValid = false;
						break;
					}
				} else if (data == '[') {
					deq.offerLast(data);
				} else if (data == ']') {
					if (deq.isEmpty() || deq.pollLast() != '[') {
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