import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static class Document<E> {
		
		E priority;
		int index;
		
		public Document(E priority, int index) {
			this.priority = priority;
			this.index = index;
		}
		
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		while(T-->0) {
			
			Queue<Document<Integer>> q = new LinkedList<Document<Integer>>();
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			Integer[] existData = new Integer[N];
			
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<N; i++) {
				int priority = Integer.parseInt(st.nextToken());
				Document<Integer> doc = new Document<Integer>(priority, i);
				q.offer(doc);
				existData[i] = priority;
			}

			 Arrays.sort(existData, Collections.reverseOrder());
			 
			for(int i=0; i<N; i++) {
				
				while(q.peek().priority != existData[i])
					q.offer(q.poll());
				
				if(q.peek().index == M) {
					System.out.println(i+1);
					break;
				}
				
				q.poll();
				
			}
		}
		
	}

}
