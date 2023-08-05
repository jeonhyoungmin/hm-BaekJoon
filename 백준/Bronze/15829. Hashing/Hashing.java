import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// L개의 문자열의 해시 값을 구하기
		
		Scanner sc = new Scanner(System.in);
		
		int L = sc.nextInt();
		
		// a~z 26개의 문자에 수 지정
		
		String str = sc.next();
		
		int ans = 0;
		for(int i = 0; i<str.length(); i++) {
			ans += (str.charAt(i) - 96)*Math.pow(31, i);
		}

		System.out.println(ans);

	}

}
