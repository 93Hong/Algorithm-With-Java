import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int n, x, y, m, level;
	static ArrayList<Point> arr;
	static Queue<Integer> q;
	static int[] visit;

	public static void main(String args[]) throws IOException {
		n = Integer.parseInt(br.readLine());
		String s[] = br.readLine().split(" ");
		arr = new ArrayList<>();
		q = new LinkedList<>();
		visit = new int[n + 1];
		x = Integer.parseInt(s[0]);
		y = Integer.parseInt(s[1]);
		m = Integer.parseInt(br.readLine());

		for (int i = 0; i < m; i++) {
			String s2[] = br.readLine().split(" ");
			int a = Integer.parseInt(s2[0]);
			int b = Integer.parseInt(s2[1]);
			arr.add(new Point(a, b));
			arr.add(new Point(b, a));
		}

		visit[x] = 1;
		if (solve()) {
			System.out.println(level);
		} else
			System.out.println(-1);

	}

	public static boolean solve() { // x -> y
		for (int i = 0; i < arr.size(); i++) {
			if (arr.get(i).x == x) {
				q.add(arr.get(i).y);
				visit[arr.get(i).y] = 1;
			}
		}

		level = 1;

		while (!q.isEmpty()) {

			int size = q.size();
			for (int i = 0; i < size; i++) {
				int dest = q.peek();

				q.poll();

				if (dest == y) {
					return true;
				}
				for (int j = 0; j < arr.size(); j++) {
					if (arr.get(j).x == dest) {

						if (visit[arr.get(j).y] == 1)
							continue;
						q.add(arr.get(j).y);
						visit[arr.get(j).y] = 1;
					}
				}

			}
			level++;
		}

		return false;
	}

	public static class Point {
		int y, x;

		Point(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}
}
