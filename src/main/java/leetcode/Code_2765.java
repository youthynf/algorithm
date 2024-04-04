package leetcode;


public class Code_2765 {
    public static void main(String[] args) {
        int[] numbers = {14,30,29,49,3,23,44,21,26,52};

        Solution_2765 solution = new Solution_2765();
        int result = solution.alternatingSubarray(numbers);
        System.out.println(result);
    }
}

class Solution_2765 {
    public int alternatingSubarray(int[] nums) {
        int res = -1;
        int length = nums.length;

        if (length < 2 || nums[1] - nums[0] != 1) {
            return res;
        }

        for (int i = 0; i < length - 1; i++) {
            int flag = 0;
            int max = -1;
            for (int j = i; j < length - 1; j++) {
                int beforeNum = nums[j];
                int afterNum = nums[j + 1];
                if (beforeNum > afterNum) {
                    if (beforeNum - afterNum != 1) {
                        break;
                    }
                } else if (beforeNum < afterNum) {
                    if (afterNum - beforeNum != 1) {
                        break;
                    }
                } else {
                    break;
                }

                if (flag == 0) {
                    flag = beforeNum - afterNum;
                    max = 2;
                } else {
                    int tmpFlag = beforeNum - afterNum;
                    if (tmpFlag != -flag) {
                        break;
                    } else {
                        max++;
                        flag = tmpFlag;
                    }
                }
            }
            if (max > res) {
                res = max;
            }
        }
        return res;
    }
}