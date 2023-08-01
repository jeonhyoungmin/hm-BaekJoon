import java.util.LinkedList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// testCase의 수 T
		// N개의 문서, M 번째 위치
		
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		while (T-- > 0) {
			int N = sc.nextInt(); // 문서의 개수
			int M = sc.nextInt(); // 몇 번째 출력인지 알고 싶은 문서의 위치(0부터 시작)

			// LinkedList로 Queue 구현
			LinkedList<Integer> lq = new LinkedList<>();

			// Queue에 중요도 저장
			for (int i = 0; i < N; i++)
				lq.offer(sc.nextInt());

			int count = 0; // 몇 번째 출력인지 체크

			while (!lq.isEmpty()) {
				int beforeSize = lq.size();
				int compare = lq.poll(); // 가장 앞에 있는 문서의 우선 순위
				for (int i = 0; i < lq.size(); i++) {
					// compare보다 큰 값이 하나라도 있을 경우, compare의 값을 맨 뒤로 보내기
					if (lq.get(i) > compare ) {
						lq.offer(compare);
						
						// M의 위치가 변경된다.
						if(M == 0) {
							M = lq.size() - 1;
						} else {
							M--;
						}
						
						break;
					}
				}
				// compare보다 큰 값이 하나도 없을 경우, count++
				if(beforeSize != lq.size()) {
					count++;
					
					// M의 위치가 변경된다.
					if(M == 0) {
						break;
					} else {
						M--;
					}
					
				}
			}

			System.out.println(count);
		}

	}

}
