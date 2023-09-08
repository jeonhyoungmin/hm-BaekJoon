import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int Q = Integer.parseInt(st.nextToken());
		
		int[] acc = new int[N + 1];
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<=N; i++) {
			acc[i] = Integer.parseInt(st.nextToken()) ^ acc[i - 1];
		}
		
		st = new StringTokenizer(br.readLine());
		int s = Integer.parseInt(st.nextToken());
		int l = Integer.parseInt(st.nextToken());
		int pre = acc[l] ^ acc[s-1];
		for(int i=0; i<Q-1; i++) {
			st = new StringTokenizer(br.readLine());
			s = Integer.parseInt(st.nextToken());
			l = Integer.parseInt(st.nextToken());
			
			int now = acc[l] ^ acc[s-1];
			pre = pre ^ now;
		}
		
		System.out.println(pre);
	}
}