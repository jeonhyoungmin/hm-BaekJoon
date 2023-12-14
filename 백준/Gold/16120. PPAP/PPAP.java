import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] line = br.readLine().toCharArray();
		int lineLength = line.length;

		boolean ppapChk = false;
		boolean isValid = true;
		int index = -1;
		Deque<Character> deq = new ArrayDeque<>();

		while (true) {

			if (++index > lineLength - 1)
				break;
			char ch = line[index];

			if (ch == 'P') {
				if (!deq.isEmpty() && deq.peekLast() == 'P')
					ppapChk = true;
			} else {
				if (deq.isEmpty() || index + 1 > lineLength - 1 || line[index + 1] == 'A') {
					isValid = false;
					break;
				}
				if (ppapChk) {
					deq.pollLast();
					deq.pollLast();
					++index;
					if (deq.isEmpty() || deq.peekLast() != 'P')
						ppapChk = false;
				}
			}
			deq.offerLast('P');

		}

		System.out.println(isValid && deq.size() == 1 ? "PPAP" : "NP");
	}

}
