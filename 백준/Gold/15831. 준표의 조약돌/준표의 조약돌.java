import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int MaxB = Integer.parseInt(st.nextToken()); // B개 이하
		int MinW = Integer.parseInt(st.nextToken()); // W개 이상
		
		char[] arr = br.readLine().toCharArray();
		int ans = 0;
		
		int countB = 0;
		int countW = 0;
		int pairIndex = 0;

		for(int i=0; i<N; i++) {
			while(pairIndex < N) {
				if(countB == MaxB && arr[pairIndex] == 'B') break;
				if(arr[pairIndex++] == 'W') countW++;
				else countB++;
			}
			
			if(countW >= MinW) {
				ans = Math.max(ans, pairIndex - i);
			}
			
			if(arr[i] == 'W') countW--;
			else countB--;
		}
		
		System.out.println(ans);
	}
}
