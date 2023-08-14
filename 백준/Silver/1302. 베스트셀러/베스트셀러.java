import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		Map<String, Integer> map = new TreeMap<>();
		for(int i = 0; i<N; i++) {
			String book = br.readLine();
			if(map.containsKey(book)) map.put(book, map.get(book) + 1);
			else map.put(book, 1);
		}
		
		Set<String> set = map.keySet();
		String[] books = set.toArray(new String[set.size()]);
		Arrays.sort(books, (b1, b2) -> {
			return map.get(b2) - map.get(b1);
		});
		
		System.out.println(books[0]);
	}
}