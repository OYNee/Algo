import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 1일차: 5분	(조합)
 * 2일차: 4분 31초 (중복조합)
 * 3일차: 3분 56초 (조합)
 */
public class Combination_재귀 {
	static int N, M, arr[], print[];
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N];
		print = new int[M];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		comb(0, 0);
		System.out.println(sb.toString());
	}

	private static void comb(int depth, int cnt) {
		if (cnt == M) {
			for (int i = 0; i < M; i++) {
				sb.append(print[i] + " ");
			}
			sb.append("\n");
			return;
		}
		if (depth == N) {
			return;
		}
		print[cnt] = arr[depth];
		comb(depth + 1, cnt + 1);
		comb(depth + 1, cnt);
	}

}
