package cn.jd.lambda;

import cn.jd.in_output_stream.Person;
import org.apache.tomcat.jni.User;
import org.junit.Test;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * // 　　　 ┏━┓     ┏━┓
 * //      ┏┛ ┻━━━━━┛ ┻┓
 * //      ┃　　　　　　 ┃
 * //      ┃　　　━　　　┃
 * //      ┃　┳┛　  ┗┳　┃               高山仰止，景行行止，虽不能至，心向往之。
 * //      ┃　　　　　　 ┃               Codes are far away from bugs with the animal protecting.
 * //      ┃　　　┻　　　┃
 * //      ┃　　　　　　 ┃               * @author：yilson
 * //      ┗━┓　　　┏━━━┛               * @date:：2019-06-09 14:53
 * //        ┃　　　┃                   * @description：
 * //        ┃　　　┃
 * //        ┃　　　┗━━━━━━━━━┓
 * //        ┃　　　　　　　    ┣┓
 * //        ┃　　　　         ┏┛
 * //        ┗━┓ ┓ ┏━━━┳ ┓ ┏━┛
 * //          ┃ ┫ ┫   ┃ ┫ ┫
 * //          ┗━┻━┛   ┗━┻━┛
 */
public class StreamTest {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("张无忌");
        list.add("周芷若");
        list.add("赵敏");
        list.add("张强");
        list.add("张三丰");

        //list.lambda().filter(s ->  s.startsWith("张")).filter(s -> s.length() == 3).forEach(System.out::println);
        //list.lambda().sorted().forEach(s-> System.out.println(s));
        list.stream().sorted().forEach(System.out::println);
    }



    @Test
    public void max() {
        Stream<Integer> s = Stream.of(1, 2, 3, 4, 5, 6);
        Optional<Integer> optional = s.max((a, b) -> a - b);
        Integer max = optional.get();
        System.out.println(max);
    }



    @Test
    public void whenEmptyStream_thenReturnDefaultOptional() {
        List<User> users = new ArrayList<>();
        User user = users.stream().findFirst().orElse(new User());
        System.out.println(user);
    }





    //一个参数的Reduce，a[0]与a[1]进行二合运算，结果与a[2]做二合运算，一直到最后与a[n-1]做二合运算。
    @Test
    public void reduce1() {
        Stream<Integer> s = Stream.of(1, 2, 3, 4, 5, 6);
        /**
         * 求和，也可以写成Lambda语法：
         * Integer sum = s.reduce((a, b) -> a + b).get();
         */
        Integer sum = s.reduce(new BinaryOperator<Integer>() {
            @Override
            public Integer apply(Integer integer, Integer integer2) {
                return integer + integer2;
            }
        }).get();

        /**
         * 求最大值，也可以写成Lambda语法：
         * Integer max = s.reduce((a, b) -> a >= b ? a : b).get();
         */
        Integer max = s.reduce(new BinaryOperator<Integer>() {
            @Override
            public Integer apply(Integer integer, Integer integer2) {
                return integer >= integer2 ? integer : integer2;
            }
        }).get();
    }




    //两个参数的Reduce，与一个参数的Reduce方法的不同：它多了一个初始化的值。
    //因此计算的顺序是identity与a[0]进行二合运算，结果与a[1]再进行二合运算，最终与a[n-1]进行二合运算。
    //适用于所有元素处理后在最前面添加[value]后返回
    @Test
    public void reduce2() {
        Stream<String> s = Stream.of("1", "2", "3", "4", "5", "6");
        /**
         * 以下结果将会是：[value]123456
         * 也可以使用Lambda语法：
         * System.out.println(s.reduce("[value]", (s1, s2) -> s1.concat(s2)));
         */
        System.out.println(s.reduce("[value]", new BinaryOperator<String>() {
            @Override
            public String apply(String s, String s2) {
                return s.concat(s2);
            }
        }));
    }










    @Test
    public void testChangeValue() {
        List<Person> list2 = new ArrayList<>();
        Person p1 = new Person("p1", 1);
        Person p2 = new Person("p2", 2);
        Person p3 = new Person("p3", 3);
        list2.add(p1);
        list2.add(p2);
        list2.add(p3);

        list2.stream().forEach(p -> p.setAge(p.getAge() + 1));
        System.out.println(list2);
    }



    @Test
    public void testCollect() {
        List<String> list = new ArrayList();
        list.add("1");
        list.add("2");
        list.add("3");

        String str = list.stream()
                .filter(Objects::nonNull)
                .collect(Collectors.joining(", "));
        System.out.println(str);

        Set set = list.stream()
                .filter(Objects::nonNull)
                .collect(Collectors.toSet());
        System.out.println(set);

    }


}
