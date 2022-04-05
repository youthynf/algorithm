package sort;

import utils.BasicUtil;

import java.util.Arrays;

/**
 * @ClassName: SelectionSort
 * @Description: 选择排序
 * @Author: ynf
 * @Date: 2022-04-05 12:37
 * @Version: 1.0
 */
public class SelectionSort {

    public static void main(String[] args) {
        int[] arr = {1, 5, 4, 2, 9, 3, 7, 6, 8, 0};
        System.out.println(Arrays.toString(arr));
        selection_sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    /*
     * 时间复杂度：O(n²)
     */
    public static void selection_sort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        // 每轮选择选出一个最值，需要进行 n - 1 轮选择
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            // 0 ~ n-1 找到最小值在哪，放到 0 位置上
            // 1 ~ n-2 找到最小值在哪，放到 1 位置上
            // 2 ~ n-3 找到最小值在哪，放到 2 位置上
            for (int j = i + 1; j <= arr.length - 1; j++) {
                minIndex = arr[j] < arr[minIndex] ? j : minIndex;
            }
            BasicUtil.swap(arr, i, minIndex);
        }
    }
}
