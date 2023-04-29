import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine().toUpperCase();
		
		int[] count = new int[26];
		for(int i=0; i<str.length(); i++) {
			count[str.charAt(i)-'A']++;
		}
		
		int maxCount = -1; // 가장 큰 숫자
		char alph = '?';
		
		for(int i=0; i<count.length; i++) {
			if(count[i]>maxCount) {
				maxCount = count[i];
				alph = (char)(i+'A');
			} else if (count[i]==maxCount) {
				alph = '?';
			}
		}
		
			System.out.println(alph);
		
	}
}