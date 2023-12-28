import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main { // * 다시 풀어보기 *

	static int n;
	static int m;
	static long[][] mem;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		while (T-- > 0) {

			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());

			mem = new long[n + 1][m + 1];

			for (int i = 0; i <= n; i++) {
				for (int j = 0; j <= m; j++) {
					mem[i][j] = -1;
				}
			}

			System.out.println(recursion(n, m));
			
		}
	}

	static long recursion(int i, int last) {
		if (last <= 0)
			return 0;
		if (i == 1)
			return last;
		if (mem[i][last] == -1)
			mem[i][last] = recursion(i - 1, last / 2) + recursion(i, last - 1);

		return mem[i][last];
	}

}
