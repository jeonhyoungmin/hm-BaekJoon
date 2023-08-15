import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static class Meeting {
		int start;
		int end;
		Meeting(int start, int end){
			this.start = start;
			this.end = end;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Meeting[] meetings = new Meeting[N];
		for(int i = 0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			meetings[i] = new Meeting(start, end);
		}
		
		Arrays.sort(meetings, (o1, o2) -> {
			if(o1.end == o2.end)
				return o1.start - o2.start;
			return o1.end - o2.end;
		});
		
		int count = 1;
		int meeting = meetings[0].end;
		for(int i = 1; i<meetings.length; i++) {
			if(meeting <= meetings[i].start) {
				count++;
				meeting = meetings[i].end;
			}
		}
		
		System.out.println(count);
	}
}