import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
/*
 * 작성자: 오유민
 * 작성 날짜: 20200504
 * 키워드: 순열
 * 난이도: Silver III
 * 제출까지 걸린 시간: 9분
 * + 입력부에서 실수 한 번 있었음
 */
public class Main_15654_N과M_5번 {
	static int N, M, arr[], ans[];
	static boolean[] visited;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N];
		visited = new boolean[N];
		ans = new int[M];
		st = new StringTokenizer(br.readLine(), " ");
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
				sb.append(ans[i] + " ");
			}
			sb.append("\n");
			return;
		}
		for (int i = 0; i < N; i++) {
			if (!visited[i]) {
				visited[i] = true;
				ans[depth] = arr[i];
				permutation(depth+1);
				visited[i] = false;
			}
		}
	}

}
