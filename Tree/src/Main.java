import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String args[]) throws NumberFormatException, IOException {
		int N = Integer.parseInt(br.readLine());
		
		TreeNode<Character> root = null;
		
		while(N-- > 0) {
			char t, cl, cr;
			String sub[] = br.readLine().split(" ");
			t = sub[0].charAt(0);
			cl = sub[1].charAt(0);
			cr = sub[2].charAt(0);
			
			if (root == null) {
				root = new TreeNode<Character>(t);
			}
		}
	}
}
