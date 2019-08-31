package cn.jd.jdk8_features;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

public class LambdaTest {

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