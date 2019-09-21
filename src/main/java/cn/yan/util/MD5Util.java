package cn.yan.util;

import java.security.MessageDigest;

/**
 * 
 * 
 * MD5加密工具类
 *
 * @author:  yumaochun
 * @date:    2019年2月13日 上午10:18:53
 * @version: jdk1.8
 *
 */
public class MD5Util {
	
	private static final String hexDigits[] = { "0", "1", "2", "3", "4", "5",
        "6", "7", "8", "9", "a", "b", "c", "d", "e", "f" };

	private static String byteArrayToHexString(byte b[]) {
        StringBuffer resultSb = new StringBuffer();
        for (int i = 0; i < b.length; i++)
            resultSb.append(byteToHexString(b[i]));
 
        return resultSb.toString();
    }
 
    private static String byteToHexString(byte b) {
        int n = b;
        if (n < 0)
            n += 256;
        int d1 = n / 16;
        int d2 = n % 16;
        return hexDigits[d1] + hexDigits[d2];
    }
 
    /**
     * 
     * 根据编码进行加密
     *
     * @author:   yumaochun
     * @date:     2019年2月13日 上午10:19:17
     *
     * @param origin        加密的源数据
     * @param charsetname   编码
     * @return  返回：加密后的数据
     */ 
    public static String MD5Encode(String origin, String charsetname) {
        String resultString = null;
        try {
            resultString = new String(origin);
            MessageDigest md = MessageDigest.getInstance("MD5");
            if (charsetname == null || "".equals(charsetname))
                resultString = byteArrayToHexString(md.digest(resultString
                        .getBytes()));
            else
                resultString = byteArrayToHexString(md.digest(resultString
                        .getBytes(charsetname)));
        } catch (Exception exception) {
        }
        return resultString;
    }
 
    
}
