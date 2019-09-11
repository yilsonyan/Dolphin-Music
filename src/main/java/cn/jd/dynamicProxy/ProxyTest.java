package cn.jd.dynamicProxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyTest {

    /**
     * JDK的Proxy类方式动态代理
     */
    @Test
    public void testProxyByJDK() {

        Student student = new Student();

        //第一个参数：目标类加载器
        ClassLoader classLoader = student.getClass().getClassLoader();

        //第二个参数：目标类实现的接口（接口可以多实现）
        Class<?>[] interfaces = student.getClass().getInterfaces();

        //第三个参数：InvocationHandler
        InvocationHandler invocationHandler = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Goods invoke = null;
                String methodName = method.getName();
                if ("buy".equals(methodName)) {
                    int price = (int) args[0];
                    price = price - 4000;
                    invoke = (Goods) method.invoke(student, price);
                }
                return invoke;
            }
        };

        //代理对象执行方法
        Person proxyInstance = (Person) Proxy.newProxyInstance(classLoader, interfaces, invocationHandler);
        Goods buy = proxyInstance.buy(8000);
        System.out.println(buy);
    }


    /**
     * CGlib方式动态代理
     */
    @Test
    public void testProxyByCGlib() {
        Student student = new Student();

        //第一个参数：目标类加载器
        Class clazz = student.getClass();

        //第二个参数：方法拦截器
        MethodInterceptor methodInterceptor = new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                Goods invoke = null;
                String methodName = method.getName();
                if ("buy".equals(methodName)) {
                    int price = (int) objects[0];
                    price = price - 4000;
                    invoke = (Goods) method.invoke(student, price);
                }
                return invoke;
            }
        };

        Student proxyInstance = (Student) Enhancer.create(clazz, methodInterceptor);
        //代理对象执行方法
        Goods buy = proxyInstance.buy(8000);
        System.out.println(buy);
    }


}
