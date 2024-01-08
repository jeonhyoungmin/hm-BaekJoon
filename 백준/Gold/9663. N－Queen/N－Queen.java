import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    /*
     * *** 다시 풀어보기 ***
     * 별(*) 개수 : 도움 받은 정도(힌트, 참고)
     * 별(*) 3개 : 완전 참고
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        System.out.println(solve(n, 0));
    }

    static int[] board = new int[15];

    static int solve(int n, int row) {
        int count = 0;
        if (n == row) return 1;

        for (int col = 0; col < n; col++) {
            if (isValid(row, col)) {
                board[row] = col;
                count += solve(n, row + 1);
            }
        }

        return count;
    }

    private static boolean isValid(int row, int col) {
        for (int i = 0; i < row; i++) {
            if (board[i] == col) return false;
            if (Math.abs(row - i) == Math.abs(col - board[i])) return false;
        }
        return true;
    }
}