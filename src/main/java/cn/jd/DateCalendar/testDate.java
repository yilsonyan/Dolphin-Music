package cn.jd.DateCalendar;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * // 　　　 ┏━┓     ┏━┓
 * //      ┏┛ ┻━━━━━┛ ┻┓
 * //      ┃　　　　　　 ┃
 * //      ┃　　　━　　　┃
 * //      ┃　┳┛　  ┗┳　┃               高山仰止，景行行止，虽不能至，心向往之。
 * //      ┃　　　　　　 ┃               Codes are far away from bugs with the animal protecting.
 * //      ┃　　　┻　　　┃
 * //      ┃　　　　　　 ┃               * @Author：yilson
 * //      ┗━┓　　　┏━━━┛               * @Date:：2019-06-22 18:00
 * //        ┃　　　┃                   * @Description：
 * //        ┃　　　┃
 * //        ┃　　　┗━━━━━━━━━┓
 * //        ┃　　　　　　　    ┣┓
 * //        ┃　　　　         ┏┛
 * //        ┗━┓ ┓ ┏━━━┳ ┓ ┏━┛
 * //          ┃ ┫ ┫   ┃ ┫ ┫
 * //          ┗━┻━┛   ┗━┻━┛
 */
public class testDate {


    public static void main(String[] args) throws ParseException {
        String str = "1994-10-30 13:37:00";

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
        String format = sdf.format(str);
        System.out.println(format);

        Date date = new Date();
        System.out.println(date);
    }


    /**
     * Calendar
     */
    @Test
    public void Calendar1() {
        Calendar calendar = Calendar.getInstance();
        System.out.println(calendar);

        Date time = calendar.getTime();

        System.out.println(time);
        System.out.println(calendar.get(Calendar.DAY_OF_WEEK));
        System.out.println(calendar.get(Calendar.HOUR));
        System.out.println(calendar.get(Calendar.MONTH));
        System.out.println(calendar.get(Calendar.MINUTE));

        calendar.set(Calendar.YEAR,9102);
        System.out.println(calendar.get(Calendar.YEAR));


        calendar.add(Calendar.YEAR,1);
        System.out.println(calendar.get(Calendar.YEAR));

    }




}
