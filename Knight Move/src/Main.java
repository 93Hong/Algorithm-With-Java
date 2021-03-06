import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int N, M, ans2;
	static int map[][];
	static Queue<Point> q = new LinkedList<>();
	static int dir[][] = { { 2, 1 }, { -2, 1 }, { 2, -1 }, { -2, -1 }, { 1, 2 }, { -1, 2 }, { 1, -2 }, { -1, -2 } };

	public static void main(String args[]) throws IOException {

		String input = br.readLine();
		String sub[] = input.split(" ");
		N = Integer.parseInt(sub[0]);
		M = Integer.parseInt(sub[1]);
		map = new int[N][M];

		int cnt = solve();
		
		if (cnt == N * M)
			System.out.println("T" + (ans2 - 1));
		else
			System.out.println("F" + (ans2 - 1));

	}

	public static int solve() {
		map[0][0] = 1;
		q.add(new Point(0, 0));
		int ans = 1;

		while (!q.isEmpty()) {
			int y = q.peek().y;
			int x = q.peek().x;
			q.poll();

			for (int i = 0; i < 8; i++) {
				int dy = y + dir[i][0];
				int dx = x + dir[i][1];

				if (dy < 0 || dy >= N || dx < 0 || dx >= M)
					continue;

				if (map[dy][dx] == 0) {
					map[dy][dx] = map[y][x] + 1;
					ans++;
					q.add(new Point(dy, dx));
					ans2 = map[dy][dx];
				}
			}
		}

		return ans;
	}

	static class Point {
		int y, x;

		Point(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}
}
