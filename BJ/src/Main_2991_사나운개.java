import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2991_사나운개 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] DogsPattern = new int[4];
		for (int i = 0; i < DogsPattern.length; i++) {
			DogsPattern[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		int[] menPattern = new int[3];
		for (int i = 0; i < menPattern.length; i++) {
			menPattern[i] = Integer.parseInt(st.nextToken());
		}
		for (int i = 0; i < menPattern.length; i++) {
			int cnt = 0;
			cnt += menPattern[i] % (DogsPattern[0]+DogsPattern[1]) > DogsPattern[0] || menPattern[i] % (DogsPattern[0]+DogsPattern[1]) == 0 ? 0 : 1;
			cnt += menPattern[i] % (DogsPattern[2]+DogsPattern[3]) > DogsPattern[2] || menPattern[i] % (DogsPattern[2]+DogsPattern[3]) == 0 ? 0 : 1;
			System.out.print(cnt + " ");
		}
	}

}
