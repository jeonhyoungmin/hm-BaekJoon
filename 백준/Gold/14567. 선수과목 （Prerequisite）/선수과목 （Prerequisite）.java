import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
	
	private static class subInfo {
		Integer subject;
		Integer semester;
		
		public subInfo(Integer subject, Integer semester) {
			this.subject = subject;
			this.semester = semester;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();

		// index+1 = 과목 번호
		// value = 선수 과목의 수
		int[] indegrees = new int[N];

		// <선수 과목, List<과목>>
		Map<Integer, List<Integer>> graph = new HashMap<>();
		for (int i = 0; i < M; i++) {
			int from = sc.nextInt(); // 선수 과목
			int to = sc.nextInt();   // 과목
			
			indegrees[to-1]++; // 선수 과목 개수++
			List<Integer> subjects = graph.getOrDefault(from, new ArrayList<>());
			subjects.add(to);
			graph.put(from, subjects);
		}
		
		Queue<subInfo> q = new LinkedList<>();
		for(int i=1; i<=indegrees.length; i++) {
			if(indegrees[i-1] == 0) {
				q.offer(new subInfo(i, 1));
			}
		}
		
		Integer[] result = new Integer[N];
		while(!q.isEmpty()) {
			subInfo s = q.poll();
			result[s.subject-1] = s.semester;
			
			if(graph.containsKey(s.subject)) {
				for(Integer node : graph.get(s.subject)) {
					indegrees[node-1]--;
					if(indegrees[node-1] == 0) {
						q.add(new subInfo(node, s.semester + 1));
					}
				}
			}
		}
		
		System.out.println(
				Arrays.asList(result).stream()
						.map(String::valueOf)
						.collect(Collectors.joining(" "))
				);
	}
}