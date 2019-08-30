package cn.jd;


class Parent {
	protected static int count = 0;
	public Parent() { count++; }
	static int getCount() { return count; }
}

public class Child extends Parent {

	public Child() { count++; }


	/**
	 * The file will compile and run and the output will be:
	 * Count = 0
	 * Count = 2
	 */
	public static void main(String [] args) {
		System.out.println("Count = " + getCount());
		Child obj = new Child();
		System.out.println("Count = " + getCount());
	}



}