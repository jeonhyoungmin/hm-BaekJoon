import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class MyDoubleLinkedList {
	
	static int size;
	Node firstNode;
	Node lastNode;
	Node last;
	Node cursor;
	
	static class Node {
		
		Character item;
		Node nextNode;
		Node prevNode;
		
		public Node() {}
		
		public Node(Character item) {
			this.item = item;
		}
		
		public Node(Character item, Node nextNode) {
			this.item = item;
			this.nextNode = nextNode;
		}
		
		public Node(Character item, Node nextNode, Node prevNode) {
			this.item = item;
			this.nextNode = nextNode;
			this.prevNode = prevNode;
		}
		
	}
	
	public MyDoubleLinkedList() {
		this.size = 0;
		this.firstNode = new Node();
		this.lastNode = new Node();
		firstNode.nextNode = lastNode;
		lastNode.prevNode = firstNode;
		cursor = lastNode;
	}
	
	public void add(Character item) {
		if(size == 0) {
			Node newNode = new Node(item, lastNode, firstNode);
			firstNode.nextNode = newNode;
			lastNode.prevNode = newNode;
			last = newNode;
		} else {
			Node newNode = new Node(item, lastNode, last);
			last.nextNode = newNode;
			lastNode.prevNode = newNode;
			last = newNode;
		}
		size++;
	}
	
	public void insert(Character item) {
		Node newNode = new Node(item, cursor, cursor.prevNode);
		cursor.prevNode.nextNode = newNode;
		cursor.prevNode = newNode;
		size++;
	}
	
	public StringBuilder getData() {
		
		StringBuilder sb = new StringBuilder();
		
		Node tempNode = firstNode.nextNode;
		
		while(tempNode.nextNode != null) {
			sb.append(tempNode.item);
			tempNode = tempNode.nextNode;
		}
		
		return sb;
	}
	
}

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		
		MyDoubleLinkedList list = new MyDoubleLinkedList();
		for(int i=0; i<str.length(); i++) {
			list.add(str.charAt(i));
		}
		
		int M = Integer.parseInt(br.readLine());
		for(int i=0; i<M; i++) {
			String command = br.readLine();
			char code = command.charAt(0);
			if(code == 'L') {
				if(list.cursor.prevNode != list.firstNode) list.cursor = list.cursor.prevNode;
			}
			if(code == 'D') {
				if(list.cursor != list.lastNode) list.cursor = list.cursor.nextNode;
			}
			if(code == 'B') {
				if(list.cursor.prevNode != list.firstNode) {
					list.cursor.prevNode.prevNode.nextNode = list.cursor;
					list.cursor.prevNode = list.cursor.prevNode.prevNode;
				}
			}
			if(code == 'P') {
				Character item = command.charAt(2);
				list.insert(item);
			}
		}
		
		System.out.println(list.getData());
		
	}

}
