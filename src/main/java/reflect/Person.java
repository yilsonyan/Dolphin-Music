package reflect;

import lombok.Data;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Data
public class Person implements Serializable {

    private static final long serialVersionUID=-67868L;

    private String name;
    private int age;



    private Set<Person> loveSb(){
        Person person1 = new Person();
        person1.setName("tangli");
        person1.setAge(24);

        Person person2 = new Person();
        person2.setName("tangxiaoli");
        person2.setAge(18);

        Set<Person> set1 = new HashSet<>();
        set1.add(person1);
        set1.add(person2);

        return set1;
    }

}
