import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		String command = sc.hasNext() ? sc.next() : "";
		
		boolean[][] vertical = new boolean[N][N];
		boolean[][] horizantal = new boolean[N][N];
		
		int row = 0, column = 0;
		for(int i=0; i<command.length(); i++) {
			char cmd = command.charAt(i);
			if(cmd == 'D') {
				if(row == N - 1) continue;
				vertical[row][column] = vertical[row+1][column] = true;
				row++;
			} else if(cmd == 'U') {
				if(row == 0) continue;
				vertical[row][column] = vertical[row-1][column] = true;
				row--;
			} else if(cmd == 'L') {
				if(column == 0) continue;
				horizantal[row][column] = horizantal[row][column-1] = true;
				column--;
			} else {
				if(column == N - 1) continue;
				horizantal[row][column] = horizantal[row][column+1] = true;
				column++;
			}
		}
		
		for(int i=0; i<N; i++) {
			StringBuilder sb = new StringBuilder();
			for(int j=0; j<N; j++) {
				if(vertical[i][j] && horizantal[i][j]) sb.append("+");
				else if(vertical[i][j]) sb.append("|");
				else if(horizantal[i][j]) sb.append("-");
				else sb.append(".");
			}
			System.out.println(sb.toString());
		}
	}
}