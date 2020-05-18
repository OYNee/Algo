import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2206_벽부수고이동하기 {
	static class Point {
		int x, y, cnt;
		boolean usedChance;

		public Point(int x, int y, int cnt, boolean usedChance) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
			this.usedChance = usedChance;
		}
	}

	static int N, M, map[][], ans = Integer.MAX_VALUE;
	static boolean[][] visited;
	static Queue<Point> q = new LinkedList<>();
	static int dx[] = { 0, -1, 0, 1 };
	static int dy[] = { 1, 0, -1, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			String tmp = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = tmp.charAt(j)-'0';
			}
		}
		visited = new boolean[N][M];
		visited[0][0] = true;
		q.add(new Point(0, 0, 1, false));
		bfs();
		if (ans == Integer.MAX_VALUE) {
			System.out.println(-1);
			return;
		}
		System.out.println(ans);
	}

	private static void bfs() {
		while (!q.isEmpty()) {
			Point tmp = q.poll();
			if (tmp.x == N - 1 && tmp.y == M - 1) {
				if (ans > tmp.cnt) {
					ans = tmp.cnt;
					return;
				}
			}
			for (int i = 0; i < 4; i++) {
				int nx = tmp.x + dx[i];
				int ny = tmp.y + dy[i];
				if (nx < 0 || ny < 0 || nx >= N || ny >= M || visited[nx][ny]) {
					continue;
				}
				if (map[nx][ny] == 1) {
					if (tmp.usedChance) {
						continue;
					}
					tmp.usedChance = true;
				}
				if (!tmp.usedChance) {
					visited[nx][ny] = true;
				}
				
				q.add(new Point(nx, ny, tmp.cnt + 1, tmp.usedChance));
			}
		}
	}
}
