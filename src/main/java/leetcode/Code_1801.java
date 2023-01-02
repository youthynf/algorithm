package leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 1801. 积压订单中的订单总数
 * https://leetcode.cn/problems/number-of-orders-in-the-backlog/
 */
public class Code_1801 {

    /**
     * 错误分析：没有按照题意，采购单需要找最低价格的销售单，销售单需要找最高价格的采购单
     */
    public static int getNumberOfBacklogOrders(int[][] orders) {
        int length = orders.length;
        for(int i = 0; i < length; i++) {
            for(int j = 0; j < length; j++) {
                int[] orderI = orders[i];
                int[] orderJ = orders[j];
                // 结束循环条件
                if (i == j || orderI[2] == orderJ[2] || orderI[1] == 0 || orderJ[1] == 0) {
                    continue;
                }
                // 如果是销售订单
                if (orderI[2] == 1) {
                    // 找到能抵消的采购订单（采购单价比当前销售单价高的）
                    if (orderJ[0] >= orderI[0]) {
                        if (orderJ[1] > orderI[1]) {
                            orders[j][1] -= orderI[1];
                            orders[i][1] = 0;
                        } else {
                            orders[i][1] -= orderJ[1];
                            orders[j][1] = 0;
                        }
                    }
                } else {
                    // 如果是采购订单，找到能抵消的销售订单（采购单价比当前销售单价高的）
                    if (orderJ[0] <= orderI[0]) {
                        if (orderJ[1] > orderI[1]) {
                            orders[j][1] -= orderI[1];
                            orders[i][1] = 0;
                        } else {
                            orders[i][1] -= orderJ[1];
                            orders[j][1] = 0;
                        }
                    }
                }
            }
        }
        int ans = 0;
        for (int[] order : orders) {
            ans += order[1];
        }
        return ans % (1000000000 + 7);
    }

    public static int getNumberOfBacklogOrders2(int[][] orders) {
        PriorityQueue<int[]> buy = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        PriorityQueue<int[]> sale = new PriorityQueue<>((a,b) -> a[0] - b[0]);
        for (int i = 0; i < orders.length; i++) {
            if (orders[i][2] == 1) sale.add(orders[i]);
            else {
                buy.add(orders[i]);
            }
            while (!buy.isEmpty() && !sale.isEmpty() && buy.peek()[0] >= sale.peek()[0]) {
                int min = Math.min(buy.peek()[1], sale.peek()[1]);
                buy.peek()[1] = buy.peek()[1] - min;
                sale.peek()[1] = sale.peek()[1] - min;
                if (buy.peek()[1] == 0) buy.poll();
                if (sale.peek()[1] == 0) sale.poll();
            }
        }
        long res = 0;
        int mod = 1000000007;
        while (!buy.isEmpty()) {
            res += buy.poll()[1];
            res %= mod;
        }
        while (!sale.isEmpty()) {
            res += sale.poll()[1];
            res %= mod;
        }
        return (int)res;
    }

    public static void main(String[] args) {
//        int[][] orders = {{10,5,0}, {15,2,1},{25,1,1},{30,4,0}};
//        int ans = getNumberOfBacklogOrders(orders);
//        System.out.println(Arrays.deepToString(orders));
//        System.out.println("ans=" + ans);
//
//        int[][] orders2 = {{7,1000000000,1},{15,3,0},{5,999999995,0},{5,1,1}};
//        int ans2 = getNumberOfBacklogOrders(orders2);
//        System.out.println(Arrays.deepToString(orders2));
//        System.out.println("ans2=" + ans2);

        int[][] orders4 = {{30,27,1},{18,9,1},{11,4,0},{21,11,0},{1,1,1},{24,20,1},{15,13,1},{13,3,0},{30,11,1}};
        System.out.println("before=" + Arrays.deepToString(orders4));
        int ans4 = getNumberOfBacklogOrders(orders4);
        System.out.println("after=" + Arrays.deepToString(orders4));
        System.out.println("ans4=" + ans4);

        int[][] orders3 = {{30,27,1},{18,9,1},{11,4,0},{21,11,0},{1,1,1},{24,20,1},{15,13,1},{13,3,0},{30,11,1}};
        System.out.println("before=" + Arrays.deepToString(orders3));
        int ans3 = getNumberOfBacklogOrders2(orders3);
        System.out.println("after=" + Arrays.deepToString(orders3));
        System.out.println("ans3=" + ans3);

        // [[30, 27, 1], [18, 9, 1], [11, 4, 0], [21, 11, 0], [1, 1, 1], [24, 20, 1], [15, 13, 1], [13, 3, 0], [30, 11, 1]]
        // [[30, 27, 1], [18, 9, 1], [11, 4, 0], [21, 11, 0], [1, 1, 1], [24, 20, 1], [15, 13, 1], [13, 3, 0], [30, 11, 1]]

    }
}
