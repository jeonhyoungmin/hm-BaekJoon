import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
	public static class Member{
		int age;
		String name;
		int idx;
		
		public Member() {}
		public Member(int age, String name, int idx) {
			this.age = age;
			this.name = name;
			this.idx = idx;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		Member[] member = new Member[N];
		for(int i = 0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			member[i] = new Member(Integer.parseInt(st.nextToken()), st.nextToken(), i);
		}
		
		Arrays.sort(member, new Comparator<Member>() {
			public int compare(Member m1, Member m2) {
				if(m1.age == m2.age)
					return m1.idx - m2.idx;
				return m1.age - m2.age;
			}
		});
		
		for(int i = 0; i<N; i++)
			System.out.println(member[i].age + " " + member[i].name);
	}
}