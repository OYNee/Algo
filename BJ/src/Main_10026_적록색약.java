import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main_10026_적록색약 {

	static class Node {	//좌표와 현재 컬러값을 저장할 노드
		int x, y, color;
		
		public Node(int x, int y, int color) {
			this.x = x;
			this.y = y;
			this.color = color;
		}
	}
	
	static int n, map[][];	//맵의 가로 세로 크기, 맵
	static boolean visited[][];	//방문체크
	
	static int[] dx = {-1,0,1,0};	//사방탐색 좌표
	static int[] dy = {0,1,0,-1};
	static Queue<Node> q;	//bfs 큐
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		visited = new boolean[n][n];
		q = new LinkedList<>();
		
		for (int i = 0; i < n; i++) {
			String tmp = br.readLine();
			for (int j = 0; j < n; j++) {
				switch(tmp.charAt(j)) {
				case 'R':
					map[i][j] = 0;
					break;
				case 'G':
					map[i][j] = 1;
					break;
				case 'B':
					map[i][j] = 2;
					break;
				}
			}
		}
		System.out.print(findStartPoint() + " ");
		setVisited();
		setColorWeakness();
		System.out.print(findStartPoint());
		
	}
	
	public static void setVisited() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				visited[i][j] = false;
			}
		}
	}
	
	public static void setColorWeakness() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (map[i][j] == 1) {
					map[i][j] = 0;
				}
			}
		}
	}
	
	public static int findStartPoint() {
		int count = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (visited[i][j] != true) {
					q.add(new Node(i, j, map[i][j]));
					visited[i][j] = true;
					bfs();
					count++;
				}
			}
		}
		
		return count;
	}
	
	public static void bfs() {
		while(!q.isEmpty()) {
			Node tmp = q.poll();
			for (int d = 0; d < 4; d++) {
				int nx = tmp.x+dx[d];
				int ny = tmp.y+dy[d];
				
				if (nx < 0 || nx > n-1 || ny < 0 || ny > n-1 || visited[nx][ny] || tmp.color != map[nx][ny]) 
					continue;
				
				visited[nx][ny] = true;
				q.add(new Node(nx, ny, tmp.color));
			}
		}
	}
}
