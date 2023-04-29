import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		
		String upperString = str.toUpperCase();

		int compareNum = 0; // 가장 큰 숫자
		int equals = 0;
		int index = 0;
		
		char[] ch = upperString.toCharArray();
		int[] count = new int[26];
		for(int i=0; i<ch.length; i++) {
			count[ch[i]-'A']++;
		}
		
		for(int i=0; i<count.length; i++) {
			if(count[i]>compareNum) {
				compareNum = count[i];
				equals = 0;
				index = i;
			} else if (count[i]==compareNum ) {
				equals++;
			}
		}
		
		if(equals > 0) {
			System.out.println("?");
		} else {
			System.out.println((char)(index + 'A'));
		}
		
		
	}
}