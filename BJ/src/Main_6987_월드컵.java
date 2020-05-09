import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_6987_월드컵 {
	static int rt[][], valid;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int tc = 0; tc < 4; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			rt = new int[6][3];
			for (int i = 0; i < 6; i++) {
				for (int j = 0; j < 3; j++) {
					rt[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			valid = 0;
			dfs(0, 1);
			sb.append(valid + " ");

		}
		System.out.println(sb.toString());
	}

	private static void dfs(int teamA, int teamB) {
		if (teamB == 6) {
			dfs(teamA + 1, teamA + 2);
			return;
		}
		if (teamA > 4) {
			for (int i = 0; i < 6; i++) {
				for (int j = 0; j < 3; j++) {
					if (rt[i][j] > 0) {
						valid = 0;
						return;
					}
				}
			}
			valid = 1;
			return;
		}

		for (int i = 0, j = 2; i < 3; i++, j--) {
			if (rt[teamA][i] > 0 && rt[teamB][j] > 0) {
				rt[teamA][i]--;
				rt[teamB][j]--;
				dfs(teamA, teamB + 1);
				rt[teamA][i]++;
				rt[teamB][j]++;
			}
		}
	}
}
