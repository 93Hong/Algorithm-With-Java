
public class Main {
	public static void main(String args[]) {
		LinkedListNode head = new LinkedListNode(3);
		head.setNext(new LinkedListNode(4));
		head.next.setNext(new LinkedListNode(5));
		
		System.out.println(head.data);
		System.out.println(head.next.data);
		System.out.println(head.next.next.data);
		System.out.println(head.next.data);
		System.out.println(head.next.next.prev.data);
	}
}
