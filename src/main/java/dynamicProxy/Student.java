package dynamicProxy;

public class Student implements Person {

    @Override
    public Goods buy(int money) {
        Goods iPhoneX = new Goods("iPhoneX", money);
        return iPhoneX;
    }



}
