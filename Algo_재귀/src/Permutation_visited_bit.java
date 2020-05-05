import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 1. swap, 2-1. visited 2-2. visited를 비트연산으로
public class Permutation_visited_bit {
	static int N, M;
	static int[] num;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		num = new int[M];
		
		permu(0,0);
		System.out.println(sb);
	}

	private static void permu(int index, int flag) throws IOException {
		if(index==M) {
			for (int i = 0; i < M; i++) {
				sb.append(num[i]).append(' ');
			}
			sb.append('\n');
			return;
		}
		// 자리수 방문 체크를 flag로 처리
		for (int i = 1; i <= N; i++) {
			if((flag & 1<<i) == 0) {	// 비트로 i자리가 꺼져있는지 확인 
				num[index] = i;
				permu(index+1, flag | 1<<i);	// 비트로 i자리 켜서 보내기
			}
		}
	}
}
