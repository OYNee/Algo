package N과M;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 작성자: 오유민
 * 작성 날짜: 20200505
 * 키워드: 중복순열
 * 난이도: Silver II
 * 제출까지 걸린 시간: 7분 50초
 */
public class Main_15665_N과M_11번_중복순열 {
	static int N, M, arr[], print[];
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		arr = new int[N];
		print = new int[M];

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr);
		permutation(0);

		System.out.print(sb.toString());
	}

	private static void permutation(int depth) {
		if (depth == M) {
			for (int i = 0; i < M; i++) {
				sb.append(print[i] + " ");
			}
			sb.append("\n");
			return;
		}
		for (int i = 0; i < N; i++) {
			if (print[depth] != arr[i]) {
				for (int j = depth; j < M; j++) {
					print[j] = 0;
				}
				print[depth] = arr[i];
				permutation(depth + 1);
			}
		}
	}

}
