import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.stream.Stream;

public class Main {
	
	static int[][] accLife(char[][] arr){
		int[][] accLife = new int[arr.length][arr[0].length];
		for(int i=1; i<arr.length; i++) {
			for(int j=1; j<arr[0].length; j++) {
				accLife[i][j] = accLife[i-1][j] + accLife[i][j-1] - accLife[i-1][j-1]
						+ (arr[i][j] == '*' ? 1:0);
			}
		}
		return accLife;
	}
	
	static int getNearbyLife(int[][] acc, int r, int c, int K) {
		int r1 = Math.max(r - K, 1);
		int c1 = Math.max(c - K, 1);
		int r2 = Math.min(r + K, acc.length -1);
		int c2 = Math.min(c + K, acc[0].length -1);
		return acc[r2][c2] - acc[r2][c1-1] - acc[r1-1][c2] + acc[r1-1][c1-1];
	}

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int K = Integer.parseInt(st.nextToken());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		
		char[][] arr = new char[N+1][M+1];
		for(int i=1; i<=N; i++) {
			String row = br.readLine();
			for(int j=1; j<=M; j++) {
				arr[i][j] = row.charAt(j-1);
			}
		}
		
		while(T-- > 0) {
			int[][] acc = accLife(arr);
			for(int i=1; i<=N;i ++) {
				for(int j=1; j<=M; j++) {
					int nearbyLife = getNearbyLife(acc, i, j, K);
					if(arr[i][j] == '*') {
						nearbyLife--;
						if(nearbyLife < A || nearbyLife > B) {
							arr[i][j] = '.';
						}
					} else if(A < nearbyLife && nearbyLife <= B) {
							arr[i][j] = '*';
					}
				}
			}			
		}
		
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=M; j++) {
				System.out.print(arr[i][j]);
			}
			System.out.println();
		}
		
	}
}