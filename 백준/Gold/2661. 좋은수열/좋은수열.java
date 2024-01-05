import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	/*
	 * *** 다시 풀어보기 ***
	 * 별(*) 개수 : 도움 받은 정도(힌트, 참고)
	 * 별(*) 3개 : 완전 참고
	 */

	static int n;
	static int[] numbers = new int[80];

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		solve(0);
	}

	static boolean solve(int endIndex) {
		if (endIndex == n) {
			for (int i=0; i<n; i++)
				System.out.print(numbers[i]);
			return true;
		} else {
			for (int i = 1; i <= 3; i++) {
				numbers[endIndex] = i;
				if (!isBad(endIndex)) {
					if(solve(endIndex + 1)) return true;
				}
			}
		}
		return false;
	}

	private static boolean isBad(int endIndex) {
		for (int i = 1; i <= (endIndex + 1) / 2; i++) {
			boolean isSame = true;
			for (int j = 0; j < i; j++) {
				if (numbers[endIndex - j] != numbers[endIndex - i - j]) {
					isSame = false;
					break;
				}
			}
			if(isSame) return true;
		}
		return false;
	}
}