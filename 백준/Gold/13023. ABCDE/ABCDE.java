import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	
	static boolean found = false;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		List<List<Integer>> map = new ArrayList<>();
		for(int i = 0; i<N; i++) map.add(i, new ArrayList<>());
		
		for(int i = 0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			// 친구 관계는 양방향
			map.get(a).add(b);
			map.get(b).add(a);
		}
		
		boolean[] visited = new boolean[N];
		for(int i = 0; i<N; i++) {
			dfs(map, visited, i, 1);
			
			if(found) {
				System.out.println(1);
				return;
			}
		}
		System.out.println(0);
	}
	
	private static void dfs(List<List<Integer>> map, boolean[] visited, int i, int depth) {
		if(depth == 5) {
			found = true;
			return;
		}
		
		visited[i] = true;
		for(int node : map.get(i)) {
			if(!visited[node]) {
				dfs(map, visited, node, depth + 1);
			}
		}
		
		// 다음 탐색을 위해 방문했던 node visited를 false 초기화
		visited[i] = false;
	}
}