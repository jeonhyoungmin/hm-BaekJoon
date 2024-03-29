import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static int n;
    static boolean[][] table;
    static boolean[] visited;
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        int m = sc.nextInt();

        table = new boolean[n + 1][n + 1];
        visited = new boolean[n + 1];
        for (int i = 0; i < m; i++) {
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();
            table[v1][v2] = true;
            table[v2][v1] = true;
        }

//        dfs(1);
        bfs();
        System.out.println(cnt-1);
    }

    static void dfs(int index) {
        visited[index] = true;
        cnt++;
        for (int i = 1; i <= n; i++) {
            if (!visited[i] && table[index][i]) {
                dfs(i);
            }
        }
    }

    static void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        visited[1] = true;

        while (!queue.isEmpty()) {
            int index = queue.poll();
            cnt++;
            for (int i = 1; i <= n; i++) {
                if (!visited[i] && table[index][i]) {
                    visited[i] = true;
                    queue.offer(i);
                }
            }
        }
    }

}
