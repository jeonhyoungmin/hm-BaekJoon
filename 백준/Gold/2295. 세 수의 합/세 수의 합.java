import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {

	public static void main(String[] args) {
		// 입력
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] U = new int[N];
		for(int i = 0; i<N; i++) U[i] = sc.nextInt();
		
		// x + y + z = K 일 때,
		// x + y = K - z 를 만족하는 K를 찾기
		int idx = 0;
		Set<Integer> hs = new HashSet<>();
		for(int i = 0; i<N; i++)
			for(int j = i; j<N; j++) // 중복을 제거하기 위해 j = i 부터 시작
				hs.add(U[i] + U[j]); 
		
		int ans = -1;
		for(int i = 0; i<N; i++)
			for(int j = 0; j<N; j++) { // U[1] - U[2] != U[2] - U[1]. j=0부터 시작
				int target = U[i] - U[j]; 
				if(hs.contains(target)) ans = Math.max(ans, U[i]);
			}
		
		// 출력
		System.out.println(ans);
	}
}