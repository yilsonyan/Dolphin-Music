package cn.jd.extends_interface;

public interface MyInterface {
	default void read(){
	}
}
class MyClass implements MyInterface {
	@Override
	//default void read(){ //只有接口有默认方法
	public void read(){
	}
}
