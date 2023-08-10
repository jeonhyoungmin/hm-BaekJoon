import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	private static int leftIndex = 0;
	private static int rightIndex = 0;
	
	private static int isExist(int[] arr, int target) {
		int l = 0, r = arr.length - 1;
		while(l <= r) {
			int m = l + ((r-l)/2);
			if(arr[m] > target) r = m - 1;
			else if(arr[m] < target) l = m + 1;
			else {
				leftIndex = m;
				rightIndex = m;
				
				findLeftIndex(arr, l, m-1, target);
				findRightIndex(arr, m+1, r, target);
				
				return rightIndex - leftIndex + 1;
			}
		}
		
		return 0;
	}
	
	private static void findLeftIndex(int[] arr, int fromIndex, int toIndex, int target) {
		int l = fromIndex, r = toIndex;
		while(l <= r) {
			int m = l + ((r-l)/2);
			if(arr[m] > target) r = m - 1;
			else if(arr[m] < target) l = m + 1;
			else {
				leftIndex = m;
				findLeftIndex(arr, l, m-1, target);
				return;
			}
		}
	}
	
	private static void findRightIndex(int[] arr, int fromIndex, int toIndex, int target) {
		int l = fromIndex, r = toIndex;
		while(l <= r) {
			int m = l + ((r-l)/2);
			if(arr[m] > target) r = m - 1;
			else if(arr[m] < target) l = m + 1;
			else {
				rightIndex = m;
				findRightIndex(arr, m+1, r, target);
				return;
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[N];
		for(int i = 0; i<N; i++) arr[i] = Integer.parseInt(st.nextToken());
		Arrays.sort(arr);
		
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());

		for(int i = 0; i<M; i++) {
			int target = Integer.parseInt(st.nextToken());
			int count = isExist(arr, target);
			sb.append(count).append(" ");
		}
		
		System.out.println(sb);
	}

}
