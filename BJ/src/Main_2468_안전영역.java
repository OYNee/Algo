import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
 * 작성자: 오유민
 * 작성 날짜: 20200510
 * 키워드: dfs
 * 난이도: Silver I
 * 제출까지 걸린 시간: 37분 58초
 */
public class Main_2468_안전영역 {
	static int N, map[][], map2[][], max, cnt, ans;
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		map2 = new int[N][N];
		StringTokenizer st = null;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (max < map[i][j]) {
					max = map[i][j];
				}
			}
		}

		for (int h = 0; h <= max; h++) {
			cnt = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map2[i][j] = map[i][j];
				}
			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map2[i][j] <= h) {
						map2[i][j] = 0;
					}
				}
			}
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map2[i][j] != 0) {
						map2[i][j] = 0;
						++cnt;
						dfs(i, j);
					}
				}
			}
			if (ans < cnt) {
				ans = cnt;
			}
		}

		System.out.println(ans);
	}

	private static void dfs(int x, int y) {
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (nx < 0 || ny < 0 || nx >= N || ny >= N || map2[nx][ny] == 0) {
				continue;
			}
			map2[nx][ny] = 0;
			dfs(nx, ny);
		}
	}

}
