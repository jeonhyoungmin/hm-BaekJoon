import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[] arr;
	static int value;
	static int count;
	static int N;
	static int S;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());

		arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(st.nextToken());

		recursion(0);
		System.out.println(count);
	}

	static void recursion(int start) {
		for(int i=start; i<arr.length; i++) {
			value += arr[i];
			if(value == S) {
				count++;
			}
			recursion(i + 1);
			value -= arr[i];
		}
	}

}
