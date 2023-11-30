import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		Queue<Integer> q = new LinkedList<>();
		int data = Integer.parseInt(br.readLine());
		
		while(data != -1) {
			if(data > 0) {
				q.add(data);
			} else {
				q.poll();
			}
			data = Integer.parseInt(br.readLine());
		}
		
		StringBuilder sb = new StringBuilder();
		
		while(!q.isEmpty()) {
			sb.append(q.poll() + " ");
		}
		
		System.out.println(sb);
	}
}