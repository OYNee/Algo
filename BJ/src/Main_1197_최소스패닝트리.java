import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1197_최소스패닝트리 {

	static class Edge implements Comparable<Edge> {
		int v1, v2;
		long cost;

		public Edge(int v1, int v2, long cost) {
			super();
			this.v1 = v1;
			this.v2 = v2;
			this.cost = cost;
		}

		@Override
		public int compareTo(Edge o) {
			// TODO Auto-generated method stub
			return Long.compare(this.cost, o.cost);
		}
	}

	static int V, E, ans, parents[], rank[];
	static Edge[] edge;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());

		edge = new Edge[E];
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			edge[i] = new Edge(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken()));
		}

		Arrays.sort(edge);
		parents = new int[V + 1];
		rank = new int[V + 1];
		for (int i = 0; i < args.length; i++)
			makeSet(i);

		for (int i = 1; i <= V; i++)
			parents[i] = i;

		int ans = 0;
		for (int i = 0; i < E; i++) {
			int p = findSet(edge[i].v1);
			int q = findSet(edge[i].v2);

			if (p == q)
				continue;
			parents[q] = p;
			ans += edge[i].cost;
		}

		System.out.println(ans);
	}

	static void makeSet(int x) {
		parents[x] = x;
	}

	static int findSet(int x) {
		if (x == parents[x])
			return x;
		else {
			parents[x] = findSet(parents[x]);
			return parents[x];
		}
	}

	static void union(int x, int y) {
		int px = findSet(x);
		int py = findSet(y);
		if (rank[px] > rank[py]) {
			parents[py] = px;
		} else {
			parents[px] = py;
			if (rank[px] == rank[py]) {
				rank[py]++;
			}
		}
	}
}
