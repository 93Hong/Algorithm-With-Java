import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int N;
	static int map[][];
	static int ans[][];
	static Queue<Integer> q;

	public static void main(String args[]) throws IOException {
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		q = new LinkedList<>();
		ans = new int[N][N];

		for (int i = 0; i < N; i++) {
			String input[] = br.readLine().split(" ");
			for (int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(input[j]);
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 1)
					solve(i, j, i);
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(ans[i][j] + " ");
			}
			System.out.println();
		}

	}

	public static void solve(int y, int x, int yy) {
		if (ans[yy][x] == 1)
			return;

		ans[yy][x] = 1;
		for (int i = 0; i < N; i++) {
			if (map[x][i] == 1) {
				solve(x, i, yy);
			}
		}

	}
}
