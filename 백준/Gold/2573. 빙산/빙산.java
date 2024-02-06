import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int n, m;
    static int[][] arctic;
    static boolean[][] visited;
    static List<Iceberg> icebergList;

    static int[] dr = {-1, 1, 0, 0}; // 상하좌우
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arctic = new int[n][m];
        visited = new boolean[n][m];
        icebergList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                int height = Integer.parseInt(st.nextToken());
                arctic[i][j] = height;
                if (height > 0) {
                    icebergList.add(new Iceberg(i, j, height));
                }
                visited[i][j] = true;
            }
        }

        for (int year = 1; !icebergList.isEmpty(); year++) {
            for (Iceberg iceberg : icebergList) {
                for (int d = 0; d < 4; d++) {
                    int nr = iceberg.row + dr[d];
                    int nc = iceberg.col + dc[d];
                    if (arctic[nr][nc] == 0) {
                        iceberg.height--;
                    }
                }
            }

            for (int i = 0; i < icebergList.size(); i++) {
                Iceberg iceberg = icebergList.get(i);
                if (iceberg.height <= 0) {
                    arctic[iceberg.row][iceberg.col] = 0;
                    icebergList.set(i, icebergList.get(icebergList.size() - 1));
                    icebergList.remove(icebergList.size() - 1);
                    i--;
                } else {
                    visited[iceberg.row][iceberg.col] = false;
                }
            }

            if (icebergList.size() > 0 && dfs(icebergList.get(0).row, icebergList.get(0).col) < icebergList.size()) {
                System.out.println(year);
                System.exit(0);
            }
        }

        System.out.println(0);
    }

    static int dfs(int row, int col) {
        int cnt = 1;
        visited[row][col] = true;
        for (int i = 0; i < 4; i++) {
            int nr = row + dr[i];
            int nc = col + dc[i];
            if (visited[nr][nc]) continue;
            cnt += dfs(nr, nc);
        }
        return cnt;
    }

    private static class Iceberg {
        int row;
        int col;
        int height;

        public Iceberg(int row, int col, int height) {
            this.row = row;
            this.col = col;
            this.height = height;
        }
    }
}
