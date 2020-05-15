import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2636_치즈 {
	static int cheese[][], M, N, size, preSize, cnt;
	static boolean visited[][];
	static int dx[] = {0, -1, 0, 1};
	static int dy[] = {-1, 0, 1, 0};
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		// 입력 및 초기화
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		cheese = new int[N][M];
		visited = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				cheese[i][j] = Integer.parseInt(st.nextToken());
				if (cheese[i][j] == 1) {
					++size;	// 치즈의 크기 +1;
				}
			}
		}
		
		preSize = size;
		spread();	// 공기를 찾아서 치즈가 전부 녹을 때까지 공기와 맞닿는 치즈부분을 녹이는 작업
		sb.append(cnt).append("\n").append(preSize).append("\n");
		System.out.print(sb);
		
	}	// end of main

	private static void spread() {
		visited[0][0] = true;
		while(true) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (cheese[i][j] == 0 &&!visited[i][j]) {
						if (findAir(i, j)) {	// 공기부분인지 확인
							dfs(i, j);
						}
					}
				}
			}
//			print();
			melt();
			
			++cnt;
			if (size == 0) {
				break;
			}
			preSize = size;
		}
	}	// end of spread

	private static void dfs(int x, int y) {	// 녹은 부분 visited 체크, 녹일 부분 찾기
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			// 범위 체크
			if (nx < 0 || ny < 0 || nx >= N || ny >= M || visited[nx][ny]) {
				continue;
			}
			if (cheese[nx][ny] == 1) {
				cheese[nx][ny] = -1;
				continue;
			}
			if (cheese[nx][ny] == 0) {
				visited[nx][ny] = true;
				dfs(nx, ny);
			}
		}
	}	// end of dfs
	
	private static void melt() {	// 공기와 맞닿은 부분 녹이기
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (cheese[i][j] == -1) {
					cheese[i][j] = 0;
					--size;
				}
			}
		}
	}	// end of melt
	
	private static boolean findAir(int i, int j) {
		for (int d = 0; d < 4; d++) {
			int nx = i + dx[d];
			int ny = j + dy[d];
			if (nx < 0 || ny < 0 || nx >= N || ny >= M || visited[nx][ny]) {
				return true;
			}
		}
		return false;
	}	// end of findAir

	private static void print() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(cheese[i][j] + "\t");
			}
			System.out.println();
		}
		System.out.println();
	}	// end of print(디버깅용)
	
}	// end of class
