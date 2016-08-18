package test;

public class Test {

	// swap() doesn't swap i and j
	public static void swap(TestClass tc) {
		int temp = tc.getI();
		tc.setI(tc.getJ());
		tc.setJ(temp);
	}

	public static void main(String[] args) {
		TestClass tc = new TestClass();
		tc.setI(10);
		tc.setJ(20);

		swap(tc);
		System.out.println("i = " + tc.getI() + ", j = " + tc.getJ());
	}

}
