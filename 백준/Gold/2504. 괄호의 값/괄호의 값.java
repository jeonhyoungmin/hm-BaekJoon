import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

	static class Box {

		Character ch = 'x';
		Integer num = 0;

		public Box(Character ch) {
			this.ch = ch;
		}

		public Box(Integer num) {
			this.num = num;
		}

	}
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] line = br.readLine().toCharArray();
		Deque<Box> deq = new ArrayDeque<>();
		int ans = 0;
		boolean isValid = true;

		for (Character ch : line) {
			if (ch == '(') {
				deq.offerLast(new Box(ch));
			} else if (ch == ')') {
				if (deq.isEmpty() || deq.peekLast().ch == '[') {
					isValid = false;
					break;
				}
				if (deq.peekLast().ch == '(') {
					deq.pollLast();
					if(deq.isEmpty()) ans += 2;
					else deq.offerLast(new Box(2));
				} else if (deq.peekLast().ch == 'x') {
					int temp = 0;
					while (deq.peekLast().ch != '(') {
						temp += deq.pollLast().num;
						if(deq.isEmpty()) {
							isValid = false;
							break;
						}
					}
					deq.pollLast();
					if (deq.isEmpty())
						ans += temp * 2;
					else
						deq.offerLast(new Box(temp * 2));
				}
			} else if (ch == '[') {
				deq.offerLast(new Box(ch));

			} else if (ch == ']') {
				if (deq.isEmpty() || deq.peekLast().ch == '(') {
					isValid = false;
					break;
				}
				if (deq.peekLast().ch == '[') {
					deq.pollLast();
					if(deq.isEmpty()) ans += 3;
					else deq.offerLast(new Box(3));
				} else if (deq.peekLast().ch == 'x') {
					int temp = 0;
					while (deq.peekLast().ch != '[') {
						temp += deq.pollLast().num;
						if(deq.isEmpty()) {
							isValid = false;
							break;
						}
					}
					deq.pollLast();
					if (deq.isEmpty())
						ans += temp * 3;
					else
						deq.offerLast(new Box(temp * 3));
				} 

			}

		}
		
		if (!deq.isEmpty())
			isValid = false;
		System.out.println(isValid ? ans : 0);
	}

}