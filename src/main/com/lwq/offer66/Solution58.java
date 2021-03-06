package main.com.lwq.offer66;

/**
 * @Author: Lwq
 * @Date: 2018/10/19 15:25
 * @Version 1.0
 * @Describe
 */

/**
 * 请实现一个函数，用来判断一颗二叉树是不是对称的。
 * 注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
 */
public class Solution58 {
    boolean isSymmetrical(TreeNode pRoot) {
        if(pRoot==null){
            return true;
        }
        return comRoot(pRoot.left,pRoot.right);
    }
    /*思路：首先根节点以及其左右子树，
     * 左子树的左子树和右子树的右子树相同
     * 左子树的右子树和右子树的左子树相同即可，采用递归
     * 非递归也可，采用栈或队列存取各级子树根节点
     */
    private boolean comRoot(TreeNode left, TreeNode right) {
        if(left==null){
            return right==null;
        }
        if(right==null){
            return left==null;
        }
        if(left.val!=right.val){
            return false;
        }
        return comRoot(left.right,right.left)&&comRoot(left.left,right.right);
    }
}
