import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SubSet_부분집합 {
	static int N, arr[];
	static boolean isSelected[];
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		isSelected = new boolean[N];
		
		subSet(0);
		
		System.out.println(sb.toString());
	}
	private static void subSet(int depth) {
		if (depth == N) {	//모든 수에 대해 방문 or 미방문 체크를 끝낸 후
			for (int i = 0; i < N; i++) {
				sb.append(isSelected[i] ? arr[i] + " " : "");
			}
			sb.append("\n");
			return;
		}
		isSelected[depth] = true;
		subSet(depth+1);
		isSelected[depth] = false;
		subSet(depth+1);
	}

}
