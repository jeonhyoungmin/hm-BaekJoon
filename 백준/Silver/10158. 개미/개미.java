import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int W = sc.nextInt();
		int H = sc.nextInt();
		int P = sc.nextInt();
		int Q = sc.nextInt();
		int T = sc.nextInt();
		
		// 방법 4. 정답. 시간 복잡도 O(1)
		int currentX = (T+P)%(2*W);
		int currentY = (T+Q)%(2*H);
		if(currentX	> W) currentX = 2 * W - currentX;
		if(currentY > H) currentY = 2 * H - currentY;
		
		
		// p와 q의 현재 값을 출력한다.
		System.out.print(currentX + " " + currentY);
	}
}
