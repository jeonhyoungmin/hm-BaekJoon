import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main { // * 다시 풀어보기 *

	static int n;
	static char[] input;
	static int[] check = new int[101];
	static List<Integer> output = new ArrayList<>();

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		input = br.readLine().toCharArray();
		n = input.length > 9 ? (input.length - 9) / 2 + 9 : input.length;
		solve(0);
	}

	static void solve(int index) {
		// base case
		if (index == input.length) {
			StringBuilder sb = new StringBuilder();
			for (Integer value : output)
				sb.append(value + " ");
			System.out.println(sb);
			System.exit(0);
		}

		// recursive case
		int num1 = alter(input, index, 1);
		if (num1 <= n && check[num1] == 0) {
			check[num1] = 1;
			output.add(num1);
			solve(index + 1);
			output.remove(output.size() - 1);
			check[num1] = 0;
		}
		if (index + 1 >= input.length)
			return;
		int num2 = alter(input, index, 2);
		if (num2 <= n && check[num2] == 0) {
			check[num2] = 1;
			output.add(num2);
			solve(index + 2);
			output.remove(output.size() - 1);
			check[num2] = 0;
		}

	}

	static int alter(char[] input, int start, int length) {
		int result = 0;
		for (int i = start; i < start + length; i++) {
			result *= 10;
			result += input[i] - '0';
		}
		return result;
	}

}