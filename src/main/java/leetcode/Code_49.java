package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: Code_49
 * @Description:
 *
 * 49. 字母异位词分组
 * 给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
 * 字母异位词 是由重新排列源单词的所有字母得到的一个新单词。
 *
 * 示例：
 * 输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
 * 输出: [["bat"],["nat","tan"],["ate","eat","tea"]]
 *
 * @Author: youth
 * @Date: 2024/11/7 22:16
 * @Version: 1.0
 */
public class Code_49 {

    public static void main(String[] args) {
        String[] strs = new String[] {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> result = groupAnagrams(strs);
        System.out.println(result);

        String[] strs2 = new String[] {""};
        List<List<String>> result2 = groupAnagrams(strs2);
        System.out.println(result2);
    }

    /**
     * 合理使用排序算法
     * @param strs
     * @return
     */
    private static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> res = new HashMap<>();
        for (String str : strs) {
            char[] strArray = str.toCharArray();
            Arrays.sort(strArray);
            String str_sort = String.valueOf(strArray);
            if (res.containsKey(str_sort)) {
                res.get(str_sort).add(str);
            } else {
                ArrayList<String> strList = new ArrayList<>();
                strList.add(str);
                res.put(str_sort, strList);
            }
        }
        return new ArrayList<>(res.values());
    }

}
