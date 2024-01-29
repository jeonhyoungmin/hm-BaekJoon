import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static boolean[][] table;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());

        table = new boolean[n + 1][n + 1];
        visited = new boolean[n + 1];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            table[v1][v2] = true;
            table[v2][v1] = true;
        }

        dfs(v);
        System.out.println(sb);
        sb.setLength(0);
        visited = new boolean[n + 1];

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(v);
        while (!queue.isEmpty()) {
            int index = queue.poll();
            visited[index] = true;
            sb.append(index + " ");
            for (int i = 1; i <= n; i++) {
                if (!visited[i] && table[index][i]) {
                    visited[i] = true;
                    queue.offer(i);
                }
            }
        }

        System.out.println(sb);

    }

    static void dfs(int index) {
        visited[index] = true;
        sb.append(index + " ");
        for (int i = 1; i <= n; i++) {
            if (!visited[i] && table[index][i]) {
                dfs(i);
            }
        }
    }

}
