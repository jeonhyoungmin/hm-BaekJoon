import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = Integer.parseInt(sc.nextLine());
		
		for(int i = 0; i<N; i++) {
			FlipFunc(sc.nextLine(), i+1);
		}
	}

	private static void FlipFunc(String s, int testCase) {
		String[] str = s.split(" ");
		System.out.print("Case #" + testCase + ": ");
		for(int i = str.length-1; i>=0; i--) {
			System.out.print(str[i] + " ");
		}
		System.out.println();
	}

}
