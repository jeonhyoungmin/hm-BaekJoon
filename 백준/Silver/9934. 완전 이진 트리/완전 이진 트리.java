import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static Node insertNodes(int[] val, int start, int end) {
		if (start > end)
			return null; // 없어도 된다.

		int middle = (end + start) / 2;
		Node node = new Node(val[middle]);

		if (start == end)
			return node;

		node.left = insertNodes(val, start, middle - 1);
		node.right = insertNodes(val, middle + 1, end);

		return node;
	}
	
	static void printTree(Node root) {
		StringBuilder sb = new StringBuilder();
		
		Queue<Node> queue = new LinkedList<>();
		queue.add(root);
		
		while(!queue.isEmpty()) {
			int size = queue.size();
			for(int i = 0; i<size; i++) {
				Node node = queue.poll();
				sb.append(node.data + " ");
				if(node.left != null) queue.add(node.left);
				if(node.right != null) queue.add(node.right);
			}
			sb.append("\n");
		}
		System.out.println(sb);
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
		int K = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int size = (int) Math.pow(2, K) - 1;
		int[] arr = new int[size];
		for (int i = 0; i < size; i++)
			arr[i] = Integer.parseInt(st.nextToken());

		Node node = insertNodes(arr, 0, size - 1);
		printTree(node);
	}
}