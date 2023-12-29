import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	
	static int n;
	static boolean[] visited;
	static int[][] cost;
	static int minCost = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		visited = new boolean[n];
		cost = new int[n][n];
		for(int i=0; i<n; i++)
			cost[i] = Arrays.stream(br.readLine().split(" "))
			.mapToInt(Integer::parseInt)
			.toArray();
		
		for(int i=0; i<n; i++) {
			recursion(i, i, 0, 0);
		}
		
		System.out.println(minCost);
		
	}

	static void recursion(int node, int start, int sum, int count) {
		
		if(count == n && node == start) {
			minCost = Math.min(minCost, sum);
			return;
		}
		
		for(int i=0; i<n; i++) {
			if(!visited[i] && cost[node][i] != 0) {
				visited[i] = true;
				recursion(i, start, sum + cost[node][i], count + 1);
				visited[i] = false;
			}
		}
		
	}

}
