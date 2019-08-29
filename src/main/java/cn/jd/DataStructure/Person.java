package cn.jd.DataStructure;

import lombok.*;

//@Data
@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class Person implements Cloneable{

    private String name;
    private int age;

    @Override
    public Person clone() throws CloneNotSupportedException {
        return (Person)super.clone();
    }
}
