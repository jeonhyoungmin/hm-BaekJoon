import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int result = recursion(N);
		System.out.println(result);
	}
	
	static int[] cache = new int[46];
	static int recursion(int N) {
		if(N == 1 || N == 2) return 1;
		if(cache[N] != 0) return cache[N];
		
		cache[N] = recursion(N-1) + recursion(N-2);
		return cache[N];
	}

}
