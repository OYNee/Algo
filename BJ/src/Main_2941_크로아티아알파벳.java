
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_2941_크로아티아알파벳 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		String ss = s.replace("dz=", "1").replace("c=", "1").replace("c-", "1").replace("d-", "1").replace("lj", "1").replace("nj", "1").replace("s=", "1").replace("z=", "1");
		System.out.println(ss.length());
	}
}
