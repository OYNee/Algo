import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
 * 작성자: 오유민
 * 작성 날짜: 20200510
 * 키워드: 조합
 * 난이도: Silver II
 * 제출까지 걸린 시간: 9분 35초
 */
public class Main_6603_로또 {
	static int N = -1, num[], print[];
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (N != 0) {
			sb = new StringBuilder();
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			num = new int[N];
			print = new int[6];
			for (int i = 0; i < N; i++) {
				num[i] = Integer.parseInt(st.nextToken());
			}
			comb(0, 0);
			System.out.println(sb);
		}
	}

	private static void comb(int depth, int cnt) {
		if (cnt == 6) {
			for (int i = 0; i < 6; i++) {
				sb.append(print[i] + " ");
			}
			sb.append("\n");
			return;
		}
		if (depth == N) {
			return;
		}
		print[cnt] = num[depth];
		comb(depth+1, cnt+1);
		comb(depth+1, cnt);
	}
	

}
