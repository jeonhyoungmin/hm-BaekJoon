import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		List<Integer> list = new ArrayList<Integer>(N);
		for(int i=1; i<=N; i++) list.add(i);
		
		int[] ans = new int[N];
		int index = 0;
		for(int i=0; i<N; i++) {
			index = (index + K - 1) % list.size();
			ans[i] = list.remove(index);
		}
		
		System.out.print("<");
		for(int i=0; i<N; i++) {
			if(i>0) System.out.print(", ");
			System.out.print(ans[i]);
		}
		System.out.print(">");

	}

}
