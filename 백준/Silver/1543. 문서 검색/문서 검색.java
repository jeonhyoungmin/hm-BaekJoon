import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String title = sc.nextLine();
		String word = sc.nextLine();
		
		int count = 0;
		int startIndex = 0;
		boolean state = true;
		
		while(state) {
			int index = title.indexOf(word, startIndex);
			if(index < 0) break;
			count++;
			startIndex = index + word.length();
		}
		
		System.out.println(count);
	}
}
