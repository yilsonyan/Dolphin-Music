package DataStructure;

import org.junit.Test;
import reflect.Person;

import java.util.*;

/**
 * // 　　　 ┏━┓     ┏━┓
 * //      ┏┛ ┻━━━━━┛ ┻┓
 * //      ┃　　　　　　 ┃
 * //      ┃　　　━　　　┃
 * //      ┃　┳┛　  ┗┳　┃               高山仰止，景行行止，虽不能至，心向往之。
 * //      ┃　　　　　　 ┃               Codes are far away from bugs with the animal protecting.
 * //      ┃　　　┻　　　┃
 * //      ┃　　　　　　 ┃               * @Author：yilson
 * //      ┗━┓　　　┏━━━┛               * @Date:：2019-06-13 22:58
 * //        ┃　　　┃                   * @Description：
 * //        ┃　　　┃
 * //        ┃　　　┗━━━━━━━━━┓
 * //        ┃　　　　　　　    ┣┓
 * //        ┃　　　　         ┏┛
 * //        ┗━┓ ┓ ┏━━━┳ ┓ ┏━┛
 * //          ┃ ┫ ┫   ┃ ┫ ┫
 * //          ┗━┻━┛   ┗━┻━┛
 */
public class 集合性能测试 {



    /**
     * 性能测试：ArrayList
     * 结果：
     *  添加：1557s
     *  遍历：87
     */
    @Test
    public void testArrayList() {
        Person person1 = new Person();
        person1.setName("tangli");
        person1.setAge(24);

        Person person2 = new Person();
        person2.setName("tangxiaoli");
        person2.setAge(18);

        List<Person> list = new ArrayList<Person>();
        list.add(person1);
        list.add(person2);


        long start = System.currentTimeMillis();
        for (int i = 100000000; i > 0; i--) {
            list.add(person1);
        }
        long end = System.currentTimeMillis();
        System.out.println("添加一亿条数据用时"+(end-start));


        start = System.currentTimeMillis();
        for (Person p : list) {

        }
        end = System.currentTimeMillis();
        System.out.println("循环一亿次用时"+(end-start));
    }


    /**
     * 性能测试：ArrayList使用迭代器循环
     * 结果：Iterator跟for循环差不多
     *  添加：1557s
     *  遍历：87
     */
    @Test
    public void testArrayListWithIter() {
        Person person1 = new Person();
        person1.setName("tangli");
        person1.setAge(24);

        Person person2 = new Person();
        person2.setName("tangxiaoli");
        person2.setAge(18);

        List<Person> list = new ArrayList<Person>();
        list.add(person1);
        list.add(person2);


        long start = System.currentTimeMillis();
        for (int i = 100000000; i > 0; i--) {
            list.add(person1);
        }
        long end = System.currentTimeMillis();
        System.out.println("添加一亿条数据用时"+(end-start));


        start = System.currentTimeMillis();
        for (Iterator<Person> iter = list.iterator(); iter.hasNext(); ) {
            Person p = iter.next();

        }
        end = System.currentTimeMillis();
        System.out.println("循环一亿次用时"+(end-start));
    }


    /**
     * 性能测试：LinkedList
     * 结果：
     *  添加：？？？？？
     *  遍历：？？？？？ 太久
     */
    @Test
    public void testLinkedList() {
        Person person1 = new Person();
        person1.setName("tangli");
        person1.setAge(24);

        Person person2 = new Person();
        person2.setName("tangxiaoli");
        person2.setAge(18);

        List<Person> list = new LinkedList<Person>();
        list.add(person1);
        list.add(person2);


        long start = System.currentTimeMillis();

        //太慢，改成了一千万
        for (int i = 100000000; i > 0; i--) {
            list.add(person1);
        }
        long end = System.currentTimeMillis();
        System.out.println("添加一亿条数据用时"+(end-start));


        /*start = System.currentTimeMillis();
        for (Person p : list) {

        }
        end = System.currentTimeMillis();
        System.out.println("循环一亿次用时"+(end-start));*/
    }



    /**
     * 性能测试：HashSet
     * 结果：
     *  添加：1277s
     *  遍历：0s
     */
    @Test
    public void testHashSet() {
        Person person1 = new Person();
        person1.setName("tangli");
        person1.setAge(24);

        Person person2 = new Person();
        person2.setName("tangxiaoli");
        person2.setAge(18);

        Set<Person> list = new HashSet<Person>();
        list.add(person1);
        list.add(person2);


        long start = System.currentTimeMillis();

        //一亿
        for (int i = 100000000; i > 0; i--) {
            list.add(person1);
        }
        long end = System.currentTimeMillis();
        System.out.println("添加一亿条数据用时"+(end-start));


        start = System.currentTimeMillis();
        for (Person p : list) {
            p.getName();
        }
        end = System.currentTimeMillis();
        System.out.println("循环一亿次用时"+(end-start));
    }



}
