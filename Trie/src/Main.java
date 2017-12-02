import java.util.ArrayList;

public class Main {
	public static void main(String args[]) {
		ArrayList<String> list = new ArrayList<>();
		
		list.add("apple");
		list.add("aid");
		list.add("appaa");
		list.add("bc");
		
		Trie trie = new Trie(list);
		
		System.out.println(trie.contains("apple"));
	}
}
