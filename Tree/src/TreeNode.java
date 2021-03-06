import java.util.LinkedList;
import java.util.List;

public class TreeNode<T> {
	private T data;
	private TreeNode<T> parent;
	private List<TreeNode<T>> children;

	public TreeNode(T data) {
		this.data = data;
		this.children = new LinkedList<TreeNode<T>>(null);
	}

	public TreeNode<T> addChild(T child) {
		TreeNode<T> childNode = new TreeNode<T>(child);
		childNode.parent = this;
		this.children.add(childNode);
		return childNode;
	}

	public List<TreeNode<T>> getChildren() {
		return children;
	}

	public TreeNode<T> getLeft() {
		return parent.getChildren().get(0);
	}
	
	public TreeNode<T> getRight() {
		return parent.getChildren().get(1);
	}
}
