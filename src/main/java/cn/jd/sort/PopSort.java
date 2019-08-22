package cn.jd.sort;

import org.junit.Test;

import java.util.Arrays;

//排序
public class PopSort {

    /**
     * 冒泡排序bubbleSort
     * 掌握，简单的排序算法，两个循环中交换位置就行
     * 在要排序的一组数中，自上而下对相邻的两个数依次进行比较和调整，让较大的数往下沉，较小的往上冒
     * 最佳情况：T(n) = O(n)   最差情况：T(n) = O(n^2)   平均情况：T(n) = O(n^2)
     */
    @Test
    public void bubbleSort() {
        int[] array = {9, 2, 4, 3, 7, 5, 8, 1};

        for (int i = 0; i < array.length - 1; i++) {   //外层循环这个数组（长度减1，最后一个不用排序，会空指针）
            int temp = 0;   //中间变量
            for (int j = 0; j < array.length - 1 - i; j++) {   //内层循环这个数组
                if (array[j] > array[j + 1]) {   //如果这个元素 > 后边这个元素，则让他们对换位置
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        System.out.println(" bubbleSort：" + Arrays.toString(array));  //数组转字符串
    }


    /**
     * 选择排序（Selection Sort）
     * 表现最稳定的排序算法之一，因为无论什么数据进去都是O(n2)的时间复杂度，
     * 所以用到它的时候，数据规模越小越好。唯一的好处可能就是不占用额外的内存空间了吧。
     * 选择排序可能也是平时排序一般人想到的最多的排序方法了吧。
     * 首先在未排序序列中找到最小（大）元素，存放到排序序列的起始位置，
     * 然后，再从剩余未排序元素中继续寻找最小（大）元素，然后放到已排序序列的末尾。
     * 以此类推，直到所有元素均排序完毕。
     */
    @Test
    public void SelectionSort() {
        int[] array = {9, 2, 4, 3, 7, 5, 8, 1};
        for (int i = 0; i < array.length; i++) {   //外层循环
            int minIndex = i;   //中间变量，当前最小的数的索引
            for (int j = i; j < array.length; j++) {   //内层循环
                if (array[j] < array[minIndex]){
                    minIndex = j;//当前最小的数的索引
                }
            }
            int temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;
        }
        System.out.println(" Selection：" + Arrays.toString(array));  //数组转字符串
    }


}
