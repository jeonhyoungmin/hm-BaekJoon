import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static boolean[][] table;
    static boolean[] visited;
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        table = new boolean[n + 1][n + 1];
        visited = new boolean[n + 1];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            table[v1][v2] = true;
            table[v2][v1] = true;
        }

        for (int i = 1; i <= n; i++) {
            if(visited[i]) continue;
            cnt++;
            dfs(i);
        }

        System.out.println(cnt);
    }

    static void dfs(int index) {
        visited[index] = true;
        for (int i = 1; i <= n; i++) {
            if (!visited[i] && table[index][i]) {
                dfs(i);
            }
        }
    }

}
