import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		int[] A = new int[N];
		int[] B = new int[M];
		
		for(int i=0; i<N; i++)
			A[i] = sc.nextInt();
		
		for(int i=0; i<M; i++)
			B[i] = sc.nextInt();
		
		int[] ans = new int[N+M];
		
		int k = 0;
		int i=0, j =0; // 각각 A,B의 인덱스
		while(i<N && j<M) {
			int a = A[i];
			int b = B[j];
			
			if(a<b) {
				ans[k] = a;
				i++;
				k++;
			} else {
				ans[k] = b;
				j++;
				k++;
			}
		}
		
		for(; i<N; i++) {
			ans[k] = A[i] ;
			if(k == ans.length-1) break;
			k++;
		}
		
		for(; j<M; j++) {
			ans[k] = B[j];
			if(k == ans.length-1) break;
			k++;
		}
		
		StringBuilder sb = new StringBuilder();
		for(int e : ans) {
			sb.append(e + " ");
		}
		
		System.out.println(sb.toString());

	}

}
