import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
 * 작성자: 오유민
 * 작성 날짜: 20200517
 * 키워드: 완전 탐색
 * 난이도: Silver V
 * 제출까지 걸린 시간: 대략 한 시간
 */
public class Main_1018_체스판다시칠하기 {
	static char[][] board;
	static int N, M, cnt, ans = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		board = new char[N][M];
		for (int i = 0; i < N; i++) {
			String tmp = br.readLine();
			for (int j = 0; j < M; j++) {
				board[i][j] = tmp.charAt(j);
			}
		}
		for (int i = 0; i <= N-8; i++) {
			for (int j = 0; j <= M-8; j++) {
//				System.out.println("i&j: " + i + " " + j);
				paint('W', true, i, j);
				paint('B', false, i, j);
				if (ans > cnt) {
					ans = cnt;
				}
				cnt = 0;
//				System.out.println("ans1: " + ans);
				paint('B', true, i, j);
				paint('W', false, i, j);
				if (ans > cnt) {
					ans = cnt;
				}
//				System.out.println("ans2: " + ans);
				cnt = 0;
			}
		}
		
		System.out.println(ans);

	}

	private static void paint(char color, boolean isFirst, int r, int c) {
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j += 2) {
				if (j == 0 && isFirst) {
					isFirst = false;
				} else if (j == 0 && !isFirst) {
					j = 1;
					isFirst = true;
				}
				if (board[r+i][c+j] != color) {
					++cnt;
				}
				if (ans <= cnt) {
					return;
				}
				
			}
		}
	}

}
