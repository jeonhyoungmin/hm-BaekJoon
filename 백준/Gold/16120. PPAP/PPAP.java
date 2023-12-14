import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] line = br.readLine().toCharArray();
		char[] stack = new char[line.length];
		int topIndex = 0;
		
		for(char ch : line) {
			stack[topIndex++] = ch;
			if(topIndex >= 4 && stack[topIndex - 1] == 'P' && stack[topIndex - 2] == 'A' 
					&& stack[topIndex - 3] == 'P' && stack[topIndex - 4] == 'P') {
				topIndex -= 3;
			}
		}
		
		System.out.println(topIndex == 1 && stack[0] == 'P' ? "PPAP" : "NP");
	}

}
