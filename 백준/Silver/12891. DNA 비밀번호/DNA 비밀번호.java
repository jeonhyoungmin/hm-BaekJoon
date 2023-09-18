import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int baseToIndex(char alp) {
		if(alp == 'A') return 0;
		else if(alp == 'C') return 1;
		else if(alp == 'G') return 2;
		else if(alp == 'T') return 3;
		return -1;
	}
	
	static boolean isValid(int[] count, int[] minimun) {
		for(int i=0; i<count.length; i++)
			if(count[i] < minimun[i]) return false;
		return true;
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int S = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());
		
		char[] str = br.readLine().toCharArray();
		
		int[] minimun = new int[4];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<4; i++) {
			minimun[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] count = new int[4];
		for(int i=0; i<P-1; i++) {
			count[baseToIndex(str[i])]++;
		}
			
		int ans = 0;
		for(int i=P-1; i<S; i++) {
			count[baseToIndex(str[i])]++;
			if(isValid(count, minimun)) ans++;
			
			count[baseToIndex(str[i-P+1])]--;
		}
		
		System.out.println(ans);
	}
}