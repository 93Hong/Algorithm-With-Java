
public class Main {
	public static void main(String args[]) {

		Integer i1 = 1;
		Integer i2 = 1;
		// autoboxing�� ����Ǿ� int�� �񱳷� true ���.
		System.out.println(i1 == i2);

		Integer i3 = 128;
		Integer i4 = 128;
		// autoboxing�� ������� �ʰ� reference �񱳸� �ϱ⶧���� false ���.
		System.out.println(i3 == i4);

	}
}
