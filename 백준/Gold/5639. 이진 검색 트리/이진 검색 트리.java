import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	static Node insert(Node node, int val) { // 트리에 데이터 저장(재귀)
		
		if(node == null) return new Node(val);
		
		if(val < node.data) {
			node.left = insert(node.left, val);
		} else if(val > node.data) {
			node.right = insert(node.right, val);
		}
		
		return node;
	}
	
	static void printPostOrder(Node node) { // 후위 순회하여 출력(재귀)
		if(node == null) return;
		printPostOrder(node.left);
		printPostOrder(node.right);
		System.out.println(node.data);
	}

	static class Node {
		int data;
		Node left;
		Node right;

		Node(int val) {
			this.data = val;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		Node node = null;
		while(true) {
			String data = br.readLine();
			if(data == null || data.equals("")) break;
			node = insert(node, Integer.parseInt(data));
		}
		
		printPostOrder(node);
	}
}