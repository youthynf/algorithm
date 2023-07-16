package leetcode;

import java.net.Inet4Address;
import java.util.Arrays;
import java.util.HashMap;

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
