import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	public class Member implements Comparable<Member>{
		int age;
		String name;
		
		public Member() {}
		public Member(int age, String name) {
			this.age = age;
			this.name = name;
		}
		
		@Override
		public int compareTo(Member m) {
			return this.age - m.age;
		}
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		Main main = new Main();
		Member[] member = new Member[N];
		for(int i = 0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			member[i] = main.new Member(Integer.parseInt(st.nextToken()), st.nextToken());
		}
		
		Arrays.sort(member);
		
		for(int i = 0; i<N; i++)
			System.out.println(member[i].age + " " + member[i].name);
	}
}