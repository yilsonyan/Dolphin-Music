package cn.jd;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

//@cn.jd.SpringBootTest(classes= PosApp.class,webEnvironment = cn.jd.SpringBootTest.WebEnvironment.DEFINED_PORT)
//@RunWith(SpringRunner.class)
//@EnableWebSocket
//@EnableAutoConfiguration
public class MySpringBootTest {


	@Test
	public void test() throws Exception {
		String str1 = "My String";
		String str2 = new String ("My String");

		System.out.println(str1.matches(str2));
		System.out.println(str1.hashCode() == str2.hashCode());;
	}



	// TODO finally must appear with catch ？ NO
	@Test
	public void test2() throws Exception {

		try {
			String str1 = "My String";
		} finally {
			System.out.println(111);
		}

	}


	// Which of the following correctly define a Java object that can read lines of text from file input.dat?
	@Test
	public void test3() throws Exception {

		/*BufferedReader inputStream1 = new BufferedReader("input.dat");
		BufferedReader inputStream2 = new BufferedReader(new FileReader("input.dat"));
		BufferedReader inputStream3 = new BufferedReader(new File("input.dat"));
		FileReader inputStream4 = new FileReader("input.dat");

		BufferedReader inputStream5 = new BufferedReader(new InputStreamReader("input.dat"));*/
	}


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
		System.out.println("Current JVM Heap Size:" + Runtime.getRuntime().totalMemory());
		System.out.println("Maximum JVM Heap Size:" + Runtime.getRuntime().maxMemory());
		System.out.println("Free JVM Heap Size:" + Runtime.getRuntime().freeMemory());
//		System.out.println("Current JVM Heap Size:"+Runtime.totalMemory());
//		System.out.println("Maximum JVM Heap Size:"+Runtime.maxMemory());
//		System.out.println("Free JVM Heap Size:"+Runtime.freeMemory());
	}



}



class Indices {
	public String s;
	public List<Integer> indices;
	public Indices(String s) {
		this.s=s;
		indices= new LinkedList<>();
		for (int i=0;i<this.s.length();++i) {
			indices.add(i);
		}
	}
}

class TestIndices {
	public static void main(String[] args){
		Stream.of(new Indices("Mercury"),new Indices("Venus"),new Indices("Earth"))
			.flatMap( i -> i.indices.stream())
			.mapToInt(j -> j)
			.max()
			.ifPresent(System.out::println);
	}
}