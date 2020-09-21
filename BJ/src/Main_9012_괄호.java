import java.io.BufferedReader;
import java.io.InputStreamReader;

//괄호검사
public class Main_9012_괄호 {

	static String s;
	static int top;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		
		
		for (int testCase = 1; testCase <= tc; testCase++) {
			top = -1;
			s = br.readLine();
			
			System.out.println((check()? "YES" : "NO"));
			
		}	//testCase만큼 반복
	}
	
	public static boolean check() {
		
		for (int i = 0; i < s.length(); i++) {
			if(s.charAt(i) == '(') {
				top++;
			} else if(s.charAt(i) == ')') {
				top--;
				if(top == -2) {
					return false;
				}
			}
		}
		if(top != -1)
			return false;
		return true;
	}
}
