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
 * 키워드: dfs & bfs & 인접행렬
 * 난이도: Silver I
 * 제출까지 걸린 시간: 41분 23초
 */
public class Main_1260_DFS와BFS_인접행렬 {
	static int N, M, V, graph[][];
	static StringBuilder sb = new StringBuilder();
	
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
		graph = new int[N][N];

		for (int i = 0; i < M; i++) {	// 간선 정보 입력
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			graph[x][y] = 1;
			graph[y][x] = 1;
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
		sb.append(nv + " ");
		for (int i = 0; i < N; i++) {
			if (graph[nv][i] == 1 && !visited[i]) {
				visited[i] = true;
				dfs(i);
			}
		}
		
		
	}
	private static void bfs() {
		while(!q.isEmpty()) {
			int nv = q.poll();
			sb.append(nv + " ");
			for (int i = 0; i < N; i++) {
				if (graph[nv][i] == 1 && !visited[i]) {
					q.add(i);
					visited[i] = true;
				}
			}
		}
	}

}
