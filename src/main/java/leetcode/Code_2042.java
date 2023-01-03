package leetcode;

/**
 * 2042.检查句子中的数字是否递增
 * https://leetcode.cn/problems/check-if-numbers-are-ascending-in-a-sentence/
 */
public class Code_2042 {
    public static boolean areNumbersAscending(String s) {
        int max = 0;
        String[] tokens = s.split(" ");
        for (String token : tokens) {
            if (token.matches("[0-9]+")) {
                int tokenNum = Integer.parseInt(token);
                if (tokenNum <= max) {
                    return false;
                } else {
                    max = tokenNum;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "4 51 11 26";
        boolean ans = areNumbersAscending(s);
        System.out.println("s=" + s + ", ans=" + ans);

        String s2 = "sunset is at 7 51 pm overnight lows will be in the low 50 and 60 s";
        boolean ans2 = areNumbersAscending(s2);
        System.out.println("s2=" + s2 + ", ans2=" + ans2);

        String s3 = "1 box has 3 blue 4 red 6 green and 12 yellow marbles";
        boolean ans3 = areNumbersAscending(s3);
        System.out.println("s3=" + s3 + ", ans3=" + ans3);
    }
}
