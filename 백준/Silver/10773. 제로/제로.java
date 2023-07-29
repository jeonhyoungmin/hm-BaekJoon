import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws IOException{
		
		// K 1~100,000
		// 주어진 값 1~1,000,000
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int K = Integer.parseInt(br.readLine());
		Stack<Integer> stack = new Stack<>();
		
		int data = 0;
		while(K-- > 0) {
			data = Integer.parseInt(br.readLine());
			// 주어지는 값이 0이면 직전 내용물 제거
			// 0은 stack이 빈 상태로는 들어오지 않는다
			if(data == 0) {
				stack.pop();
				continue;
			}
			stack.push(data);
		}
		
		int ans = 0;
		for(int i : stack) ans += i;
		
		System.out.println(ans);

	}

}
