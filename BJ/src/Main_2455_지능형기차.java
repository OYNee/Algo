import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2455_지능형기차 {
	static int total;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int max = 0;
		for (int i = 0; i < 4; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			total -= Integer.parseInt(st.nextToken());
			total += Integer.parseInt(st.nextToken());
			if(max < total)
				max = total;
		}
		System.out.println(max);
	}
}