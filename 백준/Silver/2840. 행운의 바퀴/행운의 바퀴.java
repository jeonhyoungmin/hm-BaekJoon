import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		char[] circle = new char[N];
		int index = 0;
		for(int i=0; i<K; i++) {
			st = new StringTokenizer(br.readLine());
			int rotate = Integer.parseInt(st.nextToken());
			char alphabet = st.nextToken().charAt(0);
			
			index = (index + rotate) % N;
			
			if(circle[index] != 0 && circle[index] != alphabet) {
				System.out.println("!");
				return;
			}
			circle[index] = alphabet;
		}
		
		boolean[] isExist = new boolean[26];
		for(int i=0; i<N; i++) {
			if(circle[i] == 0) continue;
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
			if (circle[index] == 0)
				System.out.print("?");
			else
				System.out.print(circle[index]);
			if (index == 0)
				index = circle.length;
			index--;
		}
		
	}
}