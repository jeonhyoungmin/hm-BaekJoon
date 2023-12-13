import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		while(T-->0) {
			
			char[] line = br.readLine().toCharArray();
			Deque<Character> deq = new ArrayDeque<>();
			Deque<Character> temp = new ArrayDeque<>();
			
			for(int i=0; i<line.length; i++) {
				
				char ch = line[i];
				
				if(ch == '<') {
					
					if(deq.isEmpty()) continue;
					temp.offerLast(deq.pollLast());
					
				} else if(ch == '>') {
					
					if(!temp.isEmpty())
						deq.offerLast(temp.pollLast());
					
				} else if(ch == '-') {
					deq.pollLast();
				} else {
					deq.offerLast(ch);
				}
				
			}
			
			StringBuilder sb = new StringBuilder();
			while(!deq.isEmpty())
				sb.append(deq.pollFirst());
			while(!temp.isEmpty())
				sb.append(temp.pollLast());
			
			System.out.println(sb);
			
		}
		
	}

}
