import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class MyArrayList {
	
	int size;
	int[] data;
	
	public MyArrayList(int initialCapacity) {
		data = new int[initialCapacity];
		size = 0;
	}
	
	public void add(int item) {
		if(size == data.length)
			growCapacity();
		data[size++] = item;
	}
	
	private void growCapacity() {
		int newCapacity = data.length * 2;
		data = Arrays.copyOf(data, newCapacity);
	}
	
	public int remove(int idx) {
		int deleteItem = data[idx];
		System.arraycopy(data, idx + 1, data, idx, data.length - idx - 1);
		size--;
		return deleteItem;
	}
	
	public int size() {
		return this.size;
	}
	
}

public class Main {
	

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		MyArrayList list = new MyArrayList(N);
		for(int i=1; i<=N; i++) list.add(i);
		
		int[] ans = new int[N];
		int index = 0;
		for(int i=0; i<N; i++) {
			index = (index + K - 1) % list.size();
			ans[i] = list.remove(index);
		}
		
		System.out.print("<");
		for(int i=0; i<N; i++) {
			if(i>0) System.out.print(", ");
			System.out.print(ans[i]);
		}
		System.out.print(">");

	}

}
