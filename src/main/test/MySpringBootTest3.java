//@cn.jd.SpringBootTest(classes= PosApp.class,webEnvironment = cn.jd.SpringBootTest.WebEnvironment.DEFINED_PORT)
//@RunWith(SpringRunner.class)
//@EnableWebSocket
//@EnableAutoConfiguration


import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.function.Consumer;

class MyCollection<T> {
	private Set<T> set;
	public Set<T> getCollection() {
		return this.set;
	}




	/*public void TestCollection1(MyCollection<?> collection) {
		Set<> set = collection.getCollection();
	}

	public void TestCollection1(MyCollection<?> collection) {
		Set<?> set = collection.getCollection();
	}

	public void TestCollection3(MyCollection<?> collection) {
		Set set = collection.getCollection();
	}

	public void TestCollection4(MyCollection<?> collection) {
		Set<E> set = collection.getCollection();
	}

	public void TestCollection5(MyCollection<?> collection) {
		Set<T> set = collection.getCollection();
	}*/



}


class A{
	static int total = 10;
	public void call() {
		int total = 5;
		System.out.println(this.total);//?
	}
	public static void main (String args []) {
		A a1 = new A();
		a1.call();


		boolean b = false;
		System.out.println((b = true) ? "true" : "false");

		int a = 0;
		System.out.println((a != 0) ? "true" : "false");

		Double d = null;
		System.out.println((d instanceof Double) ? "true" : "false");

		String e = "1";
		System.out.println(("1" != e) ? "true" : "false");

		int c = 0;
		System.out.println((0 == c++) ? "true" : "false");
	}
}

class IkmTest {

	static class Helper {
		private int data = 5;
		public void bump(int inc) {
			inc++;
			data = data + inc;
		}
	}

	public static void main(String []args) {
		Helper h = new Helper();
		int data = 2;
		h.bump(data);
		System.out.println(h.data + " " + data);



		int i = 10, j = 12;
		for (;;) {
			if (i++ < j--)
				continue;
			else
				break;
			//System.out.println(i + " " + j);
		}
	}
}



class CalendarTest {
	public static void main(String args[]) {
		Date aDate = null;
		try {
			aDate = new SimpleDateFormat("yyyy-mm-dd").parse("2012-01-15");
			Calendar aCalendar = Calendar.getInstance();
			aCalendar.setTime(aDate);
			System.out.print(aCalendar.get(aCalendar.DAY_OF_MONTH)+"," +  aCalendar.get(aCalendar.MONTH));

			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			LocalDate bDate = LocalDate.parse("2012-01-15", formatter);
			System.out.print(" " + bDate.getDayOfMonth()+"," +  bDate.getMonthValue());

		} catch (ParseException ex) {System.out.println("ParseException " + ex);
		} catch (DateTimeParseException ex) {System.out.println(" DateTimeParseException " + ex);
		}

		Integer iiii = new Integer("iiii");

	}
}


class IkmTest2 {
	public IkmTest2() {
		this(10);
	}
	public IkmTest2(int data) {
		this.data = data;
	}
	public void display() {
		class Decrementer {
			public void decrement () {
				data--;
			}
		}
		Decrementer d = new Decrementer();
		d.decrement();
		System.out.println("data = " + data);
	}

	private int data;

	public static void main (String [] args) {
		int data = 0;
		IkmTest2 t = new IkmTest2();
		t.display();
		System.out.println("data = " + data);
	}
}



interface MyInterface2 {
	void method1();
	static void method2() {}
}

abstract class Parent implements MyInterface2 {
	//abstract void method1();//Parent is attempting to reduce the visibility of method1.
}

abstract class Child extends Parent implements MyInterface2 {
	public void method1() {
		//do stuff
	}
	//public static void method2();
}




