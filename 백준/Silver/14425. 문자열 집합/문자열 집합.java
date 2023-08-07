import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	private static int binarySearch(String[] arr, String target) {
		
		int l = 0;
		int r = arr.length -1;
		int m = 0;
		
		while(l<=r) {
			m = l + ((r-l)/2);
			int compare = arr[m].compareTo(target);
			if(compare > 0) r = m-1; // target보다 큰 경우
			else if(compare < 0) l = m+1; // target보다 작은 경우
			else return 1; // target과 동일한 경우
		}
		return 0;
	}

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		String[] array = new String[N];
		for(int i = 0; i<N; i++) array[i] = br.readLine();
		Arrays.sort(array);
		
		int count = 0;
		for(int i = 0; i<M; i++) count += binarySearch(array, br.readLine());
		
		System.out.println(count);
	}

}
