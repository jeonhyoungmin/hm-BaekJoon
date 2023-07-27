import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		// 수열의 크기
		int N = Integer.parseInt(br.readLine());
		
		// BufferedReader을 공백을 기준으로 바로 parseInt 하기 위해 StringTokenizer 사용
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 수열의 원소를 갖는 배열 초기화
		int[] array = new int[N];
		for(int i = 0; i<N; i++) array[i] = Integer.parseInt(st.nextToken());
		
		Stack<Integer> stack = new Stack<>();
		
		for(int i = 0; i<array.length; i++) {
			while(!stack.isEmpty() && array[stack.peek()] < array[i]) {
				array[stack.pop()] = array[i];
			}
			stack.add(i);
		}
		
		while(!stack.isEmpty()) {
			array[stack.pop()] = -1;
		}
		
		for(int i : array) {
			sb.append(i).append(" ");
		}
		
		System.out.println(sb);
	}
}
