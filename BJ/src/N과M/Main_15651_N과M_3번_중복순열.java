package N과M;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 작성자: 오유민
 * 작성 날짜: 20200505
 * 키워드: 중복순열
 * 난이도: Silver III
 * 제출까지 걸린 시간: 6분 21초
 */
public class Main_15651_N과M_3번_중복순열 {
	static int N, M, arr[];
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N];

		permutation(0);

		System.out.println(sb.toString());
	}

	private static void permutation(int depth) {
		if (depth == M) {
			for (int i = 0; i < M; i++) {
				sb.append(arr[i] + " ");
			}
			sb.append("\n");
			return;
		}
		for (int i = 0; i < N; i++) {
			arr[depth] = i + 1;
			permutation(depth + 1);
		}
	}

}
