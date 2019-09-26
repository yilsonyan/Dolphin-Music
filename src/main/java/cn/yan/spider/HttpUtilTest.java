package cn.yan.spider;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.Random;

public class HttpUtilTest {

    public static int index = 0;

    public String sendPost(String url, String param) {
        PrintWriter out = null;
        BufferedReader in = null;
        String result = "";
        try {
            URL realUrl = new URL(url);
            URLConnection conn = realUrl.openConnection();

            // 随机生成ip
            String ip = randIP();
            conn.setRequestProperty("X-Forwarded-For", ip);
            conn.setRequestProperty("HTTP_X_FORWARDED_FOR", ip);
            conn.setRequestProperty("HTTP_CLIENT_IP", ip);
            conn.setRequestProperty("REMOTE_ADDR", ip);
            conn.setRequestProperty("remote_addr", ip);
            conn.setRequestProperty("Host", "");
            conn.setRequestProperty("Connection", "keep-alive");
            conn.setRequestProperty("Content-Length", "17");
            conn.setRequestProperty("Accept", "application/json");
            conn.setRequestProperty("Origin", "ORIGIN");
            conn.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/45.0.2454.101 Safari/537.36");
            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            conn.setRequestProperty("Referer", "REFERER");
            conn.setRequestProperty("Accept-Encoding", "gzip, deflate");
            conn.setRequestProperty("Accept-Language", "zh-CN,zh;q=0.8,en;q=0.6,ja;q=0.4,pt;q=0.2");

            conn.setDoOutput(true);
            conn.setDoInput(true);
            out = new PrintWriter(conn.getOutputStream());
            out.print(param);
            out.flush();
            in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
            synchronized (this) {
                index ++;
            }
            System.out.println("第" + index + "次访问； -->  "
                    + "|| 当前线程：" + param + "  "
                    + "|| 请求成功！ || 模拟ip: " + ip
                    + " || 返回结果： " + result.hashCode());
        } catch (Exception e) {
            // System.out.println("发送 POST 请求出现异常！" + e);
            // e.printStackTrace();
        } finally {
            try {
                if (out != null) {
                    out.close();
                }
                if (in != null) {
                    in.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return result;
    }

    //生成随机 ip 地址
    public static String randIP() {
        Random random = new Random(System.currentTimeMillis());
        return (random.nextInt(255) + 1) + "."
                + (random.nextInt(255) + 1) + "."
                + (random.nextInt(255) + 1) + "."
                + (random.nextInt(255) + 1);
    }


    /**
     * 频繁请求
     * @param args
     */
    public static void main(String[] args) {
        try {
            for (int i = 0; i < 100000; i++) {
                Thread.sleep((new Random()).nextInt(200) + 100);
                new Thread(new Runnable() {
                    @Override
                    public void run() {

                        for (int j = 0; j < 100000; j++) {
                            try {
                                Thread.sleep((new Random()).nextInt(3200) + 1500);
                                HttpUtilTest tt = new HttpUtilTest();
                                tt.sendPost(
                                        "https://www.baidu.com",
                                        Thread.currentThread().getName());
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }).start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }




}