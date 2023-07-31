import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		// N장의 카드
		// N 1~500,000

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		Queue<Integer> lq = new LinkedList<>();
		for (int i = 0; i < N; i++)
			lq.offer(i + 1);
		
		while(lq.size() != 1) {
			// poll and (poll and offer) size가 1이 될 때까지 반복
			lq.poll();
			int switching = lq.poll();
			lq.offer(switching);
		}

		System.out.println(lq.poll());

	}

}
