import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 1. swap, 2-1. visited 2-2. visited를 비트연산으로
public class Permutation_swap {
	static int N, M, arr[];
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = i + 1;
		}
		
		swap(0);
		
		System.out.println(sb);
	}	// end of main

	static void swap(int depth) {
		if (depth == M) {	// 재귀함수 종료 조건 -> 깊이가 M만큼 깊어졌음 = M개를 뽑았음
			//////////////////// 해야할 작업! -> 출력
			for (int i = 0; i < M; i++) {
				sb.append(arr[i]+" ");
			}
			sb.append("\n");
			////////////////////
			return;	// 종료!
		}
		for (int i = depth; i < N; i++) {
			int temp = arr[depth];
			arr[depth] = arr[i];
			arr[i] = temp;
			swap(depth + 1);
			temp = arr[depth];
			arr[depth] = arr[i];
			arr[i] = temp;
		}
	}	// end of swap
}	// end of class
