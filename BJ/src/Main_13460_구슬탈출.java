import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_13460_구슬탈출 {
	static class Marble {	//구슬 클래스, 좌표와 탈출 여부
		int rx, ry, bx, by, cnt;
		Marble(int rx, int ry, int bx, int by, int cnt) {
			this.rx = rx;
			this.ry = ry;
			this.bx = bx;
			this.by = by;
			this.cnt = cnt;
		}
	}
	
	static int m, n;	//가로, 세로
	static char[][] map;	//보드 맵
//	static boolean[][] visit;
	
	static Queue<Marble> q;		//구슬을 넣을 큐
	
	static int[] dx = {-1,0,1,0};	//사방탐색 x좌표, y좌표
	static int[] dy = {0,1,0,-1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		
		map = new char[m][n];
		q = new LinkedList<>();
		
		int bx = 0, by = 0;
		int rx = 0, ry = 0;
		for (int i = 0; i < m; i++) {
			String tmp = br.readLine();
			for (int j = 0; j < n; j++) {
				map[i][j] = tmp.charAt(j);
				if (map[i][j] == 'R') {
					rx = i;
					ry = j;
					map[i][j] = '.';
				}
				if (map[i][j] == 'B') {
					bx = i;
					by = j;
					map[i][j] = '.';
				}
			}
		}
		
		q.add(new Marble(rx, ry, bx, by, 0));
		//bfs호출해서 결과값 출력
		System.out.println(bfs());
	}
	
	//구슬탈출 bfs 메소드
	public static int bfs() {
		
		while(!q.isEmpty()) {
			Marble tmp = q.poll();
			
			if (tmp.cnt >= 10) {	//움직임 횟수가 10이 넘어가면 게임 실패
				return -1;
			}
			
			for (int d = 0; d < 4; d++) {
				boolean findHoleRed = false;
				boolean findHoleBlue = false;
				char[][] marblePoint = new char[m][n];
				int nbx = tmp.bx;
				int nby = tmp.by;
				int nrx = tmp.rx;
				int nry = tmp.ry;
				marblePoint[nbx][nby] = 'B';
				marblePoint[nrx][nry] = 'R';
				if ((map[nbx+dx[d]][nby+dy[d]] == '#' || marblePoint[nbx+dx[d]][nby+dy[d]] == 'R') && (map[nrx+dx[d]][nry+dy[d]] == '#' || marblePoint[nrx+dx[d]][nry+dy[d]] == 'B'))	// 두 구슬 모두 움직일 수 없는 상태 
					continue;
				
				while ((map[nbx+dx[d]][nby+dy[d]] != '#' && marblePoint[nbx+dx[d]][nby+dy[d]] != 'R') || (map[nrx+dx[d]][nry+dy[d]] != '#' && marblePoint[nrx+dx[d]][nry+dy[d]] != 'B')) {
					while (map[nbx+dx[d]][nby+dy[d]] != '#' && marblePoint[nbx+dx[d]][nby+dy[d]] != 'R') {
						marblePoint[nbx][nby] = '.';
						nbx += dx[d];
						nby += dy[d];
						if(map[nbx][nby] == 'O') 	//파란 구슬이 홀에 빠지면
							findHoleBlue = true;
						else
							marblePoint[nbx][nby] = 'B';
					}
					while (map[nrx+dx[d]][nry+dy[d]] != '#' && marblePoint[nrx+dx[d]][nry+dy[d]] != 'B') {
						marblePoint[nrx][nry] = '.';
						nrx += dx[d];
						nry += dy[d];
						if(map[nrx][nry] == 'O') 	//빨간 구슬이 홀에 빠지면
							findHoleRed = true;
						else
							marblePoint[nrx][nry] = 'R';
					}
				}
				if (findHoleBlue)
					continue;
				else if (findHoleRed)	//빨간 구슬이 홀로 빠지면 return
					return tmp.cnt + 1;
				
				q.add(new Marble(nrx, nry, nbx, nby, tmp.cnt + 1));
				
			}
		}
		return -1;	//큐가 모두 비도록 홀에 도착하지 못한 경우
	}
}
