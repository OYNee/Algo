import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 작성자: 오유민
 * 작성 날짜: 20200504
 * 키워드: 순열
 * 난이도: Silver III
 * 제출까지 걸린 시간: 5 분
 */
public class Main_10974_모든순열 {
	static int N, arr[];
	static boolean[] visited;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		visited = new boolean[N];
		
		permutation(0, 0);
		
		System.out.println(sb.toString());
	}
	private static void permutation(int depth, int flag) {
		if (depth==N) {
			for (int i = 0; i < N; i++) {
				sb.append(arr[i] + " ");
			}
			sb.append("\n");
			return;
		}
		for (int i = 0; i < N; i++) {
			if((flag & 1<<i) == 0) {	// 비트로 i자리가 꺼져있는지 확인 
				arr[depth] = i+1;
				permutation(depth+1, flag | 1<<i);	// 비트로 i자리 켜서 보내기
			}
		}
	}
}
