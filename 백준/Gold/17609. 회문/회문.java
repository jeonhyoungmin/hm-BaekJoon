import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	static boolean isPalindrome(char[] arr, int l, int r) {
		while(l <= r) {
			if(arr[l] != arr[r]) return false;
			l++;
			r--;
		}
		return true;
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		while(T-- > 0) {
			char[] arr = br.readLine().toCharArray();
			int ans = 0;
			int i = 0;
			int pairIndex = arr.length - 1; 
			
			while(i <= pairIndex) {
				if(arr[i] != arr[pairIndex]) {
					if(isPalindrome(arr, i+1, pairIndex) || isPalindrome(arr, i, pairIndex-1)) ans = 1;
					else ans = 2;
					break;					
				}
				i++;
				pairIndex--;
			}
			
			System.out.println(ans);
		}
	}
}
