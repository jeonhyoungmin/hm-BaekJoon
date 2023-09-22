import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// 배열의 크기는 1~1,000,000
		// 배열 데이터는 10^9 1,000,000,000 int 가능
		// 첫 줄 배열 A,B의 크기
		// 두 번째 줄 배열 A의 크기
		// 세 번째 줄 배열 B의 크기
		// A,B는 정렬되어 있다
		// 정렬은 ArrayList? LinkedList? ArrayList 선택
		// 정렬되어 있기 때문에 각 배열의 데이터를 순서대로 비교하여 결과를 또다른 ArrayList에 담기
        // 남은 데이터 모두 추가하기
        // StringBuilder로 출력 내용 작성
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		List<Integer> A = new ArrayList<>();
		List<Integer> B = new ArrayList<>();
		
		for(int i=0; i<N; i++)
			A.add(sc.nextInt());
		
		for(int i=0; i<M; i++)
			B.add(sc.nextInt());
		
		// 출력 List
		List<Integer> ans = new ArrayList<>();
		
		int i=0, j =0; // 각각 A,B의 인덱스
		while(i<N && j<M) {
			int a = A.get(i);
			int b = B.get(j);
			
			if(a<b) {
				ans.add(a);
				i++;
			} else {
				ans.add(b);
				j++;
			}
		}
		
        // 더 큰 숫자를 가진 배열에 남아있는 데이터를 모두 추가하기
		for(; i<N; i++)
			ans.add(A.get(i));
		
		for(; j<M; j++)
			ans.add(B.get(j));
		
		StringBuilder sb = new StringBuilder();
		for(int e : ans) {
			sb.append(e + " ");
		}
		
		System.out.println(sb.toString());

	}

}
