import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static class Messages {
		int value;
		int index;

		public Messages(int value, int index) {
			this.value = value;
			this.index = index;
		}
	}

	static class Frequency {
		int value;
		int count;
		int index;

		public Frequency(int value, int count, int index) {
			this.value = value;
			this.count = count;
			this.index = index;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		Messages[] messages = new Messages[N];
		for (int i = 0; i < N; i++) 
			messages[i] = new Messages(Integer.parseInt(st.nextToken()), i);
		
		Arrays.sort(messages, (o1, o2) -> o1.value - o2.value );
		
		Frequency[] frequencies = new Frequency[N];
		frequencies[0] = new Frequency(messages[0].value, 1, messages[0].index);
		int idx = 0;
		for(int i = 1; i<messages.length; i++) {
			if(messages[i].value != messages[i-1].value)
				frequencies[++idx] = new Frequency(messages[i].value, 0, messages[i].index); 
			frequencies[idx].count++;
		}
		
		// sort(fromIndex, toIndex) toIndex는 범위에 들어가지 않기 때문에 +1 필요.
		Arrays.sort(frequencies, 0, idx + 1, (o1, o2) -> {
			if(o1.count == o2.count)
				return o1.index - o2.index;
			return o2.count - o1.count;
		});
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for(int i = 0; i<idx + 1; i++) {
			while (frequencies[i].count -- > 0)
				bw.write(frequencies[i].value + " ");			
		}

		bw.flush();
	}
}