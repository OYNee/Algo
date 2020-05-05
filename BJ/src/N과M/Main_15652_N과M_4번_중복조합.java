package N과M;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 작성자: 오유민
 * 작성 날짜: 20200505
 * 키워드: 중복순열
 * 난이도: Silver III
 * 제출까지 걸린 시간: 15분 44초
 */
public class Main_15652_N과M_4번_중복조합 {
	static int N, M, arr[];
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[M];

		comb(0, 0);
//		dfs(0);

		System.out.println(sb.toString());
	}

	private static void comb(int depth, int cnt) {
		if (cnt == M) {
			for (int i = 0; i < M; i++) {
				sb.append(arr[i] + " ");
			}
			sb.append("\n");
			return;
		}
		if (depth == N) {
			return;
		}
		arr[cnt] = depth + 1;
		comb(depth, cnt + 1);
		comb(depth + 1, cnt);

	}

	public static void dfs(int n) {
		if (n == M) {
			for (int i = 0; i < M; i++) {
				sb.append(arr[i]+" ");
			}
			sb.append("\n");
			return;
		}
		for (int i = 1; i <= N; i++) {
			if (n == 0 || arr[n-1] <= i) {
				arr[n] = i;
				dfs(n+1);
			}
		}
	}
}
