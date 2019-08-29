package cn.jd.math;

import cn.jd.DataStructure.Person;
import org.junit.Test;

import java.math.BigInteger;
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

        //Integer常量池 [-128, 127]
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

    @Test
    public void Wrapper() {
        // boolean只有两个值true/false，其包装类型只需要引用Boolean提供的静态字段:
        Boolean t = Boolean.TRUE;
        Boolean f = Boolean.FALSE;

        // int可表示的最大/最小值:
        int max = Integer.MAX_VALUE; // 2147483647
        int min = Integer.MIN_VALUE; // -2147483648

        // long类型占用的bit和byte数量:
        int sizeOfLong = Long.SIZE; // 64 (bits)
        int bytesOfLong = Long.BYTES; // 8 (bytes)

        System.out.println("------------------------");
        long maxValue = Long.MAX_VALUE; //9223372036854775807   922万万亿
        long minValue = Long.MIN_VALUE; //-9223372036854775808
        System.out.println("------------------------");

        /**
         * 在Java中，由CPU原生提供的整型最大范围是64位long型整数。使用long型整数可以直接通过CPU指令进行计算，速度非常快。
         *
         * 如果我们使用的整数范围超过了long型怎么办？这个时候，就只能用软件来模拟一个大整数。
         * java.math.BigInteger就是用来表示任意大小的整数。BigInteger内部用一个int[]数组来模拟一个非常大的整数：
         */
        BigInteger bi = new BigInteger("1234567890");
        //返回一个BigInteger，其值是 (this^exponent)，该指数是一个整数，而不是一个BigInteger。
        System.out.println(bi.pow(5)); // 2867971860299718107233761438093672048294900000
    }



    @Test
    public void e1e() {
        //所有的整数和浮点数的包装类型都继承自Number，因此，可以非常方便地直接通过包装类型获取各种基本类型：

        // 向上转型为Number:
        Number num = new Integer(999);
        // 获取byte, int, long, float, double:
        byte b = num.byteValue();
        int n = num.intValue();
        long ln = num.longValue();
        float f = num.floatValue();
        double d = num.doubleValue();

        System.out.println("------------------------");
    }


    /**
     * 处理无符号整型
     * 在Java中，并没有无符号整型（Unsigned）的基本数据类型。
     * byte、short、int和long都是带符号整型，最高位是符号位。
     * 而C语言则提供了CPU支持的全部数据类型，包括无符号整型。无符号整型和有符号整型的转换在Java中就需要借助包装类型的静态方法完成。
     * <p>
     * 例如，byte是有符号整型，范围是-128~+127，但如果把byte看作无符号整型，它的范围就是0~255。
     * 我们把一个负的byte按无符号整型转换为int：
     */
    @Test
    public void noneSymbol() {
        byte x = -1;
        byte y = 127;
        System.out.println(Byte.toUnsignedInt(x)); // 255
        System.out.println(Byte.toUnsignedInt(y)); // 127
        System.out.println("------------------------");
    }


}
