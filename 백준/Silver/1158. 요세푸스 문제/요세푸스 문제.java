import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class MyLinkedList {
	
	int size = 0;
	Node firstNode = null;
	Node lastNode = null;
	
	public static class Node {
		int item;
		Node next;
		
		public Node(int item, Node next) {
			this.item = item;
			this.next = next;
		}
		
	}
	
	public void add(int item) {
		Node newNode = new Node(item, null);
		if(size == 0) {
			firstNode = newNode;
		} else {
			lastNode.next = newNode;
		}
		lastNode = newNode;
		size++;
	}
	
	public int remove(int idx) {
		Node prevNode = null;
		Node targetNode = firstNode;
		while(idx-->0) {
			prevNode = targetNode;
			targetNode = targetNode.next;
		}
		if(prevNode == null) {
			firstNode = firstNode.next;
		} else {
			prevNode.next = targetNode.next;
			if(prevNode.next == null) {
				lastNode = prevNode;
			}
		}
		size--;
		return targetNode.item;
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
		
		MyLinkedList list = new MyLinkedList();
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
