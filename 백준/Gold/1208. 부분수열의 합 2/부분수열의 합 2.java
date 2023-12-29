import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main { // * 다시 풀어보기 *

	static int[] arr;
	static int S;
	static int status = -1;
	static int LEFT = 0;
	static int RIGHT = 1;
	static Map<Integer, Integer> map = new HashMap<>();
	static long ans = 0; // 답이 int 범위를 넘을 수 있음

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());

		arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(st.nextToken());

		status = LEFT;
		recursion(0, N / 2, 0);

		status = RIGHT;
		recursion(N / 2, N, 0);
		
		if(S == 0) ans--;
		/*
		 * S가 0일 경우
		 * 왼쪽에서 아무것도 고르지 않은 경우 sum=0
		 * 오른쪽에서 아무것도 고르지 않은 경우 sum=0
		 * 존재하지 않는 0을 선택하게 되므로 -1을 해준다.
		*/
		System.out.println(ans);
	}

	static void recursion(int index, int end, int sum) {

		if (index == end) {
			if (status == LEFT) {
				int prev = map.getOrDefault(sum, 0);
				map.put(sum, prev + 1);
			} else if (status == RIGHT) {
				ans += map.getOrDefault(S - sum, 0);
			}
			return;
		}

		recursion(index + 1, end, sum);
		recursion(index + 1, end, sum + arr[index]);

	}

}
