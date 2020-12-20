//数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。 
//
// 
//
// 示例： 
//
// 输入：n = 3
//输出：[
//       "((()))",
//       "(()())",
//       "(())()",
//       "()(())",
//       "()()()"
//     ]
// 
// Related Topics 字符串 回溯算法 
// 👍 1428 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
//    public List<String> generateParenthesis(int n) {
//        List<String> res = new ArrayList<String>();
//        if (n <= 0) {
//            return res;
//        }
//        generator(res,"",n,n);
//        return res;
//    }
//    private void generator(List<String> res, String str, int left, int right) {
//        if (left == 0 && right == 0) {
//            res.add(str);
//            return;
//        }
//        if (left < right) {
//           if (left > 0) {
//               generator(res, str + "(", left - 1, right);
//           }
//            generator(res, str + ")", left, right - 1);
//        }
//        if (left == right) {
//            generator(res, str + "(", left - 1, right);
//        }
//    }
    public List<String> generateParenthesis(int n) {
        if (n == 0) {
            return new ArrayList<>();
        }
        List<String> res = new ArrayList<>();
        generate(res, "", 0, 0, n);
        return res;
    }

    private void generate(List<String> res, String s, int left, int right, int n) {
        if (left == n && right == n) {
            res.add(s);
            return;
        }
        if (left < n) {
            generate(res, s + "(", left+1, right, n);
        }
        if (right < left) {
            generate(res, s + ")", left, right+1, n);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
