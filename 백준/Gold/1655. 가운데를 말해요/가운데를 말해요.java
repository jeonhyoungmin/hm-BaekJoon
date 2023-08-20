import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
//		우선순위 역순 방법 1
//		Queue<Integer> minq = new PriorityQueue<>(Collections.reverseOrder());
		
//		우선순위 역순 방법 2
//		Queue<Integer> minq = new PriorityQueue<>(new Comparator<Integer>() {
//			@Override
//			public int compare(Integer o1, Integer o2) {
//				return o2 - o1;
//			}
//		});
		
		Queue<Integer> minq = new PriorityQueue<>((o1, o2) -> o2 - o1); // 우선순위 역순
		Queue<Integer> maxq = new PriorityQueue<>();
		StringBuilder sb = new StringBuilder();
		int order = 0;
		while(N-- > 0) {
			int data = Integer.parseInt(br.readLine());
			if(order % 2 == 0) minq.offer(data); // minq부터 데이터 삽입
			else maxq.offer(data);
			order++;
			
			if(maxq.peek() != null && minq.peek() > maxq.peek()) {
				maxq.offer(minq.poll());
				minq.offer(maxq.poll());
			}
			
			sb.append(minq.peek()).append("\n");
		}
		System.out.println(sb);
		
	}
}