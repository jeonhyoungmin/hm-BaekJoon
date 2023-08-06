import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			int T = sc.nextInt();
			while(T-->0) {
				int x = sc.nextInt();
				boolean ans = false;
				for(int i = 2; i<=64; i++) {
					// 진법 변환: 변환된 자리 수 만큼의 배열 반환
					int[] converted = convertBase(x, i);
					// 회문 체크: 배열을 반으로 나누어 회문 체크
					if(palindrome(converted)) {
						ans = true;
						break;
					}
				}
				System.out.println(ans ? 1 : 0);
			}
	}
	
	private static int[] convertBase(int x, int i) {
		// 해당 진법의 자리 개수 만큼의 배열 생성
		int len = 0, copyX = x;
		while(copyX>0) {
			copyX /= i;
			len++;
		}
		int[] convertedArray = new int[len];
		
		// 배열에 해당 진법의 자리 수에 x를 i로 나눈 나머지 저장
		// 끝자리부터 저장
		len = 0;
		while(x>0) {
			convertedArray[len++] = x % i;
			x /= i;
		}
		
		return convertedArray;
	}

	private static boolean palindrome(int[] converted) {
		for(int i = 0; i<converted.length/2; i++) { // 배열을 반으로 나누어 양 끝 비교
			if(converted[i] != converted[converted.length - 1 - i]) {
				return false;
			}
		}
		return true;
	}


}
