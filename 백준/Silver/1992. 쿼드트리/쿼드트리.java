import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        board = new int[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            board[i] = Arrays.stream(st.nextToken().split(""))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        solve(n, 0, 0);
    }

    static void solve(int n, int row, int col) {
        // base case
        if (isSame(n, row, col)) {
            System.out.print(board[row][col]);
            return;
        }

        // recursive case
        int mid = n / 2;
        System.out.print("(");
        solve(mid, row, col);
        solve(mid, row, col + mid);
        solve(mid, row + mid, col);
        solve(mid, row + mid, col + mid);
        System.out.print(")");
    }

    private static boolean isSame(int n, int row, int col) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[row][col] != board[row + i][col + j]) return false;
            }
        }
        return true;
    }

}
