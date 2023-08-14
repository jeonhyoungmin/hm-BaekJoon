import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		Map<String, Integer> books = new HashMap<>();
		for(int i = 0; i<N; i++) {
			String book = br.readLine();
			books.put(book, books.getOrDefault(book, 0) + 1);
		}

		String topTitle = "";
		int maxCount = 0;
		for(Map.Entry<String, Integer> book : books.entrySet()) {
			String title = book.getKey();
			int count = book.getValue();
			if(count > maxCount || (count == maxCount && title.compareTo(topTitle)<0)) {
				maxCount = count;
				topTitle = title;
			}
		}
		
		System.out.println(topTitle);
		
	}
}