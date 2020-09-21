import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1120_문자열 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		String shortS = st.nextToken();
		String longS = st.nextToken();
		int min = Integer.MAX_VALUE;
		for (int i = 0; i <= longS.length() - shortS.length(); i++) {
			String tmp = longS.substring(i);
			int diffChar = 0;
			for (int j = 0; j < shortS.length(); j++) {
				if (tmp.charAt(j) != shortS.charAt(j)) {
					++diffChar;
				}
			}
			if (min > diffChar) {
				min = diffChar;
			}
		}
		
		System.out.println(min);
	}
}
