package cn.jd.JNI;

public class HelloWorld {
    static {
        //导入 HelloWorld c语言库（即导入libHelloWorldNative.jnilib文件）
        System.loadLibrary("HelloWorldNative");
    }

    //定义一个本地方法【类似java的接口，需要c语言去具体实现方法】
    public static native void cMethod();

    public static void main(String[] args){
        //调用该方法
        cMethod();
    }

}
