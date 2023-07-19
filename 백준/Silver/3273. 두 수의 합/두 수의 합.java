import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt(); // 수열 개수
		int[] array = new int[n]; // 수열의 배열
		for(int i=0; i<n; i++)
			array[i] = sc.nextInt();
		int x = sc.nextInt();
		
		// x-array[i]의 값을 찾기 위한 boolean 배열인 exist 생성
		boolean[] exist = new boolean[1000000];
		for(int i=0; i<n; i++) {
			exist[array[i]] = true;
		}
		
		int ans = 0;
		for(int i=0; i<n; i++) {
			int partner = x-array[i];
			if(1<=partner && partner <= 100000) {
				ans += exist[partner] ? 1:0;
			}
		}
		
		// 중복된 값 제거를 위해 2를 나눔
		System.out.println(ans/2);
	}

}
