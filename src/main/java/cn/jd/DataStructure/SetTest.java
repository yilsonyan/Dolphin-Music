package cn.jd.DataStructure;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * // 　　　 ┏━┓     ┏━┓
 * //      ┏┛ ┻━━━━━┛ ┻┓
 * //      ┃　　　　　　 ┃
 * //      ┃　　　━　　　┃
 * //      ┃　┳┛　  ┗┳　┃               高山仰止，景行行止，虽不能至，心向往之。
 * //      ┃　　　　　　 ┃               Codes are far away from bugs with the animal protecting.
 * //      ┃　　　┻　　　┃
 * //      ┃　　　　　　 ┃               * @Author：yilson
 * //      ┗━┓　　　┏━━━┛               * @Date:：2019-06-11 19:58
 * //        ┃　　　┃                   * @Description：
 * //        ┃　　　┃
 * //        ┃　　　┗━━━━━━━━━┓
 * //        ┃　　　　　　　    ┣┓
 * //        ┃　　　　         ┏┛
 * //        ┗━┓ ┓ ┏━━━┳ ┓ ┏━┛
 * //          ┃ ┫ ┫   ┃ ┫ ┫
 * //          ┗━┻━┛   ┗━┻━┛
 */
public class SetTest {

    /**
     * 测试简单交集
     * java中交集使用 A.retainAll(B) ,交集的结果在集合A中。
     */
    @Test
    public void testSet(){
        Set<String> set1 = new HashSet<>();
        Set<String> set2 = new HashSet<>();

        set1.add("a");
        set1.add("b");
        set1.add("c");

        set2.add("c");
        set2.add("d");
        set2.add("e");

        //交集
        set1.retainAll(set2);
        System.out.println("交集是 " + set1);  //交集是 [c]
    }



    /**
    * 并集测试
    * 并集使用addAll，A.addAll(B) 因为set本身就去重，所有直接全部添加到一个集合中取并集。
    */
    @Test
    public void testUnionSet() {
      Set<String> set1 = new HashSet<>();
      Set<String> set2 = new HashSet<>();

      set1.add("a");
      set1.add("b");
      set1.add("c");

      set2.add("b");
      set2.add("c");
      set2.add("d");

      set1.addAll(set2);
      System.out.println("并集是" + set1); //并集是[a, b, c, d]
    }


    /**
    * 差集测试
    * 差集使用removeAll方法，去掉一集合中包含的另一个集合的值。A.removeAll(B)。
    */
    @Test
    public void testDifferenceSet() {
        Set<String> set1 = new HashSet<>();
        Set<String> set2 = new HashSet<>();

        set1.add("a");
        set1.add("b");
        set1.add("c");
        set1.add("d");

        set2.add("c");
        set2.add("d");
        set2.add("e");
        set2.add("f");

        set1.removeAll(set2);
        System.out.println("差集是 " + set1); //差集是 [a, b]
    }








}
