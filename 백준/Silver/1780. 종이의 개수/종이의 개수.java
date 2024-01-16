import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static int[][] board;
    static int[] count = new int[3];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        board = new int[n][n];

        for (int i = 0; i < n; i++) {
            board[i] = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        solve(n, 0, 0);
        for (int i : count)
            System.out.println(i);
    }

    static void solve(int n, int row, int col) {
        // base case
        if (isSame(n, row, col)) {
            count[board[row][col] + 1]++;
            return;
        }

        // recursive case
        int threeD = n / 3;
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                solve(threeD, row + r * threeD, col + c * threeD);
            }
        }
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
