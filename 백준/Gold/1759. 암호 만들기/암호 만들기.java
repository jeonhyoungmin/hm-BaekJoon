import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

	static int L;
	static int C;
	static char[] arr;
	static int index = 0;
	static Map<Character, Integer> map = new HashMap<>();
	static int vowelCount = 0;
	static char[] output;
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map.put('a', 1);
		map.put('e', 1);
		map.put('i', 1);
		map.put('o', 1);
		map.put('u', 1);
		output = new char[L];
		arr = br.readLine().replaceAll(" ", "").toCharArray();
		Arrays.sort(arr);
		
		recursion(0);
	}

	static void recursion(int start) {
		if(index == L) {
			if(vowelCount >= 1 && L - vowelCount >= 2) {
				System.out.println(output);
			}
			return;
		}
		
		for(int i=start; i<C; i++) {
			char ch = arr[i];
			output[index++] = ch;
			vowelCount += map.getOrDefault(ch, 0);
			recursion(i + 1);
			index--;
			vowelCount -= map.getOrDefault(ch, 0);
		}
		
	}

}
