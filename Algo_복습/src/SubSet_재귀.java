import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 1일차: 6분 18초
 * 2일차: 4분 16초
 */
public class SubSet_재귀 {
	static int N, arr[];
	static boolean isSelected[];
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		isSelected = new boolean[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		subset(0);
		System.out.println(sb.toString());
	}

	private static void subset(int depth) {
		if (depth == N) {
			for (int i = 0; i < N; i++) {
				sb.append(isSelected[i] ? arr[i] + " " : "");
			}
			sb.append("\n");
			return;
		}
		isSelected[depth] = true;
		subset(depth + 1);
		isSelected[depth] = false;
		subset(depth + 1);
	}

}
