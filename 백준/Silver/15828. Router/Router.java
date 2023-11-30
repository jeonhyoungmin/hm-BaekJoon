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
		int size = 0;
		
		while(data != -1) {
			if(data > 0) {
				if(size != N) {
					q.add(data);
					size++;					
				}
			} else {
				if(!q.isEmpty()) {
					q.poll();	
					size--;
				}
			}
			data = Integer.parseInt(br.readLine());
		}
		
		StringBuilder sb = new StringBuilder();
		
		if(q.isEmpty()) sb.append("empty");
		while(!q.isEmpty()) {
			sb.append(q.poll() + " ");
		}
		
		System.out.println(sb);
	}
}