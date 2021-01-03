//给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。 
//
// 
//
// 示例： 
//
// 输入："Let's take LeetCode contest"
//输出："s'teL ekat edoCteeL tsetnoc"
// 
//
// 
//
// 提示： 
//
// 
// 在字符串中，每个单词由单个空格分隔，并且字符串中不会有任何额外的空格。 
// 
// Related Topics 字符串 
// 👍 262 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String reverseWords(String s) {
        char[] ss = s.toCharArray();
        int start = 0;
        int end = 0;
        char temp = ' ';
        int n = ss.length;
        while (start < n) {
            while (end < n-1 && (ss[end + 1] != ' ')) {
                end++;
            }
            for (int i = 0; i < (end-start+1)/2; i++) {
                temp = ss[start+i];
                ss[start+i] = ss[end-i];
                ss[end-i] = temp;
            }
            start = end + 2;
            end += 2;
        }
        return new String(ss);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
