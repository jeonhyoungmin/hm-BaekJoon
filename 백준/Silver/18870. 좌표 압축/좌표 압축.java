import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[] arr = new int[N];
		Set<Integer> set = new TreeSet<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i<N; i++) {
			int data = Integer.parseInt(st.nextToken());
			arr[i] = data;
			set.add(data);
		}
		
		Map<Integer, Integer> map = new HashMap<>();
		int idx = 0;
		for(int i : set) {
			map.put(i, idx);
			idx++;
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i<N; i++)
			sb.append(map.get(arr[i])).append(" ");
		
		System.out.println(sb);
	}
}