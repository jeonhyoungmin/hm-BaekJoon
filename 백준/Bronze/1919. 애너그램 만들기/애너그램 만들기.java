import java.util.Scanner;

public class Main {
	public static int[] calc(String str) {
		int[] count = new int[26];
		for(int i=0; i<str.length(); i++) {
			count[str.charAt(i)-'a']++;
		}
		
		return count;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String a = sc.nextLine();
		String b = sc.nextLine();
		int num = 0;
		
		int[] countA = calc(a);
		int[] countB = calc(b);
		
		for(int i=0; i<26; i++) {
			num += Math.abs(countA[i]-countB[i]); 
		}
		
		System.out.println(num);
		
	}
}