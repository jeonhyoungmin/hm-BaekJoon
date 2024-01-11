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
        if (n == 1) {
            result += lastQuadrantValue(r, c);
            return;
        }

        // recursive case
        double location = quadrantLocation(n, r, c);
        result += location * Math.pow(Math.pow(2, n - 1), 2);
        int newRow = alterRow(n, r, location);
        int newCol = alterCol(n, c, location);
        solve(n-1, newRow, newCol);
    }

    private static int alterRow(int n, int r, double location) {
        int newRow = r;
        double preQuadrantRow = Math.pow(2, n-1);
        if (location == 2) newRow -= preQuadrantRow;
        else if(location == 3) newRow -= preQuadrantRow;
        return newRow;
    }

    private static int alterCol(int n, int c, double location) {
        int newCol = c;
        double preQuadrantRow = Math.pow(2, n-1);
        if (location == 1) newCol -= preQuadrantRow;
        else if(location == 3) newCol -= preQuadrantRow;
        return newCol;
    }

    private static int lastQuadrantValue(int r, int c) {
        int result = 0;

        if (r == 0) {
            if (c == 0) result = 0;
            else if (c == 1) result = 1;
        } else if (r == 1) {
            if (c == 0) result = 2;
            else if (c == 1) result = 3;
        }

        return result;
    }

    static double quadrantLocation(int n, int r, int c) {
        double end = Math.pow(2, n) - 1;
        double half = Math.pow(2, n - 1);
        double location = 0;

        if (0 <= r && r < half) {
            if (0 <= c && c < half) location = 0; // r행 c열이 1 사분면에 위치
            else if (half <= c && c <= end) location = 1; // r행 c열이 2 사분면에 위치
        } else if (half <= r && r <= end) {
            if (0 <= c && c < half) location = 2; // r행 c열이 3 사분면에 위치
            else if (half <= c && c <= end) location = 3; // r행 c열이 4 사분면에 위치
        }

        return location;
    }

}
