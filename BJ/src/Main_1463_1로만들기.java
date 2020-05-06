import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
/*
 * 작성자: 오유민
 * 작성 날짜: 20200505
 * 키워드: bfs
 * 난이도: Silver III
 * 제출까지 걸린 시간: 41분 23초
 */
public class Main_1463_1로만들기 {
	static class X {
		int X;
		int cnt;

		X(int X, int cnt) {
			this.X = X;
			this.cnt = cnt;
		}
	}

	static int ans;
	static boolean[] visited = new boolean[1000001];
	
	static Queue<X> q = new LinkedList<>();
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		X x = new X(Integer.parseInt(br.readLine()), 0);
		q.add(x);

		bfs();
		sb.append(ans);
		System.out.println(sb.toString());
	}

	private static void bfs() {

		while (!q.isEmpty()) {
			X tmp = q.poll();
			if (tmp.X == 1) {
				ans = tmp.cnt;
				break;
			}
			if (tmp.X % 3 == 0 && !visited[tmp.X % 3]) {
				visited[tmp.X/3] = true;
				q.add(new X(tmp.X/3, tmp.cnt+1));
			}
			if (tmp.X % 2 == 0 && !visited[tmp.X % 2]) {
				visited[tmp.X/2] = true;
				q.add(new X(tmp.X / 2, tmp.cnt+1));
			}
			if (!visited[tmp.X - 1]) {
				visited[tmp.X - 1] = true;
				q.add(new X(tmp.X-1, tmp.cnt+1));
			}
			
		}
	}

}
