import java.util.LinkedList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int K = sc.nextInt();

		LinkedList<Integer> q = new LinkedList<>();
		for (int i = 0; i < N; i++) q.offer(i + 1); // Queue에 1~N 추가

		StringBuilder sb = new StringBuilder();
		sb.append("<");
		int period = 0; // 주기 기준
		while (!q.isEmpty()) {
			period++;

			int data = q.poll();

			if (period == K) { // K 주기, 데이터 offer 과정 생략
				period = 0;
				sb.append(data + ", ");
				continue;
			}

			q.offer(data); // K 주기가 아닐 경우, 데이터 offer

		}

		sb.delete(sb.length() - 2, sb.length());
		System.out.println(sb.append(">"));

	}

}
