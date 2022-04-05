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
     */
    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    /**
     * 交换数据指定下标元素
     */
    public static void swap2(int[] arr, int i, int j) {
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }

    /*
     * 获取随机数组
     */
    public static int[] getRandomArray(int length) {
        int[] arr = new int[length];
        for (int i = 0; i < length; i++) {
            arr[i] = (int) (Math.random() * length);
        }
        return arr;
    }
}
