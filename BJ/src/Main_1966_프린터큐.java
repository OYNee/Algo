import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1966_프린터큐 {
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		
		for (int testCase = 0; testCase < TC; testCase++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			int idx = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			int[] arr = new int[num];
			for (int i = 0; i < num; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			int cur = 0;
			int cnt = 0;
			while (arr[idx] != -1) {
				int max = cur;
				for (int i = 0; i <num; i++) {
					cur++;
					if (cur >= num)
						cur = 0;
					if (arr[max] < arr[cur]) {
						max = cur;
					}
					
				}
				++cnt;
				arr[max] = -1;
				cur = max;
			}
			System.out.println(cnt);
		}
	}
}
