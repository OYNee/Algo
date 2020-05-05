import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Combination {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = i + 1;
		}
		boolean[] visited = new boolean[n];

		/////////////////////////////////////////////// 재귀
		long start = System.currentTimeMillis(); // 시작하는 시점 계산

		/*
		 * 실행시간을 측정하고싶은 코드
		 */
		for (int i = 1; i <= n; i++) {
			comb(arr, visited, 0, n, i);
		}

		long end = System.currentTimeMillis(); // 프로그램이 끝나는 시점 계산
		System.out.println("실행 시간 : " + (end - start) / 1000.0 + "초"); // 실행 시간 계산 및 출력

		//////////////////////////////////////////////////////////

		System.out.println();
		
		////////////////////////////////////////////////////// 백트래킹
		long start2 = System.currentTimeMillis(); // 시작하는 시점 계산
		for (int i = 1; i <= n; i++) {
			combination(arr, visited, 0, n, i);
		}

		long end2 = System.currentTimeMillis(); // 프로그램이 끝나는 시점 계산
		System.out.println("실행 시간 : " + (end2 - start2) / 1000.0 + "초"); // 실행 시간 계산 및 출력
		////////////////////////////////////////////////////////////

	}

	// 백트래킹 사용
	// 사용 예시 : combination(arr, visited, 0, n, r)
	static void combination(int[] arr, boolean[] visited, int start, int n, int r) {
		if (r == 0) {
			print(arr, visited, n);
			return;
		}

		for (int i = start; i < n; i++) {
			visited[i] = true;
			combination(arr, visited, i + 1, n, r - 1);
			visited[i] = false;
		}
	}

	// 재귀 사용
	// 사용 예시 : comb(arr, visited, 0, n, r)
	static void comb(int[] arr, boolean[] visited, int depth, int n, int r) {
		if (r == 0) {
			print(arr, visited, n);
			return;
		}

		if (depth == n) {
			return;
		} else {
			visited[depth] = true;
			comb(arr, visited, depth + 1, n, r - 1);
			visited[depth] = false;
			comb(arr, visited, depth + 1, n, r);
		}
	}

	// 배열 출력
	static void print(int[] arr, boolean[] visited, int n) {
		for (int i = 0; i < n; i++) {
			if (visited[i] == true)
				System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
}
