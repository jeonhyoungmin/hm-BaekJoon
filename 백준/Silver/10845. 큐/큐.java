import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		// push 추가
		// pop 가장 앞에 있는 데이터 출력, 없으면 -1
		// size 큐의 크기 출력
		// empty 1, 0
		// front 가장 앞에 있는 정수 출력, 없으면 -1
		// back 가장 뒤에 있는 정수 출력, 없으면 -1
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());

		LinkedList<Integer> q = new LinkedList<>();
		int data = 0;
		while (N-- > 0) {
			st = new StringTokenizer(br.readLine());

			String command = st.nextToken();

			switch (command) {
			case "push":
				q.offer(Integer.parseInt(st.nextToken()));
				break;

			case "pop":
				if(q.isEmpty()) System.out.println(-1);
				else System.out.println(q.poll());
				break;

			case "size":
				System.out.println(q.size());
				break;

			case "empty":
				if(q.isEmpty()) System.out.println(1);
				else System.out.println(0);
				break;

			case "front":
				if(q.isEmpty()) System.out.println(-1);
				else System.out.println(q.peek());
				break;

			case "back":
				if(q.isEmpty()) System.out.println(-1);
				else System.out.println(q.peekLast());
				break;
			}

		}

	}

}
