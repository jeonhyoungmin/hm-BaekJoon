import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Stream;

public class Main {
	
	static int[][] direction = { {-1,0}, {1,0}, {0,-1}, {0,1} }; // 왼 오 아 위

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[][] map = new int[N][N];
		boolean[][] visited = new boolean[N][N];
		for(int i = 0; i<N; i++) {
			int[] arr = Stream.of(br.readLine().split("")) // Stream<String>
					.mapToInt(Integer::parseInt)           // IntStream
					.toArray();
			map[i] = arr;
		}
		
//		위와 동일
//		for(int i = 0; i<N; i++) {
//			String s = br.readLine();
//			for(int j = 0; j<N; j++) {
//				map[i][j] = s.charAt(j) - '0';
//			}
//		}
		
		List<Integer> result = new ArrayList<>();
		for(int i = 0; i<N; i++) {
			for(int j = 0; j<N; j++) {
				if(map[i][j] == 1 && !visited[i][j]) {
					result.add(bfs(N, map, visited, i, j));
				}
			}
		}
		
		System.out.println(result.size());
		Collections.sort(result);
		result.forEach(System.out::println);
	}
	
	private static int bfs(int N, int[][] map, boolean[][] visited, int x, int y) {
		int size = 1;
		
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {x, y});
		visited[x][y] = true;
		
		while(!queue.isEmpty()) {
			int[] coordinate = queue.poll();
			
			for(int i = 0; i<direction.length; i++) {
				int nX = coordinate[0] + direction[i][0];
				int nY = coordinate[1] + direction[i][1];
				
				if(nX >= 0 && nY >= 0 && nX < N && nY < N &&
						map[nX][nY] == 1 && !visited[nX][nY]) {
					size++;
					visited[nX][nY] = true;
					queue.add(new int[] {nX, nY});
				}
			}
		}
		return size;
	}
}