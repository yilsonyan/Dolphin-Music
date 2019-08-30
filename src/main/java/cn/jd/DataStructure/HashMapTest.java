package cn.jd.DataStructure;

import org.junit.Test;

import java.util.HashMap;
import java.util.Objects;

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
public class HashMapTest {

    /**
     * HashMap测试
     */
    @Test
    public void testHashMap(){
        HashMap<String, String> map = new HashMap<>();

        for (int i = 1; i <= 12; i++) {
            map.put(i+"",i+0+"");
        }


        String s = map.get("12");

        System.out.println(s);
    }



    String name;
    Integer age;

    /**
     * 用于比较key是否相同
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HashMapTest that = (HashMapTest) o;
        return Objects.equals(name, that.name) &&
                Objects.equals(age, that.age);
    }

    /**
     * 用于计算索引
     */
    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }



}
