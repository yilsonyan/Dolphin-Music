package cn.jd.object;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.Test;

import java.io.*;
import java.util.Arrays;

/**
 * Object相关方法
 */
public class Clone implements Cloneable,Serializable {

    /**
     * 观察两次输出，由于Score内部直接引用了外部传入的int[]数组，
     * 这会造成外部代码对int[]数组的修改，影响到Score类的字段。
     */
    @Test
    public void testClone() {
        class Score {
            private int[] scores;

            public Score(int[] scores) {
                //this.scores = scores;//这会造成外部代码对int[]数组的修改，影响到Score类的字段。
                this.scores = scores.clone();//TODO 修复Score的构造方法，使得外部代码对数组的修改不影响Score实例的int[]字段。
            }

            public void printScores() {
                System.out.println(Arrays.toString(scores));
            }
        }

        int[] scores = new int[]{88, 77, 51, 66};
        Score s = new Score(scores);
        s.printScores();
        scores[2] = 99;
        s.printScores();
    }


    /**
     * 浅克隆
     * Object类中的 clone()方法被protected修饰符修饰。
     * 第一、这也意味着如果要应用 clone()方 法，必须继承Object类，在 Java中所有的类是缺省继承 Object类的，也就不用关心这点了。
     * 第二、重载 clone()方法。还有一点要考虑的是为了让其它类能调用 clone()方法，重载要把 clone()方法的设置为 public。
     * 第三、Object.clone()方法返回一个Object对象。我们必须进行强制类型转换才能得到我们需要的类型。
     * 第四、实现 Cloneable 接口。
     */
    @Test
    public void testCloneShadow() throws CloneNotSupportedException {
        @Data
        @AllArgsConstructor
        class Person implements Cloneable {
            private String name;
            private int age;

            @Override
            public Person clone() throws CloneNotSupportedException {
                return (Person) super.clone();
            }
        }


        Person p = new Person("zhang", 23);
        Person p1 = null;
        p1 = p.clone();


        System.out.println(p == p1); //地址值不同，但引用类型的属性的地址相同
        String result = p.getName() == p1.getName() ? "clone是浅拷贝的" : "clone是深拷贝的";
        System.out.println(result);
    }


    /**
     * 深克隆
     * 第一种方式：改造复写的clone方法，让引用类型是新的对象
     */
    @Test
    public void testCloneDeep1() throws CloneNotSupportedException {
        @Data
        @AllArgsConstructor
        class Person implements Cloneable {
            private String name;
            private int age;

            @Override
            public Person clone() throws CloneNotSupportedException {
                Person person = (Person) super.clone();
                person.setName(new String(name));// TODO 引用类型是新的对象(或者使用引用类型的如Dog的clone方法)
                person.setAge(age);
                return person;
            }
        }


        Person p = new Person("zhang", 23);
        Person p1 = null;
        p1 = p.clone();

        //改变对象的属性，并没有影响到后续对象
        p.setName("san");

        System.out.println(p == p1); //地址值不同
        String result = p.getName() == p1.getName() ? "clone是浅拷贝的" : "clone是深拷贝的";
        System.out.println(result);
        System.out.println("--------------------："+p);
        System.out.println("--------------------："+p1);
    }


    /**
     * 深克隆
     * 第二种方式：实现Serializable串行化来深层复制
     */
    @Test
    public void testCloneDeep2() throws CloneNotSupportedException, IOException, ClassNotFoundException {
        @Data
        @AllArgsConstructor
        class Person implements Serializable {
            private String name;
            private int age;
        }

        //new一个没有复写clone方法的实体
        Person personOrin = new Person("zhang", 23);

        //将对象写到流中
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
        objectOutputStream.writeObject(personOrin);
        //从流中读出来
        ByteArrayInputStream bi = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
        ObjectInputStream oi = new ObjectInputStream(bi);
        Person personRead =(Person) oi.readObject();

        //改变原始对象，并没有影响到读出来的对象的属性
        personOrin.setName("san");

        System.out.println(personOrin == personRead); //地址值不同
        String result = personOrin.getName() == personRead.getName() ? "clone是浅拷贝的" : "clone是深拷贝的";
        System.out.println(result);
        System.out.println("--------------------："+personOrin);
        System.out.println("--------------------："+personRead);
    }
}
