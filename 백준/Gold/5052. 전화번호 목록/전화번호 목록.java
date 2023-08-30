import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

	static class Trie {
		Trie[] node;
		boolean isEnd;

		Trie() {
			this.node = new Trie[10];
			this.isEnd = false;
		}

		public void add(String s) {
			if (s.length() == 0)
				return;

			Trie[] nodes = this.node;
			Trie curr = null;
			for (char c : s.toCharArray()) {
				int num = c - '0';
				if (nodes[num] == null) {
					nodes[num] = new Trie();
				}
				curr = nodes[num];
				nodes = nodes[num].node;
			}
			curr.isEnd = true;
		}

		public boolean check(String s) {
			Trie[] nodes = this.node;
			Trie curr = null;
			for (int i = 0; i < s.length(); i++) {
				int n = s.charAt(i) - '0';
				curr = nodes[n];
				if (curr.isEnd && i < s.length() - 1) {
					return false; // 일관성이 없는 경우
				}
				nodes = curr.node;
			}
			return true;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {
			int N = Integer.parseInt(br.readLine());

			List<String> numbers = new ArrayList<>();
			for (int j = 0; j < N; j++) {
				numbers.add(br.readLine());
			}

			Trie root = new Trie();
			numbers.forEach(number -> root.add(number));

			boolean check = true;
			for (String number : numbers) {
				if (!root.check(number)) {
					check = false;
					break;
				}
			}

			if (!check) {
				System.out.println("NO");
			} else {
				System.out.println("YES");
			}
		}
	}
}
