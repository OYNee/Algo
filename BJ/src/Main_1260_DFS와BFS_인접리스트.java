import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;
/*
 * 작성자: 오유민
 * 작성 날짜: 20200506
 * 키워드: dfs & bfs &인접리스트
 * 난이도: Silver I
 * 제출까지 걸린 시간: 41분 23초
 */
public class Main_1260_DFS와BFS_인접리스트 {
	static int N, M, V;
	static StringBuilder sb = new StringBuilder();
	static List<Integer>[] arr;
	
	// bfs
	static Queue<Integer> q = new LinkedList<>();
	
	// dfs
	static boolean visited[];
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st =new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken())+1;
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		arr = new List[N];
		
		for (int i = 0; i < N; i++) {	// 각 리스트 생성
			arr[i] = new LinkedList<>();
		}
		
		for (int i = 0; i < M; i++) {	// 간선 정보 입력
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			arr[x].add(y);
			arr[y].add(x);
		}
		
		// dfs
		visited = new boolean[N];
		visited[V] = true;
		dfs(V);
		
		sb.append("\n");
		
		// bfs
		visited = new boolean[N];
		visited[V] = true;
		q.add(V);
		bfs();
		
		// 출력
		System.out.println(sb.toString());
	}
	private static void dfs(int nv) {
		Collections.sort(arr[nv]);	// 작은 정점부터 방문하기 위해
		sb.append(nv + " ");
		int size = arr[nv].size();
		for (int i = 0; i < size; i++) {
			int tmp = arr[nv].get(i);
			if (!visited[tmp]) {
				visited[tmp] = true;
				dfs(tmp);
			}
		}
		
		
	}
	private static void bfs() {
		while(!q.isEmpty()) {
			int nv = q.poll();
			sb.append(nv + " ");
			int size = arr[nv].size();
			for (int i = 0; i < size; i++) {
				int tmp = arr[nv].get(i);
				if (visited[tmp]) {
					continue;
				}
				
				q.add(tmp);
				visited[tmp] = true;
			}
		}
	}

}
