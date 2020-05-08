import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
/*
 * 작성자: 오유민
 * 작성 날짜: 20200506
 * 키워드: dfs
 * 난이도: Silver I
 * 제출까지 걸린 시간: 22분 54초
 */
public class Main_2667_단지번호붙이기_bfs {
	static class Node {
		int x, y;

		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static int N, map[][], cnt;
	static int dx[] = { -1, 0, 1, 0 };
	static int dy[] = { 0, 1, 0, -1 };
	static boolean[][] visited;
	static StringBuilder sb = new StringBuilder();
	static Queue<Node> q = new LinkedList<>();
	static List<Integer> l = new ArrayList<>();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visited = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			String tmp = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = tmp.charAt(j) - '0';
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 1 && !visited[i][j]) {
					visited[i][j] = true;
					cnt = 1;
					q.add(new Node(i, j));
					bfs();
					l.add(cnt);
				}
			}
		}

		int size = l.size();
		sb.append(size + "\n");
		Collections.sort(l);
		for (int i = 0; i < size; i++) {
			sb.append(l.get(i) + "\n");
		}

		System.out.print(sb.toString());

	}

	private static void bfs() {
		while (!q.isEmpty()) {
			Node tmp = q.poll();
			for (int i = 0; i < 4; i++) {
				int nx = tmp.x + dx[i];
				int ny = tmp.y + dy[i];
				if (nx < 0 || ny < 0 || nx >= N || ny >= N || map[nx][ny] == 0 || visited[nx][ny]) {
					continue;
				}
				visited[nx][ny] = true;
				++cnt;
				q.add(new Node(nx, ny));
			}
		}
	}
}
