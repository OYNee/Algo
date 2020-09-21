import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 백준 3579번
 * 키워드: DP
 */
public class Main_2579_계단오르기 {
	static int N, step[], dp[];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		step = new int[N];
		dp = new int[N];

		for (int i = 0; i < N; i++) {
			step[i] = Integer.parseInt(br.readLine());
		}
		int tmp1 = 0, tmp2 = 0;
		dp[0] = step[0];
		if (N == 1) {
			System.out.println(dp[N - 1]);
			return;
		}
		dp[1] = ((tmp1 = step[0] + step[1]) >= (tmp2 = step[1])) ? tmp1 : tmp2;
		if (N == 2) {
			System.out.println(dp[N - 1]);
			return;
		}

		dp[2] = ((tmp1 = step[0] + step[2]) >= (tmp2 = step[1] + step[2])) ? tmp1 : tmp2;

		for (int i = 3; i < N; i++) {
			dp[i] = ((tmp1 = dp[i - 2] + step[i]) >= (tmp2 = dp[i - 3] + step[i - 1] + step[i])) ? tmp1 : tmp2;
		}

		System.out.println(dp[N - 1]);
	}

}
