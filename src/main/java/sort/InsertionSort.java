package sort;

import utils.BasicUtil;

import java.util.Arrays;

/**
 * @ClassName: InsertionSort
 * @Description: 插入排序
 * @Author: ynf
 * @Date: 2022-04-05 13:51
 * @Version: 1.0
 */
public class InsertionSort {
    public static void main(String[] args) {
        int[] randomArray = BasicUtil.getRandomArray(10);
        System.out.println(Arrays.toString(randomArray));
        insertion_sort(randomArray);
        System.out.println(Arrays.toString(randomArray));
    }

    /*
     * 时间复杂度：O(n²）
     */
    public static void insertion_sort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        // 0 ~ 0 保证有序，已经完成，因此从 i = 1 开始
        // 0 ~ 1 保证有序，最多1次比较
        // 0 ~ 2 保证有序，最多2次比较
        // 0 ~ n - 1 保证有序，最多n-1次比较
        for (int i = 1; i < arr.length; i++) {
            // 往前比较，前面还有数而且比前一个数小才继续，否则结束
            for (int j = i - 1; j >= 0 && arr[j] > arr[j + 1]; j--) {
                BasicUtil.swap2(arr, j, j + 1);
            }
        }
    }
}
