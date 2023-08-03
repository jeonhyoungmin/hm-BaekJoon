import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		LinkedList<Integer> q = new LinkedList<>();
		for (int i = 0; i < N; i++) q.offer(i + 1); // Queue에 1~N 추가

		StringBuilder sb = new StringBuilder();
		sb.append("<");
		int period = 0; // 주기 기준
		while (q.size() > 1) { // 마지막 데이터 남기기
			period++;
			int data = q.poll();

			if (period == K) { // K 주기, 데이터 offer 과정 생략
				period = 0;
				sb.append(data + ", ");
				continue;
			}

			q.offer(data); // K 주기가 아닐 경우, 데이터 offer

		}

		sb.append(q.poll()).append(">"); // 마지막 데이터 붙이기
		System.out.println(sb);

	}

}
