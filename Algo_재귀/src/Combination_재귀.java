import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Combination_재귀 {
	static int N, M, arr[];
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		arr = new int[M];
		
		long start = System.currentTimeMillis(); // 시작하는 시점 계산
		combination(0, 0);
		
		long end = System.currentTimeMillis(); // 프로그램이 끝나는 시점 계산
		System.out.print(sb.toString());
		
		System.out.println("실행 시간 : " + (end - start) / 1000.0 + "초"); // 실행 시간 계산 및 출력
	}

	private static void combination(int depth, int cnt) { // 재귀의 깊이, 뽑은 갯수
		if (cnt == M) {
			for (int i = 0; i < M; i++) {
				sb.append((arr[i]) + " ");
			}
			sb.append("\n");
			return;
		}
		// 이 종료 조건은 특수 상황에서 유리해진다 -> M과 N이 비슷한 수일 때!
		if (N-depth < M-cnt) {
			return;
		}
		//////////////////////////////////////////////
		if (depth == N) {
			return;
		}
		arr[cnt] = depth + 1;
		combination(depth + 1, cnt + 1); // 뽑은 경우
		combination(depth + 1, cnt); // 뽑지 않은 경우
	}

}
