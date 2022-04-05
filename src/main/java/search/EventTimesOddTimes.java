package search;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * @ClassName: EventTimesOddTimes
 * @Description: 异或运算的使用
 * @Author: ynf
 * @Date: 2022-04-05 18:45
 * @Version: 1.0
 */
public class EventTimesOddTimes {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 3, 4, 2, 4, 5, 5};
        System.out.println(Arrays.toString(arr));
        printOddTimesNum1(arr);
        System.out.println("----------------------------");

        int[] arr2 = {2, 3, 3, 2, 4, 2, 4, 5};
        System.out.println(Arrays.toString(arr2));
        printOddTimesNum2(arr2);
        System.out.println("----------------------------");

        testOnlyKTimes();
    }
    /*
     * 题目一：arr中，只有一种数出现奇数次，其他都是出现偶数次，找出该数。
     * 解题思路：出现偶次的数，异或最终都会变成0，因此，所有数遍历异或，最终就得到了奇数次的数。
     */
    public static void printOddTimesNum1(int[] arr) {
        int eor = 0;
        for (int i = 0; i < arr.length; i++) {
            eor ^= arr[i];
        }
        System.out.println("数组中出现奇数次的数为：" + eor);
    }

    /*
     * 题目二：怎么把一个int类型的数，提取出最右侧的1来。
     * 解题思路：a & (-a)
     */

    /*
     * 题目三：arr中，有两种数，出现奇数次，其他都是偶数次，找出这两种数。
     * 解题思路：
     * 1.遍历异或，最终必定等于这两种数异或，因为其他偶数次异或后变0；
     * 2.因为这两个数不同，因此异或的结果不可能为0，找出这两个数异或结果任意一位为1的数；
     * 3.将所有的数按照这个位是否为1，分为两半，那么就将想要的两种数隔离开了；
     * 4.最后分别找出只出现奇数次的数，同题目一的解法。
     */
    public static void printOddTimesNum2(int[] arr) {
        // 1.遍历异或，最终必定等于这两种数(a ^ b)异或，因为其他偶数次异或后变0；
        int eor = 0;
        for (int i = 0; i < arr.length; i++) {
            eor ^= arr[i];
        }
        // 2.找出结果最右的1
        int rightOne = eor & (-eor);

        int eor2 = 0;
        for (int i= 0; i < arr.length; i++) {
            // 3.通过判断指定位置是否为1来进行区分
            // arr[i] = 111100011110000
            // rightOne = 0000000010000
            if ((arr[i] & rightOne) != 0) {
                eor2 ^= arr[i];
            }
        }
        // 4.最后得到这两种数
        System.out.println("数组中出现奇数次的数为：" + eor2 + "，" + (eor ^ eor2));
    }

    /*
     * 题目四：一个数组中有一种数出现了K次，其他数出现了M次，其中M>1，K<M，找到出现K次的数，要求额外空间复杂度O(1)，时间复杂度O(N)。
     * 解题思路：使用一个长度为32的整型数组，保存数组中所有数字各个位中1出现的次数，如果次数不是M的整数倍，说明出现K次的数值在这个位上必定是1.
     */
    public static int onlyKTimes(int[] arr, int k, int m) {
        int[] t = new int[32];
        // t[0] 0位置上的1出现了几次
        // t[i] i位置上的1出现了几次
        for (int num : arr) {
            for (int i = 0; i < 32; i++) {
                t[i] += (num >> i) & 1;
            }
        }

        int ans = 0;
        for (int i = 0; i < 32; i++) {
            // 如果i位置上的1出现的次数不是m的整数倍，说明出现k次的数在该位置上必定是1
            if (t[i] % m != 0) {
                ans |= (1 << i);
            }
        }
        return ans;
    }

    // 对数器检测
    public static int test(int[] arr, int k, int m) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : arr) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }

        for (Integer num : map.keySet()) {
            if (map.get(num) == k) {
                return num;
            }
        }
        return -1;
    }

    public static int[] randomArray(int maxKinds, int range, int k, int m) {
        // 选取一个随机数作为真命天子
        int kTimeNum = randomNumber(range);
        // 数组中含有几种数，但必须大于2
        int numKinds = (int) (Math.random() * maxKinds) + 2;
        // 新建一个数组用来存放这个随机数组结果，长度为 k * 1 + m * (numKinds - 1)
        int[] arr = new int[k + m * (numKinds - 1)];

        // 将随机数存入数组中
        int index = 0;
        for(; index < k; index++) {
            arr[index] = kTimeNum;
        }
        numKinds--;
        HashSet<Integer> set = new HashSet<>();
        set.add(kTimeNum);
        while (numKinds != 0) {
            int curNum = 0;
            do {
                curNum = randomNumber(range);
            } while (set.contains(curNum));
            set.add(curNum);
            numKinds--;
            for (int i = 0; i < m; i++) {
                arr[index++] = curNum;
            }
        }
        // 此时arr已经填好了
        // 打乱数组顺序
        for (int i = 0; i < arr.length; i++) {
            int j = (int) (Math.random() * arr.length); // 0 ~ N-1
            int tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
        }
        return arr;
    }

    // 获取随机数 [-range, range]
    public static int randomNumber(int range) {
        return (int) ((Math.random() * range) + 1) - (int) ((Math.random() * range) + 1);
    }

    public static void testOnlyKTimes() {
        int kinds = 4; // 数的种类数
        int range = 200; // 每个随机数的取值范围，正负200
        int testTime = 10000; // 测试次数
        int max = 9; // 最大的出现次数
        System.out.println("测试开始！");
        for(int i = 0; i < testTime; i++) {
            int a = (int) (Math.random() * max) + 1; // 1 - 9 随机
            int b = (int) (Math.random() * max) + 1; // 1 - 9 随机
            int k = Math.min(a, b);
            int m = Math.max(a, b);
            if (k == m) {
                m++;
            }
            // 上面保证了m > k
            int[] arr = randomArray(kinds, range, k, m);
            int ans1 = test(arr, k, m);
            int ans2 = onlyKTimes(arr, k, m);
            if (ans1 != ans2) {
                System.out.println("出错了！");
            }
        }
        System.out.println("测试结束！");
    }
}
