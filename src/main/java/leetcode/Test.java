package leetcode;

public class Test {
    public static void main(String[] args) {
        // 1 1 1 1 1    1
        // 1 2 1 1      4
        // 1 1 2 1
        // 1 1 1 2
        // 2 1 1 1
        // 1 2 2
        // 2 2 1
        // 2 1 2

        int res = climbStairs(5);
        System.out.println(res);
    }

    private static int climbStairs(int n) {
        //当阶梯数为1或者2时，一共可能的跳法数量就为1或者2
        if (n==1 || n==2){
            return n;
        }else{    //此时阶梯数n >= 3，跳法就为阶梯数为n-1的跳法加上阶梯数为n-2时的跳法
            return climbStairs(n-1) + climbStairs(n-2);
        }
    }
}
