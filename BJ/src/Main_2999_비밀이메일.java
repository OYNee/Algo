
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_2999_비밀이메일 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int len = str.length();
		int min = Integer.MAX_VALUE;
		int m = 0;	//행
		int n = 0;	//열
		
		//행과 열을 구하는 부분
		for (int i = 1; i <= len/2; i++) {
			int a = len/i;
			if(len%i == 0) {
				if(min > Math.abs(a - i)) {
					min = Math.abs(a - i);
					m = i;
					n = a;
					
				}
			}
		}
		int idx = 0;
		int tmp = 0;
		for (int i = 0; i < len; i++) {
			if(i != 0 && i%n == 0) {
				tmp++;
				idx = 0;
				idx += tmp;
			}
			
		System.out.print(str.charAt(idx));
		idx+=m;
		}
		
		
	}

}