interface StringMapper<T> {
	String map(T t);
}
class X {
	String s;
	public X(String s) { this.s=s; }
	@Override public String toString() { return s.toLowerCase();}
	public String toLowerCase() { return s.toLowerCase();}
}
class Y<T> {
	T s;
	public Y(T s) { this.s=s; }
	@Override public String toString() { return s.toString();}
}
class H2 {
	static String mapme(Y y, StringMapper<Y> t) {
		return t.map(y);
	}
	static String mapme(X x, StringMapper<X> t) {
		return t.map(x);
	}
	public static void main(String[] args) {
		System.out.println(mapme(new Y<>("HELLO"),e -> e.toString()));
		System.out.println(mapme(new Y<>(3),e -> {return e.toString().equals("3")? "hello":"HELLO";}));
		System.out.println(mapme(new X("HELLO"),
				e -> {if (e.s.charAt(0)=='H') return e.toString();return e.toLowerCase();}));
		System.out.println(mapme(new Y<>(3),e -> e.toString()));
		System.out.println(mapme(new Y<>(new X("HELLO")),  e -> { return e.toString();}));
	}
}




class JavaClass {
	public static void main(String arg[]) {
		//meth(arg);
	}
	public void meth(String[] arg) throws Exception {
		System.out.println(arg);
		System.out.println(arg[1]);



		//Which of following Java SE expressions can be valid when accessing the file file.txt for reading?
		/*FileReader fr = new Reader("file.txt");
		FileInputStream fis = new FileInputStream("file.txt");
		InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
		InputStreamReader isr2 = new InputStreamReader("file.txt", "UTF-16E");
		FileInputStream fis2 = new FileInputStream("file.txt");
		FileReader fr2 = new FileReader(fis2);
		RandomAccessFile rf = new RandomAccessFile("file.txt", "r");*/
	}
}



class LongEx{
	public static void main(String args[]){
		Long i = new Long(10);
		long j = 10;
		long k = -5;
		if(i.equals(j))
			System.out.println("i is equal to j");
		else
			System.out.println("i is not equal to j");
		if(Long.compare(i,k)>0)
			System.out.println("i is greater than k");
		else
			System.out.println("i is less than k");
		if(Long.compareUnsigned(i,k)>0)
			System.out.println("i is greater than k");
		else
			System.out.println("i is less than k");




		//A Java SE application com.ikmnet.MyJavaApp is to be deployed as an executable jar file. Which of the following are steps that can be part of the process for successfully creating this jar file?
		/*A.	Build the JAR file without a manifest.
				B.	Add to the manifest:
		Main-Class: com.ikmnet.MyJavaApp
		C.	Ensure that MyJavaApp does not include a main method.
				D.	Compile the Java code to produce an EXE file instead of bytecode.
				E.	Build the JAR file using the command:
		jar –executable com\ikmnet\MyJavaApp.java*/
	}
}



class StringBuilderDemo {


	/**
	 *
	     The output will be:
		 Test null Test 1 2 3 test
		 1 2 3
	 */
	public static void main(String[] args) throws Exception {
		String s = "StringBuilderDemo Test null Test 1 2 3 test";
		String[] s1 = s.split(" ");
		test3(s1);
	}

	//public static void main(String[] argList) {
	public static void test3(String[] argList) throws Exception {
		StringBuilder str = new StringBuilder();
		for (String arg : argList) {
		        if (str.indexOf(arg)<1)
		                 str.append(arg+" ");
		     }
		System.out.println(str.toString());
		Scanner sc = new Scanner(str.toString());
		while (sc.hasNext()){
		        if(sc.hasNextInt())
		                System.out.print(sc.nextInt() + " ");
		        else
		            sc.next();
		    }
	}
}



//Which of the following correctly describe the output of executing the Java code below?
class MyClass3 {
	public static void main(String args[]) {
		MyClass3 myClass = new MyClass3();
		Class c = myClass.getClass();
		try {
			System.out.println(c.getMethod("getNumber", null).toString());
			System.out.println(c.getDeclaredMethod("setNumber", null).toString());
		} catch (NoSuchMethodException | SecurityException e) { //"|"??????

		}
	}
	public Integer getNumber() {
		return 2;
	}
	public void setNumber(Integer n) {
	}
}



