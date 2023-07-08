import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		char[][] table = new char[N][M];
		for(int i=0 ; i<N ; i++) {
			table[i] = sc.next().toCharArray(); 
		}
		
		// 1. 경비병이 있는지 체크
		int existRow = 0;
		for(int i=0; i<N ;i++) {
			for(int j=0; j<M ;j++) {
				if(table[i][j] == 'X') {
					existRow ++;
					break;
				}
			}
		}
		
		int existCol = 0;
		for(int i=0; i<M ;i++) {
			for(int j=0; j<N ;j++) {
				if(table[j][i] == 'X') {
					existCol ++;
					break;
				}
			}
		}
		
		// 2. 보호 받지 못하는 행 열 체크
		int noSecurityRow = N-existRow;
		int noSecurityCol = M-existCol;
		
		// 3. 수가 더 큰 행 열 출력
		System.out.println(Math.max(noSecurityRow, noSecurityCol));
	}
}
