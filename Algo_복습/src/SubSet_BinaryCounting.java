import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SubSet_BinaryCounting {
	static int N, num, arr[];
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		num = 1 << N;
		subset();

		System.out.println(sb.toString());
	}

	private static void subset() {
		for (int flag = 0; flag < num; flag++) {
			for (int j = 0; j < N; j++) {
				sb.append((flag & 1 << j) != 0 ? arr[j] + " ": "");
			}
			sb.append("\n");
		}
	}

}
