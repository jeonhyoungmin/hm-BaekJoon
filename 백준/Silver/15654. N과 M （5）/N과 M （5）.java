import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		List<Integer> list = new LinkedList<>();
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
			list.add(Integer.parseInt(st.nextToken()));
		Collections.sort(list);

		recursion(list, M);
	}

	static List<Integer> sentence = new LinkedList<>();

	static void recursion(List<Integer> list, int M) {
		if (sentence.size() == M) {
			StringBuilder sb = new StringBuilder();
			for (int word : sentence)
				sb.append(word + " ");
			System.out.println(sb);
		}

		for (int i = 0; i < list.size(); i++) {
			sentence.add(list.get(i));
			List<Integer> tempList = new LinkedList<>();
			tempList.addAll(list);
			tempList.remove(i);
			recursion(tempList, M);
			sentence.remove(sentence.size() - 1);
		}
	}

}
