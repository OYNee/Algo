import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

public class Main_9663_NQueens {
	static int N, ans, attack[][];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		attack = new int[N][N];
		dfs(0);
		System.out.println(ans);
	}

	private static void dfs(int r) {
		if (r == N) {
			++ans;
//			System.out.println("ans" + ans);
			return;
		}
		for (int c = 0; c < N; c++) { // c를 늘려나가면서 검사
			if (attack[r][c] == 0) { // 만약 어택횟수가 0인 곳이라면
				// 어택!
				// 다음 행으로가기(dfs(r + 1, 0))
				// 어택 취소!
				attack(r, c, 1);
//				print();
				dfs(r + 1);
				attack(r, c, -1);
//				print();
			}
		}
	}

	private static void attack(int r, int c, int x) {
		for (int i = 0; i < N; i++) {
			if (i != c) {
				attack[r][i] += x;
			}
			if (i != r) {
				attack[i][c] += x;
			}
		}
		for (int i = 1; i < r + 1 && i < N - c; i++) {
			attack[r - i][c + i] += x;
		}
		for (int i = 1; i < r + 1 && i < c + 1; i++) {
			attack[r - i][c - i] += x;
		}
		for (int i = 1; i < N - r && i < N - c; i++) {
			attack[r + i][c + i] += x;
		}
		for (int i = 1; i < N - r && i < c + 1; i++) {
			attack[r + i][c - i] += x;
		}
	}

//	private static void print() {
//		for (int i = 0; i < N; i++) {
//			for (int j = 0; j < N; j++) {
//				System.out.print(attack[i][j] + " ");
//			}
//			System.out.println();
//		}
//		System.out.println();
//	}

}
