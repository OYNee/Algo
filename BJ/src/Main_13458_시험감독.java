import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class Main_13458_시험감독 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int placeNum = Integer.parseInt(br.readLine());
		int[] student = new int[placeNum];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < placeNum; i++) {
			student[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		int mainSupervisor = Integer.parseInt(st.nextToken());
		int subSupervisor = Integer.parseInt(st.nextToken());
		long allSupervisorNum = placeNum;
		for (int i = 0; i < placeNum; i++) {
			student[i] -= mainSupervisor;
			if (student[i] <=0)
				continue;
			allSupervisorNum += Math.ceil((double)student[i]/subSupervisor);
		}
		System.out.println(allSupervisorNum);
	}
}
