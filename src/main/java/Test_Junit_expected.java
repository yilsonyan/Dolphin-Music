import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.fail;

//注意：这是java中的静态引入

public class Test_Junit_expected {


    /**
     * 如果测试该方法时产生一个ArithmeticException的异常，则表示测试通过
     * 你可以改成int i = 1 / 1;运行时则会测试不通过-因为与你的期望的不符
     */
    @Test(expected = ArithmeticException.class)
    public void testDivisionWithException() {
        int i = 1 / 0;
    }


    /**
     * 运行时抛出一个IndexOutOfBoundsException异常才会测试通过
     */
    @Test(expected = IndexOutOfBoundsException.class)
    public void testEmptyList() {
        new ArrayList<>().get(0);
    }



    @Test
    public void testFail() {
        try {
            int i = 1 / 0;

            fail();//断言上面一句会失败
        } catch (ArithmeticException e) {
            assertThat(e.getMessage(), is("/ by zero"));
        }
    }



    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void testRule() {

        thrown.expect(ArithmeticException.class);
        thrown.expectMessage(containsString("/ by zero"));

        int i = 1 / 0;

    }


}
