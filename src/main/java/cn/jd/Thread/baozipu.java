package cn.jd.Thread;

/*
# 　　　 ┏┓　      ┏┓
# 　　┏┛┻━━━┛┻┓
# 　　┃　　　━　　   ┃
# 　   ┃　┳┛　┗┳　┃
# 　　┃　　　　　　   ┃
# 　　┃　　　┻　　   ┃
# 　　┗━┓　　　┏━┛          Codes are far away from bugs with the animal protecting.
# 　　　　┃　　　┃                          高山仰止，景行行止，虽不能至，心向往之。
# 　　　　┃　　　┗━━━━┓           
# 　　　　┃　　　　　        ┣┓         * @Author：vincent
# 　　　　┃　　　　          ┏┛          * @Date:：2019-03-15 15:35
# 　　　　┗┓┓┏━┳┓┏┛              * @Description：
# 　　　　  ┃┫┫　┃┫┫
# 　　　　 ┗┻┛   ┗┻┛
*/
public class baozipu extends Thread{
    private baozi bz;

    public baozipu(String name,baozi bz) {
        super(name);
        this.bz = bz;
    }

    @Override
    public void run() {
        int count = 0;
        while(true){
            synchronized (bz){  //   bz作为锁对象，两个线程用的同一bz
                if(bz.flag == true){
                    try {
                        bz.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("包子铺开始做包子");
                if(count%2 == 0){
                    bz.pi = "厚皮";
                    bz.xian = "肉馅";
                }
                else {
                    bz.pi = "薄皮";
                    bz.xian = "素馅";
                }
                count++;
                bz.flag = true;
                System.out.println("包子做好了，吃货快来吃吧");
                System.out.println("是"+bz.pi+bz.xian+"包子");
                bz.notify();
            }
        }
    }
}
