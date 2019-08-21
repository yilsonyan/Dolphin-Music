package cn.jd.BigDecimal;

import org.junit.Test;

import java.math.BigDecimal;

public class testBigDecimal {


    public static void main(String[] args) {
        BigDecimal payAmount = new BigDecimal(0.01);
        BigDecimal rate = new BigDecimal(0.0001);

        BigDecimal rateMoney = payAmount.multiply(rate);
        BigDecimal bigDecimal = rateMoney.setScale(2, BigDecimal.ROUND_HALF_UP);
        System.out.println(bigDecimal);
    }



    @Test
    public void testFail() {
        BigDecimal one = new BigDecimal(1.997);
        BigDecimal bigDecimal = one.setScale(2, BigDecimal.ROUND_HALF_UP);
        System.out.println(bigDecimal);
    }



}
