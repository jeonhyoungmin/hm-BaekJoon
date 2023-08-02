import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); // 트럭의 수
		int W = Integer.parseInt(st.nextToken()); // 다리의 길이
		int L = Integer.parseInt(st.nextToken()); // 다리의 최대 하중
		
		st = new StringTokenizer(br.readLine());
		
		// truck 무게를 담은 truck Queue 생성
		LinkedList<Integer> truck = new LinkedList<>();
		for(int i = 0; i<N; i++) truck.offer(Integer.parseInt(st.nextToken()));
		
		// Queue bridge에 W만큼 0을 추가
		LinkedList<Integer> bridge = new LinkedList<>(); 
		for(int i=0; i<W; i++) bridge.offer(0);
		
		int truckOnBridge = 0; // 다리 위 트럭의 무게 총합
		int time = 0;
		
		while(!bridge.isEmpty()) {
			
			int outTruck = bridge.poll(); // 빠져나가는 트럭의 무게
			truckOnBridge -= outTruck;
			time ++;
			
			if(!truck.isEmpty()) { // 남은 트럭이 있다면
				int newTruck = truck.peek();
				
				if(truckOnBridge + newTruck > L) { // 최대 하중을 넘기면
					bridge.offer(0);
				} else { // 최대 하중을 넘기지 않으면
					bridge.offer(truck.poll());
					truckOnBridge += newTruck;
				}
		
			}
			
			// 남은 트럭이 없다면 offer 중지, pop만 진행
					
		}
		
		System.out.println(time);
	}

}
