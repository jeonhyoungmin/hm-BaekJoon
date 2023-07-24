import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// 대상 숫자를 해당 진법으로 나눈 나머지를 진법의 자리수 표현대로 표현하기
		// 알파벳이 들어가기 때문에 StringBuilder로 출력 대상 작성 (범위가 10억이기 때문에)
		// 남은 값이 진법보다 작아질 때까지 나누고, 나머지를 변환해서 저장

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int B = sc.nextInt();

		String ans = "";

		while (N > 0) {
			if (N < B) {
				if(N>=10) {
					ans += ((char) (N + 55));					
				} else {
					ans += N;
				}
				break;
			}
			if(N % B>=10) {
				ans += ((char) ((N % B) + 55));					
			} else {
				ans += (N % B);
			}
			N = N / B;
		}
		
		for(int i=ans.length()-1; i>=0; i--)
			System.out.print(ans.charAt(i));
	}

}
