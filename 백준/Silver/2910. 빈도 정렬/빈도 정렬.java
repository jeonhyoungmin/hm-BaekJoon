import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		Map<Integer, Integer> map = new HashMap<>();
		List<Integer> al = new ArrayList<>();
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i<N; i++) {
			int data = Integer.parseInt(st.nextToken());
			map.put(data, map.getOrDefault(data, 0) + 1);
			if(!al.contains(data)) al.add(data);
		}
		
		int[][] ans = new int[al.size()][2];
		// 입력 값, 중복 횟수
		for(int i = 0; i<al.size(); i++) {
			ans[i][0] = al.get(i);
			ans[i][1] = map.get(al.get(i));
		}
		
		Arrays.sort(ans, (o1, o2) -> o2[1] - o1[1]);
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for(int[] i : ans)
			while(i[1]-- >0) bw.write(i[0] + " ");
		
		bw.flush();
	}
}