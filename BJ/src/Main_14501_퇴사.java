import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 작성자: 오유민
 * 작성 날짜: 20200508
 * 키워드: 조합
 * 난이도: Silver IV
 * 제출까지 걸린 시간: 24분 32초
 * + 종료 조건과 답을 갱신할 때의 조건을 조금 더 깔끔하게 줄 수 없을지 고민했음
 */

public class Main_14501_퇴사 {
	static int N, t[], p[], ans;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		t = new int[N];
		p = new int[N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			t[i] = Integer.parseInt(st.nextToken());
			p[i] = Integer.parseInt(st.nextToken());
		}
		comb(0,0);
		System.out.println(ans);
	}
	private static void comb(int day, int pay) {
		if (day <= N) {
			if (pay > ans) {
				ans = pay;
			}
		}
		if (day >= N) {
			return;
		}
		
		comb(day + t[day], pay + p[day]);
		comb(day+1, pay);
	}

}
