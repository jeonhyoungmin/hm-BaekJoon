import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt(); // 수열 개수
		int[] array = new int[n]; // 수열의 배열
		for(int i=0; i<n; i++)
			array[i] = sc.nextInt();
		int x = sc.nextInt();
		
		// x-array[i]
		int[] exist = new int[1000000];
		for(int i=0; i<n; i++) {
			exist[array[i]] ++;
		}
		
		int ans = 0;
		for(int i=0; i<n; i++) {
			int partner = x-array[i];
			if(1<=partner && partner <= 100000) {
				ans += exist[partner]==1 ? 1:0;
			}
		}
		
		System.out.println(ans/2);
	}

}
