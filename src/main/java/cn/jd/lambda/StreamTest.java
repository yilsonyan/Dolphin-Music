package cn.jd.lambda;

import cn.jd.in_output_stream.Person;
import org.apache.tomcat.jni.User;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

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
    public void whenEmptyStream_thenReturnDefaultOptional() {
        List<User> users = new ArrayList<>();
        User user = users.stream().findFirst().orElse(new User());
        System.out.println(user);
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
