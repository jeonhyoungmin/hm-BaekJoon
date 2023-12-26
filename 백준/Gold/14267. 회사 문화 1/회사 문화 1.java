import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static List<Integer>[] tree;
	static int[] parents;
	static int[] praise;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		tree = new ArrayList[N + 1];
		parents = new int[N + 1];
		praise = new int[N + 1];

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			tree[i] = new ArrayList<>();
			parents[i] = Integer.parseInt(st.nextToken());
			if (parents[i] == -1)
				continue;
			tree[parents[i]].add(i);
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int node = Integer.parseInt(st.nextToken());
			int point = Integer.parseInt(st.nextToken());
			praise[node] += point; // N <= M 범위. 중복 가능. += 연산
		}
		
		recursion(1);
		
		for(int i=1; i<=N; i++)
			System.out.print(praise[i] + " ");

	}

	static void recursion(int node) {
		for(int i=0; i<tree[node].size(); i++) {
			int child = tree[node].get(i);
			praise[child] += praise[node];
			recursion(child); 
		}
	}

}
