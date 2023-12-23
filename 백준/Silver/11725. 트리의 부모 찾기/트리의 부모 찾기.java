import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	
	static List<Integer>[] list;
	static boolean[] isUsed;
	static int[] parent;
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		list = new ArrayList[N+1];
		isUsed = new boolean[N+1];
		parent = new int[N+1];
		
		for(int i=0; i<N+1; i++)
			list[i] = new ArrayList<>();
		
		StringTokenizer st;
		for(int i=0; i<N-1; i++) {
			st = new StringTokenizer(br.readLine());
			int nodeA = Integer.parseInt(st.nextToken());
			int nodeB = Integer.parseInt(st.nextToken());
			list[nodeA].add(nodeB);
			list[nodeB].add(nodeA); 
		}
		
		recursion(1);
		
		for(int i=2; i<=N; i++)
			System.out.println(parent[i]);
	}
	
	static void recursion(int node) {
		isUsed[node] = true;
		for(int i=0; i<list[node].size(); i++) {
			int child = list[node].get(i);
			if(!isUsed[child]) {
				parent[child] = node;
				recursion(child);
			}
		}
		
	}
	
}
