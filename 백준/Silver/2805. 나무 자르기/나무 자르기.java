import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	private static long findMaxValue(int[] arr, long maxSawHeight, long target) {
		long l = 0, r = maxSawHeight; // 톱 높이 범위
		long maxValue = 0; // 출력할 톱의 최대 높이
		while(l <= r) {
			long m = l + ((r-l)/2);
			// sawHeights[m] 보다 높은 나무에서 얻을 수 있는 길이 측정
			long accumulate = measureTarget(arr, m);
			// target 초과 시, l = m + 1;
			if(accumulate > target) {
				maxValue = m;					
				l = m + 1;
			}
			// target 미만 시, r = m - 1;
			else if(accumulate < target) r = m - 1;
			// target 동일 시, maxValue로 출력
			else return m;
		}
		
		return maxValue;
	}
	
	private static long measureTarget(int[] arr, long m) {
		long accumulate = 0;
		for(int i = arr.length - 1; i>=0; i--) {
			if (arr[i] <= m) break;
			accumulate += arr[i] - m;
		}
		return accumulate;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		long M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int[] arr = new int[N];
		for(int i = 0; i<N; i++) arr[i] = Integer.parseInt(st.nextToken());
		Arrays.sort(arr);
		
		long maxSawHeight = arr[arr.length - 1] - 1; // 가장 높은 나무의 톱 높이는 제외
		long maxValue = findMaxValue(arr, maxSawHeight, M);
		System.out.println(maxValue);
	}

}
