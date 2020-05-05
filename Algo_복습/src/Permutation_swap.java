import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Permutation_swap {
	static int N, M, arr[];
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = i+1;
		}
		
		swap(0);
		
		System.out.println(sb.toString());
	}
	private static void swap(int depth) {
		if (depth == M) {
			for (int i = 0; i < M; i++) {
				sb.append(arr[i] + " ");
			}
			sb.append("\n");
			return;
		}
		for (int i = depth; i < N; i++) {
			int tmp = arr[depth];
			arr[depth] = arr[i];
			arr[i] = tmp;
			swap(depth+1);
			tmp = arr[depth];
			arr[depth] = arr[i];
			arr[i] = tmp;
		}
	}

}
