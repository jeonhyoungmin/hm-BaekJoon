import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int P = sc.nextInt();
		
		while(P-- > 0) {
			
			int T = sc.nextInt();
			int[] L = new int[20];
			for(int i=0; i<20; i++) {
				L[i] = sc.nextInt(); 
			}
			
			int cnt = 0;
			int[] sorted = new int[20];
			for(int i=0; i<20; i++) {
				
				boolean find = false;
				for(int j=0; j<i; j++) {
					if(sorted[j] > L[i]) {
						find = true;
						for(int k=i-1; k>=j; k--) {
							sorted[k+1] = sorted[k];
							cnt++;							
						}
						sorted[j] = L[i];
						break;
					}
				}
				
				if(!find) sorted[i] = L[i];
			}
			
			System.out.println(T + " " + cnt);
		}
	}
}
