import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2252_줄세우기 {
	// 학생수, 간선수
	static int N, M;
	// 인접리스트
	static List<Integer>[] list;
	// 집입차수
	static int[] inDegree;
	// 큐
	static Queue<Integer> q;
	// 출력용 list
	static ArrayList<Integer> result;
	// 출력
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken())+1;
		M = Integer.parseInt(st.nextToken());
		list = new ArrayList[N];
		inDegree = new int[N];
		q = new LinkedList<Integer>();
		result = new ArrayList<>();
		
		for (int i = 1; i < N; i++) {
			list[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			list[x].add(y);
			inDegree[y]++;
		}
		
//		System.out.println(Arrays.toString(inDegree));
		for (int i = 1; i < N; i++) {
			if (inDegree[i] == 0) {
				q.add(i);
			}
		}
		topologicalSort();
		
		for (int i = 0; i < N-1; i++) {
			sb.append(result.get(i)).append(" ");
		}
		System.out.println(sb);
	}

	private static void topologicalSort() {
		while(!q.isEmpty()) {
			int current = q.poll();
			result.add(current);
			int size = list[current].size();
			for (int i = 0; i < size; i++) {
				int temp = list[current].get(i);
				
				inDegree[temp]--;
				if (inDegree[temp] == 0) {
					q.add(temp);
				}
			}
		}
	}
	
	

}
