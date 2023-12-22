import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main {
	
	static int N;
	static int M;
	static int[] sentence;
	static int[] arr;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		sentence = new int[M];
		
		arr = Arrays.stream(br.readLine().split(" "))
				.mapToInt(Integer::parseInt)
				.toArray();
		Arrays.sort(arr);
		
		recursion(0, 0);
		System.out.println(sb);
	}
	
	static StringBuilder sb = new StringBuilder();
	static void recursion(int depth, int start) {
		if(depth == M) {
			sb.append(Arrays
					.stream(sentence)
					.mapToObj(String::valueOf)
					.collect(Collectors.joining(" "))
					);
			sb.append("\n");
			return;
		}
		
		for(int i=start; i<N; i++) {
				sentence[depth] = arr[i];
				recursion(depth + 1, i);
		}
		
	}

}
