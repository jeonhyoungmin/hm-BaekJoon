import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		char[][] map = new char[N][N];
		for (int i = 0; i < N; i++) {
			map[i] = sc.next().toCharArray();
		}

		// 1. 모든 인접한 사탕을 교환하기
		// 1-1. 증가하는 열만 교환
		// 1-2. 증가하는 행만 교환
		// 2. 교환 후 행과 열 중 가장 큰 값을 찾기
		// 3. 다음 교환을 위해 교환했던 사탕을 본래 위치로 복구
		// 1~3을 N의 크기만큼 반복

		int ans = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				// 증가하는 열만 교환
				if (j + 1 < N && map[i][j] != map[j][j + 1]) {
					swapCandy(map, i, j, i, j + 1);
					ans = Math.max(ans, Math.max(maxColumn(map), maxRow(map)));
					swapCandy(map, i, j, i, j + 1);
				}
				// 증가하는 행만 교환
				if (i + 1 < N && map[i][j] != map[i + 1][j]) {
					swapCandy(map, i, j, i + 1, j);
					ans = Math.max(ans, Math.max(maxColumn(map), maxRow(map)));
					swapCandy(map, i, j, i + 1, j);
				}
			}
		}
		System.out.println(ans);
	}
	
	// 사탕을 교체하는 메서드
	private static void swapCandy(char[][] map, int r1, int c1, int r2, int c2) {
		char temp = map[r1][c1];
		map[r1][c1] = map[r2][c2];
		map[r2][c2] = temp; 
	}
	
	// 열의 최대 길이를 구하는 메서드
	private static int maxColumn(char[][] map) {
		// 열을 고정하고 행을 돌면서 최대값 찾기
		int N = map.length;
		int maxColumn = 0;
		for(int c = 0; c<N; c++) {
			int len = 0;
			char currentChar = map[0][c];
			for(int r = 0; r<N; r++) {
				if(map[r][c] != currentChar) {
					currentChar = map[r][c]; 
					len = 1;
				} else {
					len++;
				}
				maxColumn = Math.max(maxColumn, len);
			}
		}
		return maxColumn;
	}
	
	// 행의 최대 길이를 구하는 메서드
	private static int maxRow(char[][] map) {
		// 행을 고정하고 열을 돌면서 최대값 찾기
		int N = map.length;
		int maxRow = 0;
		for(int r = 0; r<N; r++) {
			int len = 0;
			char currentChar = map[r][0];
			for(int c = 0; c<N; c++) {
				if(map[r][c] != currentChar) {
					currentChar = map[r][c]; 
					len = 1;
				} else {
					len++;
				}
				maxRow = Math.max(maxRow, len);
			}
		}
		return maxRow;
	}

}
