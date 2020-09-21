import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2606_바이러스 {

	static int net[], rank[], N, M;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine())+1;
		M = Integer.parseInt(br.readLine());
		net = new int[N];
		rank = new int[N];
		for(int i = 1; i < N; i++) {
            net[i] = i;
        }
		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			union(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		
		
		System.out.println(count());
	}
	public static int findSet(int x) {
		if(x == net[x]) {		//인덱스와 값이 같은 경우 
			return x;
		}
		net[x] = findSet(net[x]);
		return net[x];
	}

	public static void union(int x, int y) {
		int px = findSet(x);
		int py = findSet(y);
		if(rank[px]<rank[py]) {  // 트리 깊이 비교, 작은 것을 큰 것 아래에 붙이기(트리의 깊이 최소화)
			net[px] = py;  
		}
		else {
			net[py] = px;
			if(rank[px] == rank[py]) {
				rank[px]++;
			}
		}
	}
	
	public static int count() {
		int cnt = 0;
		for (int i = 2; i < N; i++) {
			if (net[i] == net[1]) {
				++cnt;
			}
			else {
				int px = findSet(net[i]);
				if (px == net[1]) {
					++cnt;
				}
			}
		}
		return cnt;
	}
}
