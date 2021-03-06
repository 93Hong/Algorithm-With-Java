import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static int M, N, K;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int[][] map;
	static boolean[][] visit;
	static ArrayList<Integer> ans;
	static Queue<Point> q;
	static int dir[][] = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

	public static void main(String args[]) throws IOException {
		String[] sub = br.readLine().split(" ");
		M = Integer.parseInt(sub[0]);
		N = Integer.parseInt(sub[1]);
		K = Integer.parseInt(sub[2]);

		map = new int[M][N];
		visit = new boolean[M][N];
		ans = new ArrayList<>();
		q = new LinkedList<Point>();

		while (K-- > 0) {
			int x, y, xx, yy;
			String s[] = br.readLine().split(" ");
			x = Integer.parseInt(s[0]);
			y = M - Integer.parseInt(s[1]);
			xx = Integer.parseInt(s[2]);
			yy = M - Integer.parseInt(s[3]);

			for (int i = yy; i < y; i++) {
				for (int j = x; j < xx; j++) {
					map[i][j] = 1;
				}
			}
		}

		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 0 && visit[i][j] == false) {
					q.add(new Point(i, j));
					map[i][j] = 1;
					visit[i][j] = true;
					solve();
				}
			}
		}

		ans.sort(null);
		
		System.out.println(ans.size());
		for (int i = 0; i < ans.size(); i++) {
			System.out.print(ans.get(i) + " ");
		}
	}

	public static void solve() {
		
		int cnt = 1;

		while (!q.isEmpty()) {
			int y = q.peek().y;
			int x = q.peek().x;
			q.poll();

			for (int k = 0; k < 4; k++) {
				int yy = y + dir[k][0];
				int xx = x + dir[k][1];

				if (yy < 0 || yy >= M || xx < 0 || xx >= N)
					continue;
				if (map[yy][xx] == 0 && visit[yy][xx] == false) {
					q.add(new Point(yy, xx));
					map[yy][xx] = 1;
					visit[yy][xx] = true;
					cnt++;
				}
			}
		}
		ans.add(cnt);
	}

	public static class Point {
		int y, x;

		Point(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}
}
