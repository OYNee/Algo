import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 1일차: 5분 49초	(순열)
// 2일차: 5분 (순열)
// 3일차: 4분 39초(중복 순열)
// 4일차: 4분 17초(순열)
public class Permutation_visited {
	static int N, M, arr[], print[];
	static boolean visited[];
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N];
		print = new int[M];
		visited = new boolean[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		perm(0);
		System.out.println(sb.toString());
	}

	private static void perm(int depth) {
		if (depth == M) {
			for (int i = 0; i < M; i++) {
				sb.append(print[i] + " ");
			}
			sb.append("\n");
			return;
		}
		for (int i = 0; i < N; i++) {
			if (!visited[i]) {
				visited[i] = true;
				print[depth] = arr[i];
				perm(depth + 1);
				visited[i] = false;
			}
		}
	}
}
