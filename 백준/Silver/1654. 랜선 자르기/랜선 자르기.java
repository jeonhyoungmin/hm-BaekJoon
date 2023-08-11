import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	private static boolean isPossible(int[] arr, long m, int N) {
		int sum = 0;
		for(int i = arr.length - 1; i>=0; i--) {
			sum += arr[i]/m;
			if(sum >= N) return true;
		}
		return false;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int K = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int[] arr = new int[K];
		for(int i = 0; i<K; i++) arr[i] = Integer.parseInt(br.readLine());
		Arrays.sort(arr);
		
		long maxValue = -1; // N개의 랜선을 만들 수 없는 경우가 없기 때문에 아무 값이나 가능
		long l = 1, r = arr[arr.length - 1];
		while(l <= r) {
			long m = l + ((r-l)/2);
			// m으로 잘랐을 때, N을 충족하는지 확인하는 isPossible(arr, m, N)
			// true: maxValue = m, l = m + 1;
			// false: r = m - 1;
			if(isPossible(arr, m, N)) {
				maxValue = m;
				l = m + 1;
			} else r = m - 1;
		}
		System.out.println(maxValue);
	}

}
