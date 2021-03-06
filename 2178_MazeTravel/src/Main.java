import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int N, M;
	static Queue<Point> q;
	static char[][] map;
	static int[][] visit;
	static int[][] dir = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

	public static void main(String args[]) throws IOException {

		String input = br.readLine();
		String sub[] = input.split(" ");
		N = Integer.parseInt(sub[0]);
		M = Integer.parseInt(sub[1]);

		map = new char[N][M];
		visit = new int[N][M];

		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
		}
		q = new LinkedList<>();
		q.add(new Point(0, 0));
		visit[0][0] = 1;
		
		solve();

		System.out.println(visit[N-1][M-1]);
	}

	public static void solve() {

		while (!q.isEmpty()) {
			int y = q.peek().y;
			int x = q.peek().x;
			q.poll();
			

			for (int i = 0; i < 4; i++) {
				
				int dy = y + dir[i][0];
				int dx = x + dir[i][1];
				
				if (dy < 0 || dy >= N || dx < 0 || dx >= M)
					continue;
				
				if (visit[dy][dx] == 0 && map[dy][dx] == '1') {
					q.add(new Point(dy, dx));
					visit[dy][dx] = visit[y][x] + 1;
				}
				
			}
		}
	}

	static class Point {
		int y, x;

		Point(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}
}