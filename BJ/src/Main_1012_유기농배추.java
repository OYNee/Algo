import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1012_유기농배추 {
	static class Node {
		int x, y;
		Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	static int m, n, num;
	static boolean map[][];
	
	static int cnt;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		
		for (int testCase = 1; testCase <= TC; testCase++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			m = Integer.parseInt(st.nextToken());
			n = Integer.parseInt(st.nextToken());
			num = Integer.parseInt(st.nextToken());
			cnt = 0;
			map = new boolean[m][n];
			for (int i = 0; i < num; i++) {
				st = new StringTokenizer(br.readLine());
				map[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = true;
			}
			
			findStartPoint();
			System.out.println(cnt);
		}
		
	}
	
	public static void findStartPoint() {
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (map[i][j]) {
					map[i][j] = false;
					++cnt;
					dfs(i, j);
				}
			}
		}
	}
	
	public static void dfs(int x, int y) {
		for (int d = 0; d < 4; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];
			
			if(nx < 0 || nx >= m || ny < 0 || ny >= n || !map[nx][ny]) {
				continue;
			}
			
			map[nx][ny] = false;
			dfs(nx, ny);
		}
	}

}
