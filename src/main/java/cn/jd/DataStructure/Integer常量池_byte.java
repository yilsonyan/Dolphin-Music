package cn.jd.DataStructure;

import org.junit.Test;

import java.util.Objects;

public class Integer常量池_byte {


    @Test
    public void Interger() {
        Person p1 = new Person();
        p1.setName("段智兴");
        p1.setAge(40);

        Person p2 = new Person();
        p2.setName("慕容复");
        p2.setAge(30);

        Person p3 = new Person();
        p3.setName("段智兴");
        p3.setAge(40);

        boolean deepEquals = Objects.deepEquals(p1, p3);
        System.out.println(deepEquals);

        //cn.jd.DataStructure.Integer常量池
        Integer a = 1;
        Integer b = 1;
        System.out.println(a.equals(b));
        System.out.println(a == b);

        //不在Integer常量池
        Integer c = 500;
        Integer d = 500;
        System.out.println(c.equals(d));
        System.out.println(c == d);
    }



    @Test
    public void byte130() {
        byte i = (byte) 130;
        System.out.println(i);
    }


}
