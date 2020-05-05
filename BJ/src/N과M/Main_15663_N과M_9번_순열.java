package N과M;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 작성자: 오유민
 * 작성 날짜: 20200504
 * 키워드: 순열
 * 난이도: Silver II
 * 제출까지 걸린 시간: 23분
 */
public class Main_15663_N과M_9번_순열 {
	static int N, M, arr[], print[];
	static boolean visited[];
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		arr = new int[N];
		print = new int[M];
		visited = new boolean[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);

		permutation(0);

		System.out.println(sb.toString());
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
			if (!visited[i] && print[depth] != arr[i]) {
				for (int j = depth; j < M; j++) {
					print[j] = 0;
				}
				visited[i] = true;
				print[depth] = arr[i];
				permutation(depth + 1);
				visited[i] = false;
			}
		}

	}
}
