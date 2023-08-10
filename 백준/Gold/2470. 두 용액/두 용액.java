import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	private static int findPairValue(int[] arr, int fromIndex, int toIndex, int fixedPair) {
		// fixedPair = 고정된 값
		// fromIndex = fixedPair의 바로 다음 index
		int l = fromIndex, r = toIndex;
		int absValue = 2000000001;
		int pairValue = 0;
		while(l <= r) {
			int m = l + ((r-l)/2);
			int sum = fixedPair + arr[m];
			int sumAbs = Math.abs(fixedPair + arr[m]);
			if(absValue > sumAbs) {
				absValue = sumAbs;
				pairValue = arr[m];				
			}
			if(sum < 0) l = m + 1;
			else if(sum > 0) r = m - 1;
			else return pairValue; // sum = 0 이라면 return
		}
		
		return pairValue;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[N];
		for(int i = 0; i<N; i++) arr[i] = Integer.parseInt(st.nextToken());
		Arrays.sort(arr);
		
		int ans = 2000000001; // 반드시 한 번은 변경될 값
		int fs = 0, ls = 0; // 찾은 오름차순 두 값
		for(int i = 0; i<N-1; i++) { // 마지막 값은 fixedValue가 될 수 없다 (비교할게 없기 때문에)
			int pairValue = findPairValue(arr, i+1, N-1, arr[i]);
			int absValue = Math.abs(arr[i]+pairValue);
			if(ans > absValue) {
				ans = absValue;
				fs = arr[i];
				ls = pairValue;
			}
			
		}
		
		System.out.print(new StringBuilder()
				.append(fs)
				.append(" ")
				.append(ls));
			
	}
}
