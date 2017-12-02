
public class Main {
	public static void main(String args[]) {
		TreeNode root = new TreeNode(3);
		root.insertInOrder(2);
		root.insertInOrder(5);
		root.insertInOrder(6);
		root.insertInOrder(4);
		
		System.out.println(root.size());
		System.out.println(root.find(5).size());
	}
}
