import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main {
	
	static int N;
	static int M;
	static int[] arr;
	static boolean[] isUsed;
	static int[] sentence;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		isUsed = new boolean[N];
		sentence = new int[M];
		
		arr = Arrays.stream(br.readLine().split(" "))
				.mapToInt(Integer::parseInt)
				.toArray();
		Arrays.sort(arr);
		
		recursion(0);
	}

	static void recursion(int depth) {
		if(depth == M) {
			System.out.println(Arrays
					.stream(sentence)
					.mapToObj(String::valueOf)
					.collect(Collectors.joining(" "))
					);
			return;
		}
		
		for(int i=0; i<N; i++) {
			if(!isUsed[i]) {
				isUsed[i] = true;
				sentence[depth] = arr[i];
				recursion(depth + 1);
				isUsed[i] = false;
			}
		}
		
	}

}
