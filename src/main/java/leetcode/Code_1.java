package leetcode;

 import java.util.Arrays;
import java.util.HashMap;

/**
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 * 你可以按任意顺序返回答案。
 */
public class Code_1 {

    public static void main(String[] args) {
        int[] nums = {3, 2, 4};
        int target = 6;
        System.out.println(Arrays.toString(twoSum(nums, target)));

        int[] nums2 = {2,7,11,15};
        int target2 = 26;
        System.out.println(Arrays.toString(twoSum(nums2, target2)));

        int[] nums3 = {3, 2, 4};
        int target3 = 6;
        System.out.println(Arrays.toString(twoSum2(nums3, target3)));

        int[] nums4 = {2,7,11,15};
        int target4 = 26;
        System.out.println(Arrays.toString(twoSum2(nums4, target4)));

        Solution_1 solution1 = new Solution_1();
        System.out.println(Arrays.toString(solution1.twoSum(nums4, target4)));
    }


    /**
     * 先排序，后使用双指针确定数值，再确定下标
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum(int[] nums, int target) {
        int[] copyNums = Arrays.copyOf(nums, nums.length);
        Arrays.sort(copyNums);
        int[] targetNum = new int[2];
        int i = 0, j = copyNums.length - 1;
        while (i < j) {
            if (copyNums[i] + copyNums[j] == target) {
                targetNum[0] = copyNums[i];
                targetNum[1] = copyNums[j];
                break;
            } else if (copyNums[i] + copyNums[j] < target) {
                i++;
            } else {
                j--;
            }
        }

        int[] res = new int[2];
        int index = 0;
        for (int k = 0; k < nums.length; k++) {
            if (nums[k] == targetNum[0] || nums[k] == targetNum[1]) {
                res[index] = k;
                index++;
            }
        }

        return res;
    }

    /**
     * 使用map降低时间复杂度
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum2(int[] nums, int target) {
        int[] res = new int[2];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                res[0] = i;
                res[1] = map.get(target - nums[i]);
                break;
            }
            map.put(nums[i], i);
        }
        return res;
    }

}

class Solution_1 {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> targetMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (targetMap.containsKey(target - nums[i])) {
                return new int[]{targetMap.get(target - nums[i]), i};
            }
            targetMap.put(nums[i], i);
        }
        return new int[0];
    }
}
