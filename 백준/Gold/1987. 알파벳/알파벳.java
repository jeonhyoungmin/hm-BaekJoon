import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main { // * 비트 마스크 사용해서 다시 풀어보기 *

	static int R;
	static int C;
	static int[][] map;
	static boolean[] checkMap = new boolean[26];

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		map = new int[R][C];
		visited = new int[R][C];
		for (int i = 0; i < R; i++) {
			String line = br.readLine();
			for(int j=0; j < C; j++ ) {
				map[i][j] = line.charAt(j) - 'A';
			}
		}
		
		visited[0][0] = 1 << map[0][0];
		checkMap[map[0][0]] = true;
		System.out.println(recursion(0, 0));
	}

	static int[] dr = {-1, 0, 1, 0}; // direction row
	static int[] dc = {0, 1, 0 , -1}; // direction column
	static int[][] visited;
	static int recursion(int row, int column) {
		int result = 0;
		
		for(int i=0; i<4; i++) {
			int nr = row + dr[i], nc = column + dc[i];
			if(boundCheck(nr, nc)) continue;
			int next = map[nr][nc];
			if(checkMap[next]) continue;
			int route = 1 << next;
			if(visited[nr][nc] == (visited[row][column] | route)) continue;
			
			visited[nr][nc] = visited[row][column] | route;
			checkMap[next] = true;
			int nResult = recursion(nr, nc);
			result = Math.max(result, nResult);
			checkMap[next] = false;
		}

		return result + 1;
	}
	
	static boolean boundCheck(int row, int column) {
		return row < 0 || column < 0 || row >= R || column >= C;
	}

}