import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// 이해가 안되는 문제
public class Main_1325_효율적인해킹 {
	static ArrayList<Integer>[] a = (ArrayList<Integer>[]) new ArrayList[10001];
	static boolean[] visited = new boolean[10001];
	static int[] ans = new int[10001];
	static int cnt = 0;

	public static void main(String[] args)throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		for (int i = 1; i <= n; i++) {
			a[i] = new ArrayList<Integer>();
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());

			a[v1].add(v2);
		}

		int max = 0;
		for (int i = 1; i <= n; i++) {
			visited = new boolean[100001];
			dfs(i);
		}

		for (int i = 1; i <= n; i++) {
			if (max < ans[i]) {
				max = ans[i];
			}
		}

		for (int i = 1; i <= n; i++) {
			if (max == ans[i]) {
				sb.append(i + " ");
			}
		}

		System.out.println(sb.toString());
	}

	public static void dfs(int v) {
		visited[v] = true;

		for (int vv : a[v]) {
			if (!visited[vv]) {
				ans[vv]++;
				dfs(vv);
			}
		}
	}
}
