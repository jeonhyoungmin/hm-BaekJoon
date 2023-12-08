import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		while (T-- > 0) {
			Deque<Character> deq = new ArrayDeque<Character>();
			char[] inputData = br.readLine().toCharArray();

			boolean isValid = true;
			for (int i = 0; i < inputData.length; i++) {
				if (inputData[i] == '(') {
					deq.offerLast('(');
				} else {
					if (deq.isEmpty()) {
						isValid = false;
						break;
					}
					deq.pollLast();
				}
			}

			if (!deq.isEmpty())
				isValid = false;

			System.out.println(isValid ? "YES" : "NO");

		}

	}

}