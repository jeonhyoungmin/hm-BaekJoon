import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static boolean isPossible(int[] arr, int m, int M) {
		int count = 1;
		int withdraw = m;
		for(int useMoney : arr) {
			if(useMoney > m) return false; // 일일 사용 금액보다 인출 금액이 작으면 return false
			if(useMoney > withdraw) {
				if(count == M) return false; // 인출 횟수가 M을 넘기면 return false
				count++;
				withdraw = m;
			}
			withdraw -= useMoney;
		}
		
		return true;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 1~100,000
		int M = Integer.parseInt(st.nextToken()); // 1~100,000    M <= N
		int[] arr = new int[N];
		for(int i = 0; i<N; i++) arr[i] = Integer.parseInt(br.readLine());
		
		// 주의 사항
		// 1. N일 동안 1번만 인출한다면, r = 일일 최대 사용 금액 10000 * N
		// 2. 정확히 M번을 맞추기 위해서
		// 남은 금액이 그날 사용할 금액보다 많더라도 남은 금액은 통장에 집어넣고 다시 K원을 인출할 수 있다.
		// 즉, M번 이하로 인출하게 하는 인출 최소 금액 K를 찾으면 된다.
		// M번 이하로 인출하더라도 M번을 임의로 맞춘다는 조건이다.
		int l = 1, r = N*10000, K = -1;
		while(l <= r) {
			int m = l + ((r-l)/2);
			if(isPossible(arr, m, M)) {
				K = m;
				r = m - 1;
			} else l = m + 1;
		}
		
		System.out.println(K);
	}

}
