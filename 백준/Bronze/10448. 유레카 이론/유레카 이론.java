import java.util.Scanner;

public class Main {
	// 1. 3<=K<=1000 범위에 해당하는 삼각수가 몇 개인지 구하기
	// 2. 3개의 삼각수를 더했을 때, K의 값이 되는 K를 구한다.
	// 3. 1~2번을 전처리로 해결하여 시간 복잡도를 줄인다.

	// 유레카 넘버 배열
	static boolean[] isUurekaNumber = new boolean[1001];

	// isUurekaNumber를 완성하는 전처리
	public static void preprocess() {
		// K보다 작은 삼각수를 찾는다
		// 가능한 삼각수의 개수를 알 수 없으니, 임의로 50으로 지정
		int[] triangleNumbers = new int[50];
		int triangleNumberCount = 0;
		for (int i = 1;; i++) {
			int triangleNumber = i * (i + 1) / 2;
			if(triangleNumber >= 1000) break;
			triangleNumbers[triangleNumberCount++] = triangleNumber;
		}
		
		// 3개의 삼각수를 더해서 1000보다 작은 수를 찾아 isUurekaNumber를 완성한다.
		for(int i=0; i<triangleNumberCount; i++)
			for(int j=0; j<triangleNumberCount; j++)
				for(int k=0; k<triangleNumberCount; k++) {
					int sum = triangleNumbers[i] + triangleNumbers[j]+ triangleNumbers[k];
					if(sum <= 1000) isUurekaNumber[sum] = true; 
				}

	}

	public static void main(String[] args) {
		preprocess();

		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while (T-- > 0) {
			int K = sc.nextInt();
			System.out.println(isUurekaNumber[K] ? 1:0);
		}

	}

}