class IKMProcessor {
	public List<String> queueSequence;
	public void setUp() {
		try {
			establishQueueSequence();
		}
		finally {
			cleanupQueueSequence();
			System.out.println("Queue sequence successfully cleaned up");
		}
	}
	private void cleanupQueueSequence() {
		if (queueSequence.size() > 0) {
			System.out.println("Queue size > 0");
		}
	}
	private void establishQueueSequence() {
		if (true) {
			throw new IllegalArgumentException();
		}
		queueSequence = new ArrayList<String>();
	}

	public static void main(String[] args) {
		IKMProcessor processor = new IKMProcessor();
		processor.setUp();
		System.out.println("Processing complete");

	}
}



class BaseLogger {
	private static BaseLogger log = new BaseLogger();
	private BaseLogger() {}
	public synchronized static BaseLogger getInstance() {
		return log;
	}
	private StringBuilder logMessage = new StringBuilder();
	public void addLog(String logMessage) {
		this.logMessage.append(logMessage + "|");
		//Logic to write log into file.
	}
	public void printLog() {
		System.out.println(logMessage.toString());//To print log.
	}
}



class CalendarTest22 {
	public static void main(String[] args) {
		Date aDate = null;
		Calendar aCalendar = Calendar.getInstance();
		aCalendar.setTimeInMillis(1450000000000L);
		aDate = aCalendar.getTime();
		System.out.print(new SimpleDateFormat("dd-MMM-yyyy").format(aDate));

		Instant anInstant = Instant.ofEpochMilli(1450000000000L);
		DateTimeFormatter d = DateTimeFormatter.ofPattern("dd-MMM-yyyy");
		System.out.println(" " + LocalDateTime.ofInstant(anInstant, ZoneId.systemDefault()).format(d));

		aCalendar.add(Calendar.DAY_OF_MONTH, 60);
		aDate = aCalendar.getTime();
		System.out.print(new SimpleDateFormat("dd-MMM-yyyy").format(aDate));

		anInstant.plus(60, ChronoUnit.DAYS);
		System.out.println(" " + LocalDateTime.ofInstant(anInstant, ZoneId.systemDefault()).format(d));
	}
}



class FileClass {
	public static void main(String args[]) throws IOException {
		Optional<String> f=Optional.of("file1.java");
		File f1 = new File(f.get());



		Reader iout0 = new FileReader(f1);
		//InputStream iout1 = new InputStream(f1);
		FileOutputStream iout2 = new FileOutputStream(f1);
		//RandomAccessFile rf = new RandomAccessFile(f1);
		InputStream iout3 = new FileInputStream(f1);
	}
}

//A class declared abstract must have at least one abstract method.? NO
abstract class FileClass5 {
	public static void main(String[] args) {

		Runnable r = () -> System.out.println("HI");
		new Thread(r).start();
	}

}




class LinkEx{
	public static void main(String args[]) {
		Set<String> set = new LinkedHashSet<String>();
		set.add("3");
		set.add("1");
		set.add("3");
		set.add("2");
		set.add("3");
		set.add("1");
		set.forEach(s -> System.out.print(s+"-"));
	}
}


class EnumDemo {
	public static void main(String[] args) {
		String cmd = "MNGRPT";
		String[] s = cmd.split(" ");
		test(s);
	}
	public static void test(String args[]) {
		String report = args[0];
		if (report.equals(Report.EMPRPT.getName()))
			System.out.println("Id: " + Report.EMPRPT.getId() + " Name: " + Report.EMPRPT.getName());
		if (report.equals(Report.EMPRPT))
			System.out.println("Id: " + Report.EMPRPT.getId() + " Name: " + Report.EMPRPT.getName());
		if (report.equals(Report.MNGRPT.toString()))
			System.out.println("Id: " + Report.MNGRPT.getId() + " Name: " + Report.MNGRPT.getName());
		if (report.equals(Report.MNGRPT.name()))
			System.out.println("Id: " + Report.MNGRPT.getId() + " Name: " + Report.MNGRPT.getName());
	}

	public enum Report {
		EMPRPT(1, "EMPLOYEE_REPORT"), MNGRPT(2, "MANAGER_REPORT");
		private String name;
		private int id;

