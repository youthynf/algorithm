package leetcode;

/**
 * 2765. 最长交替子数组
 * https://leetcode.cn/problems/longest-alternating-subarray/description/?envType=daily-question&envId=2024-01-23
 * 给你一个下标从 0 开始的整数数组 nums 。如果 nums 中长度为 m 的子数组 s 满足以下条件，我们称它是一个 交替子数组 ：
 * m 大于 1 。
 * s1 = s0 + 1 。
 * 下标从 0 开始的子数组 s 与数组 [s0, s1, s0, s1,...,s(m-1) % 2] 一样。也就是说，s1 - s0 = 1 ，s2 - s1 = -1 ，s3 - s2 = 1 ，s4 - s3 = -1 ，以此类推，直到 s[m - 1] - s[m - 2] = (-1)m 。
 * 请你返回 nums 中所有 交替 子数组中，最长的长度，如果不存在交替子数组，请你返回 -1 。
 * 子数组是一个数组中一段连续 非空 的元素序列。
 */
public class Code_2765 {
    public static void main(String[] args) {
        int[] numbers = {14,30,29,49,3,23,44,21,26,52};

        Solution_2765 solution = new Solution_2765();
        int result = solution.alternatingSubarray(numbers);
        System.out.println("result=" + result);

        int result2 = solution.alternatingSubarray(new int[]{1, 2, 1, 4, 5, 4, 5, 4, 9, 10});
        System.out.println("result2=" + result2);

        int result3 = solution.alternatingSubarray(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10});
        System.out.println("result3=" + result3);
    }
}

class Solution_2765 {
    public int alternatingSubarray(int[] nums) {
        int res = -1;
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            // 从开始下标的后一位开始
            for (int j = i + 1; j < length; j++) {
                // 计算当前交替子数组的长度
                int maxLen = j - i + 1;
                // 每一位判断的数与开始下标元素比较，相差1或者0，因此使用mod 2
                if (nums[j] - nums[i] == (maxLen - 1) % 2) {
                    // 当前交替子数组长度与之前的最大长度比较，取最大值
                    res = Math.max(res, maxLen);
                } else {
                    // 不满足交替条件，直接跳出循环
                    break;
                }
            }
        }
        return res;
    }
}