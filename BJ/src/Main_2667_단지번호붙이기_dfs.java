import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
/*
 * 작성자: 오유민
 * 작성 날짜: 20200506
 * 키워드: dfs
 * 난이도: Silver I
 * 제출까지 걸린 시간: 25분 28초
 */
public class Main_2667_단지번호붙이기_dfs {
	static int N, map[][], cnt;
	static boolean visited[][];
	static ArrayList<Integer> l = new ArrayList<>();
	
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
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
					cnt = 0;
					dfs(i, j);
					l.add(cnt);
				}
			}
		}
		Collections.sort(l);
		int size = l.size();
		sb.append(size + "\n");
		for (int i = 0; i < size; i++) {
			sb.append(l.get(i) + "\n");
		}
		System.out.print(sb.toString());
	}

	private static void dfs(int x, int y) {
		++cnt;
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if (nx < 0 || ny < 0 || nx >= N || ny >= N || visited[nx][ny] || map[nx][ny] == 0) {
				continue;
			}
			visited[nx][ny] = true;
			dfs(nx,ny);
		}
	}
}
