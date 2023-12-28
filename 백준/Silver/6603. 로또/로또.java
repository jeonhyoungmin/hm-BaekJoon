import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	
	static int[] S;
	static int K;
	static Deque<Integer> output = new ArrayDeque<>();

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			K = Integer.parseInt(st.nextToken());
			if(K == 0) break;
			S = new int[K];
			
			for(int i=0; i<K; i++)
				S[i] = Integer.parseInt(st.nextToken());
			
			recursion(0);
			
			output.clear();
			System.out.println();
		}
		
	}
	
	static void recursion(int start) {
		if(output.size() == 6) {
			StringBuilder sb = new StringBuilder();
			for(int i : output)
				sb.append(i + " ");
			System.out.println(sb);
			return;
		}
		for(int i=start; i<K; i++) {
			output.offerLast(S[i]);
			recursion(i + 1);
			output.pollLast();
		}
	}

}
