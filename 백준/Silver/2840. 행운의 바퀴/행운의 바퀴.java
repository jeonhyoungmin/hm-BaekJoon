import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		char[] circle = new char[N];
		Arrays.fill(circle, '?');
		int index = 0;
		for(int i=0; i<K; i++) {
			st = new StringTokenizer(br.readLine());
			int rotate = Integer.parseInt(st.nextToken());
			char alphabet = st.nextToken().charAt(0);
			
			index = (index + rotate) % N;
			
			if(circle[index] != '?' && circle[index] != alphabet) {
				System.out.println("!");
				return;
			}
			circle[index] = alphabet;
		}
		
		boolean[] isExist = new boolean[26];
		for(int i=0; i<N; i++) {
			if(circle[i] == '?') continue;
			else {
				if(isExist[circle[i] - 'A']) {
					System.out.println("!");
					return;
				}
				isExist[circle[i] - 'A'] = true;
			}
		}
		
		for (int i = 0; i < N; i++) {
			index = (index) % N;
			System.out.print(circle[index]);
			if (index == 0)
				index = circle.length;
			index--;
		}
		
	}
}