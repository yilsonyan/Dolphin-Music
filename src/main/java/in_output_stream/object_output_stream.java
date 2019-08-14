package in_output_stream;

import org.junit.Test;

import java.io.*;
import java.util.Scanner;

public class object_output_stream {

    public static void main(String[] args) throws IOException {
        Person person = new Person("Vincent",25);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("/Users/yilson/Desktop/obj.txt"));
        objectOutputStream.writeObject(person);
    }

    @Test
    public void read() throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("/Users/vincent/Desktop/obj.txt"));
        Person person = (Person) objectInputStream.readObject();
        System.out.println(person);
    }



    @Test
    public void read2() throws IOException, ClassNotFoundException {
        Scanner sc = new Scanner(System.in);
        //String next = sc.nextLine();
        //System.out.println(next);

        int i = sc.nextInt();
        System.out.println(i);
    }


    @Test
    public void read3() throws IOException, ClassNotFoundException {
        Scanner sc = new Scanner(new FileInputStream("/Users/yilson/Documents/travel.sql"));
        while (sc.hasNext()){
            String s = sc.nextLine();
            System.out.println(s);
        }

        System.out.println(sc);

    }



}
