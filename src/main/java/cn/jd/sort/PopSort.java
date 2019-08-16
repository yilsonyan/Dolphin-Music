package cn.jd.sort;

import org.junit.Test;

import java.util.Arrays;

//排序
public class PopSort {

    /**
     * 冒泡排序bubbleSort（掌握）
     * 在要排序的一组数中，自上而下对相邻的两个数依次进行比较和调整，让较大的数往下沉，较小的往上冒
     */
    @Test
    public void bubbleSort() {
        int[] array={9,2,4,3,7,5,8,1};
        int temp = 0;   //中间变量
        for (int i = 0; i < array.length - 1; i++) {   //外层循环这个数组（长度减1，最后一个不用排序，会空指针）
            for (int j = 0; j < array.length - 1 - i; j++) {   //内层循环这个数组
                                                        //array.length - 1 - i   ???
                if (array[j] > array[j + 1]) {   //如果这个元素 > 后边这个元素，则让他们对换位置
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        System.out.println(" bubbleSort："+Arrays.toString(array));  //数组转字符串
    }









}
