import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static class Score {
		
		int candidate;
		double src;
		
		public Score(int candidate, double src) {
			this.candidate = candidate;
			this.src = src;
		}
	}

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int X = Integer.parseInt(br.readLine());
		int N = Integer.parseInt(br.readLine());
		
		// 1. 5퍼센트 미만 제외
		// 최소 득표수를 넘은 후보자인지 저장
		// 해당 후보자가 받은 득표수 저장
		double cut = X * 0.05;
		boolean[] candidate = new boolean[26];
		int[] votes = new int[26];
		int count = 0;
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			char alphabet = st.nextToken().charAt(0);
			int getVotes = Integer.parseInt(st.nextToken());
			
			if(getVotes >= cut) {
				candidate[alphabet - 'A'] = true;
				votes[alphabet - 'A'] = getVotes;
				count++;
			}
		}
		
		
		// 2. 각 후보자들의 득표수를 14로 나눈다.
		// 최소 득표수를 넘은 후보자의 득표수만 14로 나눈다.
		Score[] scores = new Score[count * 14];
		int index = 0;
		for(int i=0; i<26; i++) {
			if(candidate[i]) {
				for(int j=1; j<=14; j++) {
					scores[index++] = new Score(i, (double)votes[i]/j); 
				}
			}
		}
		
		// 3. 나눈 득표수 중에서 상위 14개까지 칩을 하나씩 준다.
		Arrays.sort(scores, (o1, o2) -> (int)(o2.src - o1.src));
		int[] ans = new int[26];
		for(int i=0; i<14; i++) {
			ans[scores[i].candidate]++;
		}
		
		// 4. 후보자 오름차순으로 받은 칩을 출력한다.
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<26; i++) {
			if(candidate[i]) {
				sb.append((char)(i+'A') + " " + ans[i]).append("\n");
			}
		}
		
		System.out.println(sb.toString());
	}
}