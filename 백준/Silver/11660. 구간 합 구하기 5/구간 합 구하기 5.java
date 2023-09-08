import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] arr = new int[N+1][N+1];
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<=N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int[][] acc = new int[N+1][N+1];
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				// 1. 필요한 누적합 참조
				// 2. 중복되는 누적합 제외
				// 3. 이번 요소를 더한다.
				acc[i][j] = acc[i-1][j] + acc[i][j-1] - acc[i-1][j-1] + arr[i][j]; 
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			
			// 1. 구하고자 하는 누적합 (x2, y2) 참조
			// 2. 불필요한 누적합 부분을 제외
			// 3. 공통된 누적합을 더한다.
			int result = acc[x2][y2] - acc[x2][y1-1] - acc[x1-1][y2] + acc[x1-1][y1-1]; 
			sb.append(result + "\n");
		}
		
		System.out.println(sb.toString());
	}
}