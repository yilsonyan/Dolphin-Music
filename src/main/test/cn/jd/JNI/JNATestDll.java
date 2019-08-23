package cn.jd.JNI;

import com.sun.jna.Library;
import com.sun.jna.Native;

public interface JNATestDll extends Library {

    JNATestDll instanceDll  = Native.loadLibrary("JNATestDLL.dll",JNATestDll.class);

    public int add(int a,int b);

    public int factorial(int n);

}
