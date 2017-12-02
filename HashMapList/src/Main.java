import java.util.ArrayList;

public class Main {
	public static void main(String args[]) {
		HashMapList ha = new HashMapList<>();
		
		ArrayList<String> items = new ArrayList<>();
		items.add("a");
		items.add("b");
		items.add("c");
		
		ha.put("1", items);
		
		System.out.println(ha.containsKey("1"));
		System.out.println(ha.containsKeyValue("1", "d"));
		
		ha.put("1", "d");
		
		System.out.println(ha.containsKey("1"));
		System.out.println(ha.containsKeyValue("1", "d"));
		System.out.println(ha.containsKeyValue("1", "a"));
		
		System.out.println(ha.toString());
	}
}
