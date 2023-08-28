import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[][] arr = new int[N][2];
		for(int i = 0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr, (o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o1[0] - o2[0]);

//		위와 동일
//		Arrays.sort(arr, new Comparator<int[]>() {
//			public int compare(int[] o1,int[] o2) {
//				return o1[0] == o2[0] ? o1[1] - o2[1] : o1[0] - o2[0];
//			}
//		});
		
		PriorityQueue<Integer> rooms = new PriorityQueue<>();
		rooms.offer(arr[0][1]);
		for(int i = 1; i<N; i++) {
			int[] lecture = arr[i];
			
			if(lecture[0] < rooms.peek()) {
				rooms.add(lecture[1]);
			} else {
				rooms.poll();
				rooms.offer(lecture[1]);
			}
		}
		
		System.out.println(rooms.size());
	}
	
}
