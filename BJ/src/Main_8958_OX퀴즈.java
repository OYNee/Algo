import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_8958_OX퀴즈 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		for (int testCase = 0; testCase < TC; testCase++) {
			String ox = br.readLine();
			int sum = 0;
			int serialO = 0;
			for (int i = 0; i < ox.length(); i++) {
				if (ox.charAt(i) == 'O') {
					++serialO;
					sum+= serialO;
				} else {
					serialO = 0;
				}
			}
			System.out.println(sum);
		}
	}
}