import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 7시 47분  ~ 8시 19분

public class Main_2178_미로탐색 {
	static int M, N, map[][];
	static boolean[][] isVisited;
	static int ans;
	
	static int dx[] = {-1,0,1,0};
	static int dy[] = {0,1,0,-1};
	
	
	static Queue<Loc> q;
	
	static class Loc {
		int x;
		int y;
		int count;
		Loc(int x, int y, int count) {
			this.x = x;
			this.y = y;
			this.count = count;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new int[M][N];
		isVisited = new boolean[M][N];
		q = new LinkedList<>();
		for (int i = 0; i < M; i++) {
			String str = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = str.charAt(j)-'0';
			}
		}	// 입력부
		
		q.add(new Loc(0,0,1));
		isVisited[0][0] = true;
		bfs();
		
		System.out.println(ans);
		
		
	}

	private static void bfs() {
		
		while(!q.isEmpty()) {
			Loc tmp = q.poll();
			
			for (int i = 0; i < 4; i++) {
				int nx = tmp.x + dx[i];
				int ny = tmp.y + dy[i];
				if (nx < 0 || nx >= M || ny < 0 || ny >= N || isVisited[nx][ny] || map[nx][ny] == 0) {
					continue;
				}
				
				if (nx==M-1 && ny==N-1) {
					ans = tmp.count + 1;
					return;
				}
				q.add(new Loc(nx,ny,tmp.count+1));
				isVisited[nx][ny] = true;
			}
			
		}
		
	}

}
