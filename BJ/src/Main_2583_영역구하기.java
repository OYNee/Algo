import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;



public class Main_2583_영역구하기 {
	static int m, n;
	static boolean[][] map;
	static Queue<Node> q;
	static int count = 0;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	static int[] box;
	
	static class Node {
		int x, y, cnt;
		Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		
		map = new boolean[m][n];
		int boxNum = Integer.parseInt(st.nextToken());
		
		q = new LinkedList<>();
		box = new int[100];
		
		
		for (int i = 0; i <boxNum ; i++) {
			
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			for (int k = y1; k < y2; k++) {
				for (int j = x1; j < x2; j++) {
					map[k][j] = true;
				}
			}
		}
		
//		printMap();
		
		findStart();
		printResult();
		
		
	}
	
	public static void findStart() {
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				
				if(!map[i][j]) {
					map[i][j] = true;
					q.add(new Node(i, j));
					box[count]++;
					bfs();
					count++;
				}
			}
		}
	}	
	public static void bfs() {
		
		while(!q.isEmpty()) {
			Node tmp = q.poll();
			
			for (int d = 0; d < 4; d++) {
				int nx = tmp.x + dx[d];
				int ny = tmp.y + dy[d];
			//사방 탐색 for문
				if (nx < 0 || nx > m-1 || ny < 0 || ny > n-1 || map[nx][ny]) {
					continue;
				}	//범위 체크
				
				box[count]++;
				map[nx][ny] = true;
				q.add(new Node(nx, ny));
				
			}
		}
	}	//bfs 탐색
	
	public static void printResult() {
		System.out.println(count);
		for (int i = 0; i < box.length; i++) {
			for (int j = i; j < box.length; j++) {
				if(box[i] > box[j]) {
					int tmp = box[j];
					box[j] = box[i];
					box[i] = tmp;
				}
			}
		}
		for (int i = 0; i < box.length; i++) {
			if(box[i] != 0)
				System.out.print(box[i] + " ");
		}
	}
	
	public static void printMap () {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				if(map[i][j])
					System.out.print(1 + " ");
				else
					System.out.print(0 + " ");
			}
			System.out.println();
		}
		
	}
}
