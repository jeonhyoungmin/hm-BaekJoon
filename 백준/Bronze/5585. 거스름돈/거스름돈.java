import java.util.Scanner;

public class Main {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int pay = sc.nextInt();
		
		int total = 1000 - pay;
		int result = 0;
		
		int[] money = { 500, 100, 50, 10, 5, 1 };
		
		for(int m : money) {
			if(total < m) continue;
			result += total / m;
			total = total % m;
		}
		
		System.out.println(result);
	}

}
