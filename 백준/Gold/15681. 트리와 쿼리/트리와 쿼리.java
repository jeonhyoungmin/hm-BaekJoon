import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	
	static List<ArrayList<Integer>> tree;
	static boolean[] check;
	static int[] size;
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		int Q = Integer.parseInt(st.nextToken());
		
		tree = new ArrayList<ArrayList<Integer>>();
		check = new boolean[N+1];
		size = new int[N+1];
		
		for(int i=0; i<N+1; i++)
			tree.add(new ArrayList<Integer>());
		
		for(int i=0; i<N-1; i++) {
			st = new StringTokenizer(br.readLine());
			int nodeA = Integer.parseInt(st.nextToken());
			int nodeB = Integer.parseInt(st.nextToken());
			tree.get(nodeA).add(nodeB);
			tree.get(nodeB).add(nodeA);	
		}
		
		makeTree(R);
		
		for(int i=0; i<Q; i++) {
			int q = Integer.parseInt(br.readLine());
			System.out.println(size[q]);
		}
		
	}
	
	static void makeTree(int node) {
		check[node] = true;
		size[node] = 1;
		for(int i=0; i<tree.get(node).size(); i++) {
			int child = tree.get(node).get(i);
			if(!check[child]) {
				makeTree(child);
				size[node] += size[child];
			}
		}
	}
	
}
