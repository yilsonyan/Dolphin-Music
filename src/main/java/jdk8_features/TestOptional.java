package jdk8_features;

import org.apache.tomcat.jni.User;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TestOptional {


    @Test
    public void whenCreateEmptyOptional_thenNull() {
        //List list = null;
        List list = new ArrayList();


        Optional<List> optional = Optional.ofNullable(list);
        if (optional.isPresent()){
            List get = optional.get();
            System.out.println(get);
        }
    }



}
