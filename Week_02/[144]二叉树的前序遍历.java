//给你二叉树的根节点 root ，返回它节点值的 前序 遍历。 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [1,null,2,3]
//输出：[1,2,3]
// 
//
// 示例 2： 
//
// 
//输入：root = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：root = [1]
//输出：[1]
// 
//
// 示例 4： 
//
// 
//输入：root = [1,2]
//输出：[1,2]
// 
//
// 示例 5： 
//
// 
//输入：root = [1,null,2]
//输出：[1,2]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目在范围 [0, 100] 内 
// -100 <= Node.val <= 100 
// 
//
// 
//
// 进阶：递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树 
// 👍 452 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
//    public List<Integer> preorderTraversal(TreeNode root) {
////        List<Integer> res = new ArrayList<>();
////        pre_order(root, res);
////        return res;
////    }
////    private void pre_order(TreeNode root, List<Integer> res) {
////        if(root == null) return;
////        res.add(root.val);
////        pre_order(root.left, res);
////        pre_order(root.right, res);
////    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if(root == null) {
            return res;
        }
        Deque<TreeNode> stake = new LinkedList<TreeNode>();
        TreeNode curr = root;
        while (curr != null || !stake.isEmpty()) {
            if(curr != null) {
                res.add(curr.val);
                stake.push(curr);
                curr = curr.left;
            }else {
                curr = stake.pop();
                curr = curr.right;
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
