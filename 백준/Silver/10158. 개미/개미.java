import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//		String xy = sc.nextLine();
//		String pq = sc.nextLine();
//		int t = Integer.parseInt(sc.nextLine());
//		
//		// 편의를 위해 pq를 xy로 치환해서 계산
//		// xy 최대 좌표 설정
//		// 시작 좌표 설정
//		// xy 최대 좌표는 최소 2,2 최대 40000,40000
//		// pq는 반드시 xy보다 작음
//		// 따라서 시작한다면 반드시 p+1, q+1로 시작
//		// xy가 동일하다면 정사각형을 그림
//		
//		// 알고리즘 작성
//		// x, y 좌표의 최대 값을 xy에서 추출
//		// String 타입의 x,y를 int 타입으로 변환
//		int x = (int)xy.charAt(0)-'0';
//		int y = (int)xy.charAt(2)-'0';
////		System.out.println("x=" + x);
////		System.out.println("y=" + y);
//		
//		// p, q 좌표를 pq에서 추출
//		// String 타입의 p,q를 int 타입으로 변환
//		int p = (int)pq.charAt(0)-'0';
//		int q = (int)pq.charAt(2)-'0';
////		System.out.println("p=" + p);
////		System.out.println("q=" + q);
//		
//		// t값 확인
////		System.out.println("t=" + t);
//		
//		
//		
//		
//		
//		// 방법 1. 오답
//		// 최대치에 도달하면 대각선 이동 후, 모든 방향 -1
//		// 최소치에 도달하면 대각선 이동 후, 모든 방향 +1
////		// i=1; i<=t; i++을 선언부로 하는 for문 작성
//////		for(int i=1; i<=t; i++) {
//////		}
////		// while문으로 진행
////		// 첫 시작은 반드시 p+1, q+1로 시작 (p,q 모두 w,h 곧 x,y 최대 값 보다 작기 때문)
////		int i = 0;
////		while(i < t) {
////			// p와 q는 반드시 x와 y보다 작게 시작하기 때문에, p+1, q+1로 시작
////			if(i==0) {
////				p = p+1;
////				p = q+1;
////				i ++; 
////				continue;
////			}
////			// 경우의 수 1. p가 x의 최대치에 도달했을 경우: 이후부터는 q가 y의 최대치에 도달할 때까지 p-1, q+1
////			if(p==x) {
////				while(q == y) {
////					p --;
////					q ++;
////					i ++;
////					if(i == t) break;
////				}
////			}
////			// 경우의 수 2. q가 y의 최대치에 도달했을 경우: 이후부터는 p가 x의 최대치에 도달할 때까지 p+1, q-1
////			if(q==y) {
////				while(p == x)
////				p = p+1;
////				q = q-1;
////			}
////			// 경우의 수 3. p와 q가 동시에 x와 y의 최대치에 도달했을 경우: 두 방향 중 하나 혹은 둘 다 0에 도달할 때까지 양 방향 -1
////			if(p == x && q == y) {
////				p = p-1;
////				q = q-1;
////			}
////		}
////		// 경우의 수 4. p가 x의 최소치 곧 x=0에 도달했을 경우: q가 y의 최소치에 도달할 때까지 p-1, q+1
////		// 경우의 수 5. q가 y의 최소치 곧 y=0에 도달했을 경우: p가 x의 최소치에 도달할 때까지 p+1, q-1
////		// 경우의 수 6. p와 q가 동시에 x와 y의 최소치에 도달했을 경우: 두 방향 중 하나 혹은 둘 다 최대치에 도달할 때까지 양 방향 +1
//		
//		
//		
//		
//		
//		
//		// 방법 2. 정답, 하지만 시간 초과
//		// 대각선 방향을 설정
//		// p와 q가 동시에 최대값 혹은 최소값에 도달하는 순간을 기점으로 경로가 반복된다.
//		// leftUp = p-1, q+1
//		// leftDown = p-1, q-1
//		// rightUp = p+1, q+1
//		// rightDown = p+1, q-1
//		
//		// 경우의 수 1. rightUp 방향일 경우
//		// 1-1. p=x 도달: leftUp으로 전환
//		// 1-2. q=y 도달: rightDown으로 전환
//		// 1-3. p=x q=y 도달: leftDown으로 전환
//		// 경우의 수 2. rightDown 방향일 경우
//		// 2-1 p=x 도달: leftDown으로 전환
//		// 2-2 q=0 도달: rightUp으로 전환
//		// 2-3 p=x, q=0 도달: leftUp으로 전환
//		// 경우의 수 3. leftUp 방향일 경우
//		// 3-1 p=0 도달: rightUp으로 전환
//		// 3-2 q=y 도달: leftDown으로 전환
//		// 3-3 p=0, q=y 도달: rightDown으로 전환
//		// 경우의 수 4. leftDown 방향일 경우
//		// 4-1 p=0 도달: rightDown으로 전환
//		// 4-2 q=0 도달: leftUp으로 전환
//		// 4-3 p=0, q=0 도달: rightUp으로 전환
//		
//		// 알고리즘
//		// t 시간동안 p,q값 변경
//		// int i = 0;
//		// 먼저 첫 시작은 rightUp으로 시작
//		// rightUp의 경우의 수에 걸리지 않는다면
//		// 계속해서 rightUp으로 진행
//		// rightUp의 경우의 수에 걸리는 방향에 맞게 방향 전환
//		// i가 t보다 작은 동안 계속해서 진행
//		int i = 0;
//		String direction = "rightUp";
//		while(i<t) {
//			if(direction=="rightUp") {
//				p++;
//				q++;
//				i++;
//				if(p==x) direction = "leftUp";
//				if(q==y) direction = "rightDown";
//				if(p==x && q==y) direction = "leftDown"; 
//			}
//			if(direction=="rightDown") {
//				p++;
//				q--;
//				i++;
//				if(p==x) direction = "leftDown";
//				if(q==0) direction = "rightUp";
//				if(p==x && q==0) direction = "leftUp"; 
//			}
//			if(direction=="leftUp") {
//				p--;
//				q++;
//				i++;
//				if(p==0) direction = "rightUp";
//				if(q==y) direction = "leftDown";
//				if(p==0 && q==y) direction = "rightDown"; 
//			}
//			if(direction=="leftDown") {
//				p--;
//				q--;
//				i++;
//				if(p==0) direction = "rightDown";
//				if(q==0) direction = "leftUp";
//				if(p==0 && q==0) direction = "rightUp"; 
//			}
//		}
		
		
		
		int W = sc.nextInt();
		int H = sc.nextInt();
		int P = sc.nextInt();
		int Q = sc.nextInt();
		int T = sc.nextInt();
		
		// 방법 3. 정답. 시간 복잡도 O(max(W,H))
//		int timeX = T % (2 * W);
//		int currentX = P;
//		int deltaX = 1;
//		while(timeX-- > 0) {
//			if(currentX == W) deltaX = -1;
//			else if(currentX == 0) deltaX = 1;
//			currentX += deltaX;
//		}
//		
//		int timeY = T % (2 * H);
//		int currentY = Q;
//		int deltaY = 1;
//		while(timeY-- > 0) {
//			if(currentY == H) deltaY = -1;
//			else if(currentY == 0) deltaY = 1;
//			currentY += deltaY;
//		}
		
		// 방법 4. 정답. 시간 복잡도 O(1)
		int currentX = (T+P)%(2*W);
		int currentY = (T+Q)%(2*H);
		if(currentX	> W) currentX = 2 * W - currentX;
		if(currentY > H) currentY = 2 * H - currentY;
		
		
		// p와 q의 현재 값을 출력한다.
		System.out.print(currentX + " " + currentY);
	}
}
