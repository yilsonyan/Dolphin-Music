package iterator;

import org.junit.Test;
import reflect.Person;

import java.util.*;
import java.util.function.Consumer;

/**
 * // 　　　 ┏━┓     ┏━┓
 * //      ┏┛ ┻━━━━━┛ ┻┓
 * //      ┃　　　　　　 ┃
 * //      ┃　　　━　　　┃
 * //      ┃　┳┛　  ┗┳　┃               高山仰止，景行行止，虽不能至，心向往之。
 * //      ┃　　　　　　 ┃               Codes are far away from bugs with the animal protecting.
 * //      ┃　　　┻　　　┃
 * //      ┃　　　　　　 ┃               * @Author：yilson
 * //      ┗━┓　　　┏━━━┛               * @Date:：2019-06-13 22:29
 * //        ┃　　　┃                   * @Description：
 * //        ┃　　　┃
 * //        ┃　　　┗━━━━━━━━━┓
 * //        ┃　　　　　　　    ┣┓
 * //        ┃　　　　         ┏┛
 * //        ┗━┓ ┓ ┏━━━┳ ┓ ┏━┛
 * //          ┃ ┫ ┫   ┃ ┫ ┫
 * //          ┗━┻━┛   ┗━┻━┛
 */
public class TestIterator {
    public static void main(String[] args) {


        Person person1 = new Person();
        person1.setName("tangli");
        person1.setAge(24);

        Person person2 = new Person();
        person2.setName("tangxiaoli");
        person2.setAge(18);

        Set<Person> set1 = new HashSet<>();
        set1.add(person1);
        set1.add(person2);



        set1.spliterator().forEachRemaining(new Consumer<Person>() {
            @Override
            public void accept(Person person) {
                System.out.println(person);
            }
        });



    }



    //测试List迭代器
    @Test
    public void testList() throws Exception {
        Person person1 = new Person();
        person1.setName("tangli");
        person1.setAge(24);

        Person person2 = new Person();
        person2.setName("tangxiaoli");
        person2.setAge(18);

        List list = new ArrayList();
        list.add(person1);
        list.add(person2);


        //ListIterator<Person> iterator = list.listIterator();
        Iterator<Person> iterator = list.iterator();

        while (iterator.hasNext()) {
            Person p = iterator.next();
            if ("tangxiaoli".equals(p.getName())){
                iterator.remove();
            }

        }

        System.out.println(list);
    }




    //测试List迭代器，使用for避免并发修改异常
    @Test
    public void testList2() throws Exception {
        Person person1 = new Person();
        person1.setName("tangli");
        person1.setAge(24);

        Person person2 = new Person();
        person2.setName("tangxiaoli");
        person2.setAge(18);

        List list = new ArrayList();
        list.add(person1);
        list.add(person2);



        for (Iterator<Person> iter = list.iterator(); iter.hasNext(); ) {

            Person p = iter.next();
            if ("tangxiaoli".equals(p.getName())){
                iter.remove();
            }
        }

        System.out.println(list);


    }

}
