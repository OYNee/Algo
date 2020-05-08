import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 1일차: 7분 53초(34번 라인 틀림)
 * 2일차: 3분 45초
 */
public class SubSet_BinaryCounting {
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
		subset();
		System.out.println(sb.toString());
	}
	private static void subset() {
		for (int flag = 0; flag < 1<<N; flag++) {
			for (int j = 0; j < N; j++) {
				sb.append((flag & 1<<j) != 0 ? arr[j] + " " : "");
			}
			sb.append("\n");
		}
	}
}
