import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		char[] arr = br.readLine().toCharArray();
		int[] alphabet = new int[26];
		
		int Rpointer = 0;
		int alphabetCount = 0;
		int L = arr.length;
		int ans = 0;
		
		for(int i=0; i<L; i++) {
			
			while(Rpointer < L) {
				
				if(alphabet[arr[Rpointer] - 'a'] == 0) alphabetCount++;
				if(alphabetCount > N) {
					alphabetCount--;
					break;
				}
				alphabet[arr[Rpointer++] - 'a']++;
			}
			
			ans = Math.max(ans, Rpointer - i);
			
			alphabet[arr[i] - 'a']--;
			if(alphabet[arr[i] - 'a'] == 0) alphabetCount--;
		}
		
		System.out.println(ans);
	}
}