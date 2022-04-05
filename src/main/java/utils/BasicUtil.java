package utils;

/**
 * @ClassName: SortUtil
 * @Description: 基础工具类
 * @Author: ynf
 * @Date: 2022-04-03 19:13
 * @Version: 1.0
 */
public class BasicUtil {

    /**
     * 交换数据指定下标元素
     * @param arr
     * @param i
     * @param j
     */
    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
