import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14503_로봇청소기 {
	static int n, m, map[][];
	static int cnt=1;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	static boolean end;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		st = new StringTokenizer(br.readLine());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		map[x][y] = -1;
		dfs(x, y, d);
		System.out.println(cnt);
	}
	
	public static void dfs(int x, int y, int d) {
		int count = 0;
		for (int i = 0; i < 4; i++) {
			if(--d < 0) {
				d = 3;
			}
			int nx = x + dx[d];
			int ny = y + dy[d];
			if (map[nx][ny] != 0) {
				++count;
				if(count == 4) {
					switch(d) {
					case 0:
						x += 1;
						break;
					case 1:
						y -= 1;
						break;
					case 2:
						x -= 1;
						break;
					case 3:
						y += 1;
						break;
					}
					if (map[x][y] == 1) {
						end = true;
						return;
					}
					dfs(x, y, d);
					if(end)
						return;
				}
				continue;
			}
			++cnt;
			map[nx][ny] = -1;
			dfs(nx, ny, d);
			if(end)
				return;
		}
	}
}