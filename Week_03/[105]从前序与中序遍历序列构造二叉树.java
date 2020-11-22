//根据一棵树的前序遍历与中序遍历构造二叉树。 
//
// 注意: 
//你可以假设树中没有重复的元素。 
//
// 例如，给出 
//
// 前序遍历 preorder = [3,9,20,15,7]
//中序遍历 inorder = [9,3,15,20,7] 
//
// 返回如下的二叉树： 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7 
// Related Topics 树 深度优先搜索 数组 
// 👍 765 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int pl = preorder.length;
        int il = inorder.length;

        Map<Integer, Integer> map = new HashMap<Integer, Integer>(il);
        for (int i = 0; i < il; i++) {
            map.put(inorder[i], i);
        }
        return buildTree(preorder, 0, pl - 1, map, 0, il - 1);
    }
    public TreeNode buildTree(int[] preorder,int pleft,int pright,Map<Integer, Integer> map,int ileft,int iright) {
        if (pleft > pright || ileft > iright) {
            return null;
        }
        int rootVal = preorder[pleft];
        TreeNode root = new TreeNode(rootVal);
        int index = map.get(rootVal);
        root.left = buildTree(preorder, pleft + 1, index + pleft - ileft, map, ileft, index - 1);
        root.right = buildTree(preorder, index + pleft + 1 - ileft, pright, map, index + 1, iright);
        return root;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
