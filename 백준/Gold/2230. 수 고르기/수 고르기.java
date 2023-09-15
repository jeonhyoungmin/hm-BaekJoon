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
		int M = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N];
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(arr);
		
		int rightIndex = 0;
		int ansDiff = arr[N-1] - arr[0];
		for(int i=0; i<N; i++) {
			while(arr[rightIndex] - arr[i] < M && rightIndex < N - 1) {
				rightIndex++;
			}
			
			int diff = arr[rightIndex] - arr[i];
			if(diff >= M) {
				ansDiff = Math.min(ansDiff, diff);
			}
		}
		
		System.out.println(ansDiff);
	}
}