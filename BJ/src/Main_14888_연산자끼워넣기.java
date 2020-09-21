import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14888_연산자끼워넣기 {
	static int operand[], operator[], cnt[], N;
	static long max, min;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		operand = new int[N];
		operator = new int[4];
		cnt = new int[4];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			operand[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 4; i++) {
			operator[i] = Integer.parseInt(st.nextToken());
		}
		max = Long.MIN_VALUE;
		min = Long.MAX_VALUE;
		dfs(0, 1, operand[0]);
		
		System.out.println(max + "\n" + min);
	}
	public static void dfs(int num, int idx, long result) {
		if (num >= N-1) {
			if (result < min) {
				min = result;
			}
			if (result > max) {
				max = result;
			}
			return;
		}
		for (int i = 0; i < 4; i++) {
			if (cnt[i] != operator[i]) {
				++cnt[i];
				switch (i) {	//주의! 인자값을 훼손시키면 안된다. 다시 자신으로 돌아왔을 때 result값이 바뀌어 있으면 안되는것!
				case 0:
					dfs(num+1, idx+1, result + operand[idx]);
					break;
				case 1:
					dfs(num+1, idx+1, result -operand[idx]);
					break;
				case 2:
					dfs(num+1, idx+1, result * operand[idx]);
					break;
				case 3:
					dfs(num+1, idx+1, result / operand[idx]);
					break;
				}
				--cnt[i];
			}
		}
	}
}
