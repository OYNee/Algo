import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_1436_영화감독숌 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		int title = 666;
		while (true) {
			if(String.valueOf(title).contains("666")) {
				num--;
			}
			if(num <= 0) {
				System.out.println(title);
				return;
			}
			title++;
		}
		
	}
}
