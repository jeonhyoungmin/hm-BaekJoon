import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main { // * 다시 풀어보기 *

	static int n;
	static boolean[] check;
	static Egg[] eggs;
	static int ans = 0;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());

		check = new boolean[n];
		eggs = new Egg[n];

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			eggs[i] = new Egg(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}

		recursion(0);
		System.out.println(ans);
	}

	static void recursion(int hand) {

		if (hand == n) {
			int cnt = 0;
			for (int i = 0; i < n; i++)
				if (eggs[i].durability <= 0)
					cnt++;
			ans = Math.max(ans, cnt);
			return;
		}
		
		if(eggs[hand].durability > 0) {
			boolean targetExist = false;
			for(int i=0; i<n; i++) {
				if(hand == i) continue;
				if(eggs[i].durability > 0) {
					targetExist = true;
					eggs[hand].fight(eggs[i]);
					recursion(hand + 1);
					eggs[hand].restore(eggs[i]);
				}
			}
			if(!targetExist) recursion(hand + 1);
		} else {
			recursion(hand + 1);
		}

	}

}

class Egg {

	int durability;
	int weight;

	public Egg(int durability, int weight) {
		this.durability = durability;
		this.weight = weight;
	}

	public void fight(Egg other) {
		this.durability -= other.weight;
		other.durability -= this.weight;
	}

	public void restore(Egg other) {
		this.durability += other.weight;
		other.durability += this.weight;
	}
}