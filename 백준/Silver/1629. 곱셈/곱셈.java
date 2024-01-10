import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static long A;
    static long C;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        C = Long.parseLong(st.nextToken());
        System.out.println(divide(B));
    }

    static long divide(long b) {
        if(b == 1) return A%C;
        long half = divide(b/2);
        if (b % 2 == 0) {
            return (half * half) % C;
        } else {
            return (((half * half) % C) * A) % C;
        }
    }
}
