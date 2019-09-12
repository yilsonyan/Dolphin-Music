package cn.jd.jvm;

import org.junit.Test;

import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

public class JvmTest {

	// print the Current JVM Heap Size, Maximum JVM Heap Size, and Free JVM Heap Size?
	@Test
	public void test4() throws Exception {
//		System.out.println("Current JVM Heap Size:"+Runtime.getMax());
//		System.out.println("Maximum JVM Heap Size:"+Runtime.getUsed());
//		System.out.println("Free JVM Heap Size:"+Runtime.getInit());
//		System.out.println("Current JVM Heap Size:"+Runtime.getRuntime().getCurrentSize());
//		System.out.println("Maximum JVM Heap Size:"+Runtime.getRuntime().getMaxSize());
//		System.out.println("Free JVM Heap Size:"+Runtime.getRuntime().getFreeSize());
//		System.out.println("Current JVM Heap Size:" + Runtime.getRuntime().getTotalHeapMemory(););
//		System.out.println("Maximum JVM Heap Size:" + Runtime.getRuntime().getMaxHeapMemory());
//		System.out.println("Free JVM Heap Size:" + Runtime.getRuntime().getFreeHeapMemory());

		//TODO 必须通过Runtime.getRuntime()获取对象；获取内存得方法没有get前缀
		System.out.println("Current JVM Heap Size:" + Runtime.getRuntime().totalMemory()/1024/1024);
		System.out.println("Maximum JVM Heap Size:" + Runtime.getRuntime().maxMemory()/1024/1024);
		System.out.println("Free JVM Heap Size:" + Runtime.getRuntime().freeMemory()/1024/1024);
//		System.out.println("Current JVM Heap Size:"+Runtime.totalMemory());
//		System.out.println("Maximum JVM Heap Size:"+Runtime.maxMemory());
//		System.out.println("Free JVM Heap Size:"+Runtime.freeMemory());
	}



	@Test
	public void test5() throws Exception {
		String abc = new String("abc");
		SoftReference<String> softReference = new SoftReference<>(abc);   //软引用


		String xyz = new String("xyz");
		WeakReference<String> weakReference = new WeakReference<>(xyz);   //软引用

	}


}
