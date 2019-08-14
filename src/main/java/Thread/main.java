package Thread;

/*
// 　　　 ┏━┓     ┏━┓
//      ┏┛ ┻━━━━━┛ ┻┓
//      ┃　　　　　　 ┃
//      ┃　　　━　　　┃
//      ┃　┳┛　  ┗┳　┃               高山仰止，景行行止，虽不能至，心向往之。
//      ┃　　　　　　 ┃               Codes are far away from bugs with the animal protecting.
//      ┃　　　┻　　　┃
//      ┃　　　　　　 ┃               * @Author：${USER}
//      ┗━┓　　　┏━━━┛               * @Date:：${DATE} ${HOUR}:${MINUTE}
//        ┃　　　┃                   * @Description：
//        ┃　　　┃
//        ┃　　　┗━━━━━━━━━┓
//        ┃　　　　　　　    ┣┓
//        ┃　　　　         ┏┛
//        ┗━┓ ┓ ┏━━━┳ ┓ ┏━┛
//          ┃ ┫ ┫   ┃ ┫ ┫
//          ┗━┻━┛   ┗━┻━┛
*/
public class main {
    public static void main(String[] args) throws InterruptedException {

        baozi bz= new baozi();   //作为锁对象，传递给两个线程
           //同一锁对象来控制wait、notify

        baozipu bzp =new baozipu("芭比馒头包子铺",bz);   //传递锁对象
        chihuo ch =new chihuo("吃包子大王",bz);   //传递锁对象

        //bzp.start();
        //ch.start();


        System.out.println(Thread.currentThread().getName());




        new Thread(new Runnable(){
            @Override
            public void run(){
                System.out.println("😄");
            }
        },"新线程").start();



    }


}
