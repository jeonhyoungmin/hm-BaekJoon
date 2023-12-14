import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()); 
		int N = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());
		
		List<Deque<Integer>> line = new ArrayList<>(7);
		for(int i=0; i<7; i++) line.add(new ArrayDeque<>());

		int count = 0;
		while(N-->0) {
			
			st = new StringTokenizer(br.readLine());
			int lineNumber = Integer.parseInt(st.nextToken());
			int fret = Integer.parseInt(st.nextToken());
			
			Deque<Integer> currentLine = line.get(lineNumber);
			
			if(currentLine.isEmpty() || fret > currentLine.peekLast()) {
				currentLine.offerLast(fret);
				count++;
			}
			else if(fret < currentLine.peekLast()) {
				while(!currentLine.isEmpty() && currentLine.peekLast() > fret) {
					currentLine.pollLast();
					count++;
				}
				if(currentLine.isEmpty() || currentLine.peekLast() != fret) {
					currentLine.offerLast(fret);
					count++;
				}
			}
		}

		System.out.println(count);

	}

}
