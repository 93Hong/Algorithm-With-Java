import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NthGameApplication {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int n, t, m, p;

	public static void main(String args[]) throws IOException {

		String sub[] = br.readLine().split(" ");

		n = Integer.parseInt(sub[0]);
		t = Integer.parseInt(sub[1]);
		m = Integer.parseInt(sub[2]);
		p = Integer.parseInt(sub[3]);

		StringBuffer ans = new StringBuffer();
		int x = 0;
		while (ans.length() < t * m) {

			int a = x;
			StringBuffer s = new StringBuffer();
			do {
				if (a % n > 9)
					s.append(Character.toString((char) ('A' + (a % n - 10))));
				else
					s.append(a % n);
				a /= n;
			} while (a > 0);

			ans.append(s.reverse());
			x++;
		}

		int index = p - 1;
		String ss = "";
		for (int i = 0; i < t; i++) {
			ss += ans.charAt(index);
			index += m;
		}

		System.out.println(ss);
	}
}