		Report(int id, String name) {
			this.setName(name);
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public int getId() {
			return this.id;
		}
	}
}



class IKMTest {
	public static void main(String[] args) {
		Double d = 1.0;
		if (d instanceof Number)
			d = d++;
		boolean condition1 = (d == 2) ? true : false;
		if(condition1)
			System.out.println("Perform action1");
		double e = 1.0;
		if ((Double) e instanceof Double | d++ == e++)
			d += d;
		boolean condition2 = (d > 2) ? true : false;
		if(condition2)
			System.out.println("Perform action2");
		boolean condition3 = condition1 ^ condition2;
		if(condition3)
			System.out.println("Perform action3");
	}
}



class Invoice {
	public static String formatId(String oldId) {
		return oldId + "_Invoice";
	}
}
class SalesInvoice extends Invoice {
	public static String formatId(String oldId) {
		return oldId + "_SalesInvoice";
	}

	public static void main(String[] args) {
		// TODO 静态得内容是谁的就运行谁的
		Invoice invoice = new SalesInvoice();
		System.out.println(invoice.formatId("1234"));


		SalesInvoice invoice2 = new SalesInvoice();
		System.out.println(invoice2.formatId("1234"));
	}
}





class Person {
	String name;
	Integer id;
	Person(String n, Integer i) { name=n; id=i; }
	Person(Integer i) {name=null; id=i;}
	@Override public String toString() { return name + " " + id; }
}
class PersonTest {
	static List<Person> people = Arrays.asList(
			new Person("Bob",1),new Person(2),new Person("Jane",3));
	static int x;
	public static void main(String[] args) {
		people.stream()
				.reduce((e1,e2) -> { x=e1.id; if (e1.id > e2.id) return e1; x=e2.id; return e2;})
				.flatMap(e -> Optional.ofNullable(e.name))
				.map(y -> new Person(y,x))
				.ifPresent(System.out::println);
	}
}





class Invoice2 {
	public static String formatId(String oldId) {
		return oldId + "_Invoice";
	}
}

class SalesInvoice2 extends Invoice2 {
	public static String formatId(String oldId) {
		return oldId + "_SalesInvoice";
	}

	public static void main(String[] args) {
		Invoice invoice = new Invoice();
		System.out.println(invoice.formatId("1234"));

	}
}





class Person2 {
	String name;
	Integer id;
	Person2(String n, Integer i) { name=n; id=i; }
	Person2(Integer i) {name=null; id=i;}
	@Override public String toString() { return name + " " + id; }
}
class PersonTest2 {
	static List<Person2> people = Arrays.asList(
			new Person2("Bob",1),new Person2(2),new Person2("Jane",3));
	static int x;
	public static void main(String[] args) {
		people.stream()
				.reduce((e1,e2) -> { x=e1.id; if (e1.id > e2.id) return e1; x=e2.id; return e2;})
				.flatMap(e -> Optional.ofNullable(e.name))
				.map(y -> new Person(y,x))
				.ifPresent(System.out::println);
	}
}




class Namer {
	final private String firstName,lastName;
	public Namer(String fn,String ln) { firstName=fn; lastName=ln;}
	public String getFirstName() { return firstName; }
	public String getLastName()  { return lastName;  }
}
class Sorter {
	public static void main(String[] args) {
		Consumer<Namer> printit = e -> System.out.println(e.getFirstName() + " " + e.getLastName());
		List<Namer> names = new ArrayList(Arrays.asList(
				new Namer("Harry","Smith"),new Namer("Joe","Smith"),new Namer("Jane","Doe"),
				new Namer("Mary","Jane"),new Namer("Harry","Homeowner")));

		/*Comparator<Namer> groupBy = Comparator.comparing(e -> e.getFirstName());
		groupBy = groupBy.thenComparing(e -> e.getLastName());
		names.removeIf(e -> e.getFirstName().equals("Mary"));
		names.sort(groupBy);
		names.forEach(printit);*/

		Comparator<Namer> groupBy = Comparator.comparing(e -> e.getLastName());
		groupBy = groupBy.thenComparing(e -> e.getFirstName());
		names.removeIf(e -> e.getFirstName().equals("Mary"));
		names.sort(groupBy);
		names.forEach(printit);
	}
}