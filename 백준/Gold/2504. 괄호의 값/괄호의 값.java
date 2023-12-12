import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

	static class Box {
		enum Type {BRACKET, SCORE};
		Type type; 
		int value;

		public Box(Type type, int value) {
			this.type = type;
			this.value = value;
		}
	}
	
	static int bracketValue(char ch) {
		if(ch == '(' || ch == ')') return 2;
		else if(ch == '[' || ch == ']') return 3;
		return -1;
	}
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] line = br.readLine().toCharArray();
		Deque<Box> deq = new ArrayDeque<>();
		boolean isValid = true;

		for (Character ch : line) {
			if (ch == '(' || ch == '[') {
				deq.offerLast(new Box(Box.Type.BRACKET, bracketValue(ch)));
			} else {
					
				int temp = 0;
				while(!deq.isEmpty() && deq.peekLast().type == Box.Type.SCORE) {
					temp += deq.pollLast().value;
				}
				
				if(deq.isEmpty() || deq.peekLast().value != bracketValue(ch)) {
					isValid = false;
					break;
				}
				temp = temp * bracketValue(ch);
				if(temp == 0) temp = bracketValue(ch);
				deq.pollLast();
				deq.offerLast(new Box(Box.Type.SCORE, temp));
			}
		}
		
		int ans = 0;
		while(!deq.isEmpty()) {
			if(deq.peekLast().type == Box.Type.BRACKET) {
				isValid = false;
				break;
			}
			ans += deq.pollLast().value;
		}
		
		System.out.println(isValid ? ans : 0);
	}

}