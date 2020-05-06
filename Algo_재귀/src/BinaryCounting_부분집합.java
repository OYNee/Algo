import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BinaryCounting_부분집합 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int arr[] = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 0; i < 1 << N; i++) {
			// 1 << n : 부분 집합의 개수
			for (int j = 0; j < N; j++) {
				// 원소의 수만큼 비트를 비교함
				if ((i & (1 << j)) != 0) {	// i의 j번째 비트가 1이면 j번째 원소 출력
					System.out.print(arr[j]+" ");
				}
			}
			System.out.println();
		}
	}

}
