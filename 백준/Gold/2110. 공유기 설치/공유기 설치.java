import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	private static boolean isPossible(int[] arr, int m, int C) {
		// 설치 가능한 좌표만 찾으면 됨
		// 좌표와 설치된 좌표의 차이가 m 이상일 경우 설치 가능
		int install = 1;
		int installed = arr[0];
		for(int i = 1; i<arr.length; i++)
			if(arr[i] - installed >= m) {
				installed = arr[i];
				install++;
			}

		return install >= C;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		for(int i = 0; i<N; i++) arr[i] = Integer.parseInt(br.readLine());
		Arrays.sort(arr);
		
		int l = 1, r = arr[N - 1] - arr[0], maxLength = -1;
		while(l <= r) {
			int m = l + ((r-l)/2);
			if(isPossible(arr, m, C)) {
				maxLength = m;
				l = m + 1;
			} else r = m - 1;
		}
		
		System.out.println(maxLength);
	}

}
