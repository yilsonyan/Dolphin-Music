package cn.jd.object;

import org.junit.Test;

import java.util.Arrays;

/**
 * Object相关方法
 */
public class Reference {

	/**
	 * 观察两次输出，由于Score内部直接引用了外部传入的int[]数组，
	 * 这会造成外部代码对int[]数组的修改，影响到Score类的字段。
	 */
	@Test
	public void testClone() {
		class Score {
			private int[] scores;

			public Score(int[] scores) {
				//this.scores = scores;//这会造成外部代码对int[]数组的修改，影响到Score类的字段。
				this.scores = scores.clone();//TODO 修复Score的构造方法，使得外部代码对数组的修改不影响Score实例的int[]字段。
			}

			public void printScores() {
				System.out.println(Arrays.toString(scores));
			}
		}

		int[] scores = new int[]{88, 77, 51, 66};
		Score s = new Score(scores);
		s.printScores();
		scores[2] = 99;
		s.printScores();
	}


}
