import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int R;
	static int C;
	static char[][] map;

	// row
	static final int NORTH = -1;
	static final int SOUTH = 1;
	// column
	static final int WEST = -1;
	static final int EAST = 1;

	static boolean[] checkMap = new boolean[26];
	static int answer = 0;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		map = new char[R][C];
		for (int i = 0; i < R; i++)
			map[i] = br.readLine().toCharArray();

		recursion(0, 0, 0);
		System.out.println(answer);
	}

	static void recursion(int row, int column, int cnt) {
		// base case
		answer = Math.max(answer, cnt);
		if (row < 0 || column < 0 || row >= R || column >= C)
			return;

		char alphabet = map[row][column];
		if (checkMap[alphabet - 'A'] == true)
			return;
		checkMap[alphabet - 'A'] = true;
		
		// recursive case
		recursion(row + NORTH, column, cnt + 1);
		recursion(row + SOUTH, column, cnt + 1);
		recursion(row, column + WEST, cnt + 1);
		recursion(row, column + EAST, cnt + 1);
		checkMap[alphabet - 'A'] = false;

	}

}