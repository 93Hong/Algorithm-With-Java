import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int N, M, a, b;
	static char map[][];
	static int visit2[][], visit[][], dir[][] = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
	static Queue<Point> q;

	public static void main(String args[]) throws IOException {
		int ans = 0, tmp;
		String sub[] = br.readLine().split(" ");
		N = Integer.parseInt(sub[0]);
		M = Integer.parseInt(sub[1]);
		map = new char[N][M];
		visit = new int[N][M];
		visit2 = new int[N][M];
		q = new LinkedList<>();

		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < s.length(); j++) {
				map[i][j] = s.charAt(j);
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 'L') {
					tmp = solve(i, j);
					if (tmp > ans)
						ans = tmp;
				}
			}
		}

		System.out.println(ans);
	}

	public static int solve(int y, int x) {
		q.add(new Point(y, x));
		visit[y][x] = 1;
		int yy = 0, xx = 0;
		
		for (int i=0; i<N; i++) {
			for (int j=0; j<M; j++) {
				visit[i][j] = 0;
			}
		}

		while (!q.isEmpty()) {
			yy = q.peek().y;
			xx = q.peek().x;
			q.poll();

			for (int i = 0; i < 4; i++) {
				int dy = yy + dir[i][0];
				int dx = xx + dir[i][1];

				if (dy < 0 || dy >= N || dx < 0 || dx >= M)
					continue;
				if (map[dy][dx] == 'L' && visit[dy][dx] == 0) {
					q.add(new Point(dy, dx));
					visit[dy][dx] = visit[yy][xx] + 1;
				}
			}
		}

		return visit[yy][xx];
	}

	public static class Point {
		int y, x;

		Point(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}
}
