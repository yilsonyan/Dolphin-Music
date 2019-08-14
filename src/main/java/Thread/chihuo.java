package Thread;

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
# 　　　　┃　　　　          ┏┛          * @Date:：2019-03-15 15:36
# 　　　　┗┓┓┏━┳┓┏┛              * @Description：
# 　　　　  ┃┫┫　┃┫┫
# 　　　　 ┗┻┛   ┗┻┛
*/
public class chihuo extends Thread {
    private baozi bz;
    public chihuo(String name,baozi bz){
        super(name);
        this.bz =bz;
    }

    @Override
    public void run() {
        while(true){
            synchronized (bz){  //   bz作为锁对象，两个线程用的同一bz。 //同一锁对象来控制wait、notify
                if(bz.flag == false){
                    try {
                        bz.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("吃货正在吃"+ bz.pi+bz.xian + "包子");
                bz.flag = false;
                System.out.println("吃货吃完了");
                bz.notify();    //同一锁对象来控制wait、notify

            }
        }

    }
}

