import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		for(int i = 0; i<2; i++) System.out.println(i + " " + (i+1));
		int front = 1;
		int back = 2;
		int leaf = 2;
		int node = 3;
		while(node < n) {
			if(leaf != m) {
				back++;
				System.out.println(front + " " + back);
				leaf++;
				node++;
			} else {
				front++;
				back++;
				System.out.println(front + " " + back);
				node++;
			}
		}
	}
}