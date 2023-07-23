package leetcode;

import java.util.Arrays;

/**
 * 给你一个数组 nums 。数组「动态和」的计算公式为：runningSum[i] = sum(nums[0]…nums[i]) 。
 * 请返回 nums 的动态和。
 * 输入：nums = [1,2,3,4]
 * 输出：[1,3,6,10]
 * 解释：动态和计算过程为 [1, 1+2, 1+2+3, 1+2+3+4] 。
 */
public class Code_1480 {

    public static void main(String[] args) {
        int[] nums = {1,1,1,1,1};
        int[] res = runningSum2(nums);
        System.out.println(Arrays.toString(res));
    }

    public static int[] runningSum(int[] nums) {
        int length = nums.length;
        int[] res = new int[length];
        int tmp = 0;
        for (int i = 0; i < length; i++) {
            tmp += nums[i];
            res[i] = tmp;
        }
        return res;
    }

    public static int[] runningSum2(int[] nums) {
        int[] res = new int[nums.length];
        res[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            res[i] = res[i - 1] + nums[i];
        }
        return res;
    }

}
