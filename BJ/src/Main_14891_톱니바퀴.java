import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14891_톱니바퀴 {
	static String topni[];
	static int orderN;
	static int dir, num;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		topni = new String[5];
		for (int i = 1; i < 5; i++) {
			topni[i] = br.readLine();
		}
		orderN = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for (int i = 0; i < orderN; i++) {
			st = new StringTokenizer(br.readLine());
			num = Integer.parseInt(st.nextToken());
			dir = Integer.parseInt(st.nextToken());
			int tmpDir = dir;
			for (int j = num; j < 5; j++) {
				if (j != num && topni[j].charAt(6) == topni[j-1].charAt(2+dir*-1)) {
					break;
				}
				if (dir == 1) {
					String tmp = topni[j].substring(7);
					String tmp2 = topni[j].substring(0,7);
					topni[j] = tmp.concat(tmp2);
				} else {
					String tmp = topni[j].substring(0,1);
					String tmp2 = topni[j].substring(1);
					topni[j] = tmp2.concat(tmp);
				}
				dir *= -1;
			}
			dir = tmpDir * -1;
			for (int j = num - 1; j > 0; j--) {
				if (j != num && topni[j].charAt(2) == topni[j+1].charAt(6+dir*-1)) 
					break;
				
				if (dir == 1) {
					String tmp = topni[j].substring(7);
					String tmp2 = topni[j].substring(0,7);
					topni[j] = tmp.concat(tmp2);
				} else {
					String tmp = topni[j].substring(0,1);
					String tmp2 = topni[j].substring(1);
					topni[j] = tmp2.concat(tmp);
				}
				dir *= -1;
			}
		}
		
		int ans = 0;
		for (int i = 1; i < 5; i++) {
			int tmp = topni[i].charAt(0) - '0';
			if (tmp == 1) {
				ans += Math.pow(2, i-1);
			}
		}
		System.out.println(ans);
	}

}