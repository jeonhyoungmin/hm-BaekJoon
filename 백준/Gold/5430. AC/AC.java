import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		while(T-->0) {
			
			char[] p = br.readLine().toCharArray();
			int n = Integer.parseInt(br.readLine());
//			String inputValueString = br.readLine();
//			String[] values = inputValueString
//					.substring(1, inputValueString.length()-1)
//					.split(",");
			StringTokenizer st = new StringTokenizer(br.readLine(), "[,]");
			
			Deque<String> deq = new ArrayDeque<String>();
			for(int i=0; i<n; i++) 
//				deq.offer(values[i]);
				deq.offer(st.nextToken());
			
			int pLength = p.length;
			boolean rSwitch = false;
			boolean errorChk = false;
			for(int i=0; i<pLength; i++) {
				if(p[i] == 'R') rSwitch = !rSwitch;
				if(p[i] == 'D') {
					
					if(deq.isEmpty()) {
						System.out.println("error");
						errorChk = !errorChk;
						break;
					} else {
						
						if(rSwitch) deq.pollLast();
						else deq.pollFirst();
						
					}
					
				}
			}
			
			if(!errorChk) {
				StringBuilder sb = new StringBuilder();
				sb.append("[");
				while(!deq.isEmpty()) {
					
					if(rSwitch) {
						sb.append(deq.pollLast());
					} else {
						sb.append(deq.pollFirst());
					}
					
					if(!deq.isEmpty()) sb.append(",");
					
				}
				
				sb.append("]");
				System.out.println(sb);
			}
			
		}
		
	}

}
