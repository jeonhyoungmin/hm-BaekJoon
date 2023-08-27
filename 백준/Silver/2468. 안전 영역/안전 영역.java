import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

	static int[][] direction = { { 1, 0 }, { -1, 0 }, { 0, -1 }, { 0, 1 } }; // 오왼아위

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int maxHeight = 0;
		int[][] map = new int[N][N];
		for (int i = 0; i < N; i++) {
			String[] rl = br.readLine().split(" ");
			for (int j = 0; j < N; j++) {
				int v = Integer.parseInt(rl[j]);
				map[i][j] = v;
				maxHeight = Math.max(maxHeight, v);
			}
		}

		int result = 1;
		for (int limit = 1; limit <= maxHeight; limit++) {
			boolean[][] visited = new boolean[N][N];
			int count = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] > limit && !visited[i][j]) {
						count++;
						bfs(N, map, visited, i, j, limit);
						result = Math.max(result, count);
					}
				}
			}
		}
		System.out.println(result);
	}

	private static void bfs(int N, int[][] map, boolean[][] visited, int x, int y, int limit) {
		visited[x][y] = true;
		Queue<int[]> queue = new LinkedList<int[]>();
		queue.add(new int[] {x, y});
		
		while(!queue.isEmpty()) {
			int[] q = queue.poll();
			for(int i = 0; i<4; i++) {
				int nX = q[0] + direction[i][0];
				int nY = q[1] + direction[i][1];
				
				if(nX >= 0 && nY >= 0 && nX < N && nY < N
						&& map[nX][nY] > limit && !visited[nX][nY]) {
					visited[nX][nY] = true;
					queue.add(new int[] {nX, nY});
				}
			}
		}
	}

}