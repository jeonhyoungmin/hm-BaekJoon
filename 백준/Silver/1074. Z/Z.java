import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        solve(n, r, c);
        System.out.println(result);
    }

    static void solve(int n, int r, int c) {
        // base case
        if (n == 0) return;
        int boardSize = 1 << n; // 2^n
        int half = boardSize / 2;

        // recursive case
        // 1 사분면
        if (r < half && c < half) {
            solve(n - 1, r, c);
        }
        // 2 사분면
        else if (r < half && c >= half) {
            result += half * half;
            solve(n - 1, r, c - half);
        }
        // 3 사분면
        else if (r >= half && c < half) {
            result += half * half * 2;
            solve(n - 1, r - half, c);
        }
        // 4 사분면
        else if (r >= half && c >= half) {
            result += half * half * 3;
            solve(n - 1, r - half, c - half);
        }
    }
}
