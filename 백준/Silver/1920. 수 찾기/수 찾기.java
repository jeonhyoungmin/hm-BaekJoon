import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		// M개의 수들이 N개의 수 중에 존재하는지 확인
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		Set<Integer> hs = new HashSet<>();
		for(int i = 0; i<N; i++) {
			hs.add(Integer.parseInt(st.nextToken()));
		}
		
		int M = Integer.parseInt(br.readLine());
				
		StringBuilder sb = new StringBuilder();
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i<M; i++) {
			int m = Integer.parseInt(st.nextToken());
			
			if(hs.contains(m)) {
				sb.append(1).append("\n");
			} else {
				sb.append(0).append("\n");
			}
		}
		
		System.out.println(sb);
	}
}
