import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] line = br.readLine().toCharArray();
		Deque<Character> deq = new ArrayDeque<>();
		boolean isPrevClose = false;
		int count = -1;

		for (char bracket : line) {

			if (bracket == '(') {
				deq.offerLast(bracket);
				if (!isPrevClose)
					count++;
				isPrevClose = false;
			} else {
				deq.pollLast();
				if(!isPrevClose) count += deq.size();
				isPrevClose = true;
			}
			
		}

		System.out.println(count);
	}

}