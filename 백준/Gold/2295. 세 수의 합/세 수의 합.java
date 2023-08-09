import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static boolean isExist(int[] arr, int target) {
		int l = 0, r = arr.length - 1;
		while(l <= r) {
			int m = (l+r)/2;
			if(arr[m] < target) l = m + 1;
			else if(arr[m] > target) r = m - 1;
			else return true;
		}
		return false;
	}

	public static void main(String[] args) {
		// 입력
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] U = new int[N];
		for(int i = 0; i<N; i++) U[i] = sc.nextInt();
		
		// x + y + z = K 일 때,
		// x + y = K - z 를 만족하는 K를 찾기
		int idx = 0;
		int[] xySums = new int[N*(N+1)/2];
		for(int i = 0; i<N; i++)
			for(int j = i; j<N; j++) // 중복을 제거하기 위해 j = i 부터 시작
				xySums[idx++] = U[i] + U[j]; 
		
		Arrays.sort(xySums);
		
		int ans = -1;
		for(int i = 0; i<N; i++)
			for(int j = 0; j<N; j++) { // U[1] - U[2] != U[2] - U[1]. j=0부터 시작
				int target = U[i] - U[j]; 
				if(isExist(xySums, target))
					ans = Math.max(ans, U[i]);
			}
		
		// 출력
		System.out.println(ans);
	}
}
