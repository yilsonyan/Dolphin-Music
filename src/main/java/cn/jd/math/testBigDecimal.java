package cn.jd.math;

import org.junit.Test;

import java.math.BigDecimal;

public class testBigDecimal {


    /**
     * 对一个BigDecimal设置它的scale，如果精度比原始值低，那么按照指定的方法进行四舍五入（ROUND_HALF_UP）或者直接截断（DOWN）：
     */
    @Test
    public void testFail() {
        BigDecimal one = new BigDecimal(1.997);
        BigDecimal bigDecimal = one.setScale(2, BigDecimal.ROUND_HALF_UP);
        //或者下面这个，等效
        //math bigDecimal = one.setScale(2, RoundingMode.HALF_UP);
        System.out.println(bigDecimal);
    }


    /**
     * 通过BigDecimal的stripTrailingZeros()方法，可以将一个BigDecimal格式化为一个相等的，但去掉了末尾0的BigDecimal：
     */
    @Test
    public void stripTrailingZeros() {
        BigDecimal d1 = new BigDecimal("123.4500");
        BigDecimal d2 = d1.stripTrailingZeros();
        //scale()表示小数位数
        System.out.println(d1.scale()); // 4
        System.out.println(d2.scale()); // 2,因为去掉了00

        BigDecimal d3 = new BigDecimal("1234500");
        BigDecimal d4 = d1.stripTrailingZeros();
        System.out.println(d3.scale()); // 0
        System.out.println(d4.scale()); // -2 //如果一个BigDecimal的scale()返回负数，例如，-2，表示这个数是个整数，并且末尾有2个0。
    }


    /**
     * 在比较两个BigDecimal的值是否相等时，要特别注意，使用equals()方法不但要求两个BigDecimal的值相等，还要求它们的scale()相等：
     * TODO BigDecimal必须使用compareTo()方法来比较，它根据两个值的大小分别返回负数、正数和0，分别表示小于、大于和等于。
     */
    @Test
    public void compare() {
        BigDecimal d1 = new BigDecimal("123.456");
        BigDecimal d2 = new BigDecimal("123.45600");
        System.out.println(d1.equals(d2)); // false,因为scale不同
        System.out.println(d1.equals(d2.stripTrailingZeros())); // true,因为d2去除尾部0后scale变为2
        System.out.println(d1.compareTo(d2)); // 0
    }



}
