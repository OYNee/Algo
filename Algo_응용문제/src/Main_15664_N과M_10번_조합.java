import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 작성자: 오유민
 * 작성 날짜: 20200505
 * 키워드: 조합
 * 난이도: Silver II
 * 제출까지 걸린 시간: 13분 13초
 */
public class Main_15664_N과M_10번_조합 {
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
		comb(0,0);
		System.out.print(sb.toString());
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
		if (print[cnt] != arr[depth]) {
			for (int i = cnt; i < M; i++) {
				print[i] = 0;
			}
			print[cnt] = arr[depth];
			comb(depth+1, cnt+1);
		}
		comb(depth+1, cnt);
	}

}
