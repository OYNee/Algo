import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 작성자: 오유민
 * 작성 날짜: 20200510
 * 키워드: bfs
 * 난이도: Silver I
 * 제출까지 걸린 시간: 26분 12초
 */
public class Main_7576_토마토 {
	static class Tomato {
		int x, y, day;

		public Tomato(int x, int y, int day) {
			this.x = x;
			this.y = y;
			this.day = day;
		}
	}	// end of Tomato
	
	static int N, M, ans, map[][];
	static boolean check = true;
	static Queue<Tomato> q = new LinkedList<>();
	static int dx[] = {-1,0,1,0};
	static int dy[] = {0,1,0,-1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 0 && check)
					check = false;
				else if (map[i][j] == 1) {
					q.add(new Tomato(i, j, 0));
				}
			}
		}
		
		if (check) {
			System.out.println(0);
			return;
		}
		
		bfs();
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 0) {
					System.out.println(-1);
					return;
				}
			}
		}
		
		System.out.println(ans);
	}

	private static void bfs() {
		while(!q.isEmpty()) {
			Tomato tmp = q.poll();
			ans = tmp.day;
			for (int i = 0; i < 4; i++) {
				int nx = tmp.x + dx[i];
				int ny = tmp.y + dy[i];
				if (nx < 0 || ny <0 || nx >= N || ny >= M || map[nx][ny] != 0) {
					continue;
				}
				map[nx][ny] = 1;
				q.add(new Tomato(nx, ny, tmp.day + 1));
			}
		}
	}
}
