
public class Main {
	public static void main(String args[]) {

		Integer i1 = 1;
		Integer i2 = 1;
		// autoboxing이 적용되어 int값 비교로 true 출력.
		System.out.println(i1 == i2);

		Integer i3 = 128;
		Integer i4 = 128;
		// autoboxing이 적용되지 않고 reference 비교를 하기때문에 false 출력.
		System.out.println(i3 == i4);

	}
}
