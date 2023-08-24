import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public class Main {
	
	static int[][] direction = { {-1,0}, {1,0}, {0,-1}, {0,1} }; // 왼 오 아 위
	static int size = 0;

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
					size = 1;
					dfs(N, map, visited, i, j);
					result.add(size);
				}
			}
		}
		
		System.out.println(result.size());
		Collections.sort(result);
		result.forEach(System.out::println);
	}
	
	private static void dfs(int N, int[][] map, boolean[][] visited, int x, int y) {
		visited[x][y] = true;
		
		for(int i = 0; i<direction.length; i++) {
			int nX = x + direction[i][0];
			int nY = y + direction[i][1];
			
			if(nX >= 0 && nY >= 0 && nX < N && nY < N &&
					map[nX][nY] == 1 && !visited[nX][nY]) {
				size++;
				dfs(N, map, visited, nX, nY);
			}
		}
	}
}