package leetcode;

import java.util.Arrays;

public class Code_1802 {

    public static int maxValue(int n, int index, int maxSum) {
        int count = 0;
        int[] res = new int[n];
        while (count < maxSum) {
            if (count == 0) {
                for (int i = 0; i < n; i++) {
                    res[i]++;
                    count++;
                }
                continue;
            }

            res[index]++;
            count++;
            if (count >= maxSum) {
                break;
            }

            int left = index - 1;
            int right = index + 1;
            if (res[index] - res[left] > 1) {
                while (left > 0) {
                    res[left]++;
                    count++;
                    if (count >= maxSum) {
                        break;
                    }

                    if (res[left] - res[left-1] > 1) {
                        left--;
                    } else {
                        break;
                    }
                }

            }

            if (res[index] - res[right] > 1) {
                while (right < n) {
                    res[right]++;
                    count++;
                    if (count >= maxSum) {
                        break;
                    }

                    if (res[right] - res[right + 1] > 1) {
                        right++;
                    } else {
                        break;
                    }
                }
            }
        }
        System.out.println("res=" + Arrays.toString(res));
        return res[index];
    }

    public static void main(String[] args) {
        int n = 4;
        int index = 2;
        int maxSum = 6;
        int res = maxValue(n, index, maxSum);
        System.out.println("n=" + n + ", index=" + index + ", maxSum=" + maxSum + ", res=" + res);
    }
}
