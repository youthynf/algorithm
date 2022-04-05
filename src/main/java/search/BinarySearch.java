package search;

import sort.SelectionSort;
import utils.BasicUtil;

import java.util.Arrays;

/**
 * @ClassName: BinarySearch
 * @Description: 二分查找
 * @Author: ynf
 * @Date: 2022-03-14 23:45
 * @Version: 1.0
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] randomArr = BasicUtil.generateRandomArray(10, 100);
        SelectionSort.selection_sort(randomArr);
        System.out.println(Arrays.toString(randomArr));
        int targetNum = (int) (Math.random() * 100);
        boolean isExist = binary_search(randomArr, targetNum);
        System.out.println(targetNum + " is in array :" + isExist);
    }

    /*
     * 时间复杂度：O(logN)
     */
    public static boolean binary_search(int[] sortedArr, int targetNum) {
        if (sortedArr == null || sortedArr.length == 0) {
            return false;
        }

        int L = 0;
        int R = sortedArr.length - 1;
        int mid;

        // L..R 至少两个数的时候
        while(L < R) {
            // 优化点：计算中间位置时（L + R)/2，L和R过大将会导致溢出，>>1 表示除以2
            // int mid = (L + R) / 2;
            mid = L + ((R - L) >> 1);

            if (sortedArr[mid] == targetNum) {
                return true;
            } else if (sortedArr[mid] > targetNum) {
                R = mid - 1;
            } else {
                L = mid + 1;
            }
        }
        // 最后还可能剩下一个数，因此需要继续验证一次
        return sortedArr[L] == targetNum;
    }
}
