package main.com.lwq.offer66;

/**
 * @Author: Lwq
 * @Date: 2018/10/17 15:31
 * @Version 1.0
 * @Describe
 */

/**
 * 输入一棵二叉树，判断该二叉树是否是平衡二叉树。
 */
public class Solution39 {
    public boolean IsBalanced_Solution(TreeNode root) {
        return getDepth(root)!=-1;
    }

    private int getDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        int left = getDepth(root.left);
        if(left==-1){
            return -1;
        }
        int right = getDepth(root.right);
        if(right==-1){
            return -1;
        }
        return Math.abs(left-right)>1?-1:1+Math.max(left,right);
    }
    public boolean IsBalanced_Solution02(TreeNode root) {
        if(root==null){
            return true;
        }
        return Math.abs(maxDepth(root.left)-maxDepth(root.right))<=1&&IsBalanced_Solution02(root.left)&&IsBalanced_Solution02(root.right);
    }

    private int maxDepth(TreeNode node) {
        if(node==null){
            return 0;
        }
        return Math.max(maxDepth(node.left),maxDepth(node.right))+1;
    }

}
