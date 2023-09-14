import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken()); 
		}
		
		int ansLength = N+1;
		int rightIndex = 0;
		int sum = arr[0];
		for(int i=0; i<N; i++) {
			while(sum < S && rightIndex < N - 1) {
				sum += arr[++rightIndex];
			}
			
			if(sum >= S) {
				ansLength = Math.min(ansLength, rightIndex - i + 1);
			}
			
			sum -= arr[i];
		}
		
		if(ansLength > N) ansLength = 0; 
		System.out.println(ansLength);
	}

}