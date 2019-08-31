package cn.jd.extends_interface;


class Parent {
	protected static int count = 0;
	public Parent() { count++; }
	static int getCount() { return count; }
}
class Child extends Parent {
	public Child() {
		count++;
	}
	/**
	 * The file will compile and run and the output will be:
	 * Count = 0
	 * Count = 2
	 */
	public static void main(String [] args) {
		System.out.println("Count = " + getCount());
		//开始创建对象
		new Child();
		System.out.println("Count = " + getCount());
	}
}