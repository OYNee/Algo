import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 1. swap, 2-1. visited 2-2. visited를 비트연산으로
public class Permutation_visited {
	static boolean[] visited;
	static int[] arr;
	static int N, M;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		visited = new boolean[N];
		arr = new int[M];

		dfs(0);
		
		System.out.print(sb.toString());
	}

	public static void dfs(int num) {
		if (num == M) {
			for (int i = 0; i < M; i++) {
				sb.append(arr[i]+" ");
			}
			sb.append("\n");
			return;
		}

		for (int i = 1; i <= N; i++) {
			if (!visited[i - 1]) {
				visited[i - 1] = true;
				arr[num] = i;
				dfs(num + 1);
				visited[i - 1] = false;
			}
		}
	}
}
