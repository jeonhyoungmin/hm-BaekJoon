import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		// L개의 문자열의 해시 값을 구하기
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int L = Integer.parseInt(br.readLine()); // 문자열 길이
		int r = 31; // 고유한 계수인 소수
		int M = 1234567891; // 유한한 범위를 출력을 위해 사용하는 소수, r과 M은 서로소
		
		String str = br.readLine();
		char[] arr = str.toCharArray();
		long ans = 0;
		long pow = 1;
		
		// 
		for(int i = 0; i<str.length(); i++) {
			ans += (arr[i] - 'a' + 1)*pow;
			pow = (pow*r) % M; // long의 범위를 넘지 않도록 % M
		}
		
		ans = ans % M;

		System.out.println(ans);

	}

}
