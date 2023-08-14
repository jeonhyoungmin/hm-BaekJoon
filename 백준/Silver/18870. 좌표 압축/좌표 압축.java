import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[][] arr = new int[N][2];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i<N; i++) {
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = i;
		}
		
		// 2 4 -10 4 -9
		// [-10, 2] [-9, 4] [2, 0] [4, 1] [4, 3]
//		Arrays.sort(arr, new Comparator<int[]>() {
//			@Override
//			public int compare(int[] o1, int[] o2) {
//				return o1[0] - o2[0];
//			}
//		});
		
		//lambda
		Arrays.sort(arr, (o1, o2) -> o1[0] - o2[0]);
		
		int[] ans = new int[N];
		int idx = 0;
		ans[arr[0][1]] = idx;
		for(int i = 1; i<N; i++) {
			if(arr[i][0] != arr[i-1][0]) {
				idx++;
				ans[arr[i][1]] = idx;
			} else ans[arr[i][1]] = idx; 
		}

		StringBuilder sb = new StringBuilder();
		for(int i : ans) sb.append(i).append(" ");
		
		System.out.println(sb);
	}
}