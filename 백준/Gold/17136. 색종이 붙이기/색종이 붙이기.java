import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main { // * 다시 풀어보기 *
	
	static int[] paper = {0, 5, 5, 5, 5, 5};
	static int[][] board;
	static int result = 26;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		board = new int[10][10];
		for(int i=0; i<10; i++)
			board[i] = Arrays.stream(br.readLine().split(" "))
						.mapToInt(Integer::parseInt)
						.toArray();
		
		solve(0, 0, 0);
		if(result == 26) System.out.println(-1);
		else System.out.println(result);
	}
	
	static void solve(int row, int column, int cnt) {
		// base case
		// 1. result의 값이 cnt보다 작거나 같을 경우 더 이상의 탐색은 불필요
		if(result <= cnt) return;
		// 2. 남은 칸들 중에 "1"이 존재하지 않을 경우 종료
		findNext(row);
		if(nextRow == -1 && nextColumn == -1) {
			result = cnt;
			return;
		}
		
		// recursive case
		int r = nextRow;
		int c = nextColumn;
		
		for(int size=1; size<=5; size++) {
			if(paper[size] == 0) continue;
			if(!isValid(r, c, size)) continue;
			
			paper[size]--;
			fill(r, c, size, 0);
			solve(r, c, cnt + 1);
			fill(r, c, size, 1);
			paper[size]++;
		}
	}
	
	static int nextRow;
	static int nextColumn;
	static void findNext(int row) {
		for(int i=row; i<10; i++) {
			for(int j=0; j<10; j++) {
				if(board[i][j] == 1) {
					nextRow = i;
					nextColumn = j;
					return;
				}
			}
		}
		nextRow = -1;
		nextColumn = -1;
	}
	
	static boolean isValid(int row, int column, int size) {
		if(row + size > 10 || column + size > 10) return false;
		for(int r=0; r<size; r++) {
			for(int c=0; c<size; c++) {
				if(board[row + r][column + c] == 0) return false;
			}
		}
		return true;
	}
	
	static void fill(int row, int column, int size, int color) {
		for(int r=0; r<size; r++) {
			for(int c=0; c<size; c++) {
				board[row+r][column+c] = color;
			}
		}
	}

}