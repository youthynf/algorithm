package sort;

import utils.BasicUtil;

import java.util.Arrays;

/**
 * @ClassName: BubbleSort
 * @Description: 冒泡排序
 * @Author: ynf
 * @Date: 2022-03-14 23:10
 * @Version: 1.0
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {1, 5, 4, 2, 9, 3, 7, 6, 8, 0};
        System.out.println(Arrays.toString(arr));
        bubble_sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    /*
     * 时间复杂度：O(n²)
     * 如果在比较过程中增加状态标识，能达到最优时间复杂度O(n)
     */
    public static void bubble_sort(int[] arr) {
        int length = arr.length;
        // 没确定一个最值，都需要进行一趟冒泡，总共需要 n - 1 趟
        for (int i = 0; i < length - 1; i++) {
            // 0 ~ n-1 两两比较，数值比后一个大，则交换
            // 0 ~ n-2 两两比较，数值比后一个大，则交换
            // ......
            // 0 ~ 1 两两比较，数值比后一个大，则交换
            for( int j = 0; j < length - 1 - i; j++) {
                if (arr[j] > arr[j+1]) {
                    BasicUtil.swap(arr, j, j+1);
                }
            }
        }
    }
}
