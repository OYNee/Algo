import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1697_숨바꼭질 {

	static class Node {
		int pos, count;
		Node(int p, int c) {
			this.pos = p;
			this.count = c;
		}
	}
	//누나와 동생의 위치
	static int x, y;
	static int count;
	static int[] visited = new int[100001];
	static Queue<Node> q = new LinkedList<>();
	static int[] dx = {-1, 1, 2};
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		
		if(x == y) {
			System.out.println(0);
			return;
		}
		
		q.add(new Node(x, 1));
		
		bfs();
		print_result();
		
	}	//end of main
	
	public static void bfs() {
		while(!q.isEmpty()) {
			Node tmp = q.poll();
			
			for(int d = 0; d < 3; d++) {
				int nx = 0;
				switch(d) {
				case 0:
				case 1:
					nx = tmp.pos + dx[d];
					break;
				case 2:
					nx = tmp.pos * dx[d];
					break;
				}
				if(isValid(nx) == false) {
					continue;
				}
				
				if(nx == y) {
					visited[nx] = tmp.count;
					q.clear();
					break;
				} else {
					visited[nx] = tmp.count;
					q.add(new Node(nx, tmp.count + 1));
					
				}
			}	//end of for
		}	//end of while
	}	//end of bfs
	
	
	

	
	public static boolean isValid(int pos) {
	    if (pos < 0 || pos>100000)
	        return false;
	    if (visited[pos] != 0)
	        return false;
	    return true;
	}


	
	public static void print_result() {
		int max = 0;
		for (int i = 0; i < visited.length; i++) {
			if(max < visited[i]) {
				max = visited[i];
			}
		}
		System.out.println(max);
	}
}	//end of class
