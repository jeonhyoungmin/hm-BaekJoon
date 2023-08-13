import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static class Member implements Comparable<Member>{
		String name;
		String condition;
		
		public Member(String name, String condition) {
			this.name = name;
			this.condition = condition;
		}
		
		@Override
		public int compareTo(Member m) {
			return m.name.compareTo(this.name);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		Member[] member = new Member[N];
		for(int i = 0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			member[i] = new Member(st.nextToken(), st.nextToken());
		}
		
		Arrays.sort(member);
		
		int count = 1;
		String name = member[0].name;
		for(int i = 1; i<N; i++) {
			if(name.equals(member[i].name)) {
				count++;
			} else {
				if(count % 2 == 0) {
					name = member[i].name;
					count = 1;
				} else {
					System.out.println(name);
					name = member[i].name;
					count = 1;
				}
			}
		}
		if(count % 2 != 0) System.out.println(name);
		
	}
}