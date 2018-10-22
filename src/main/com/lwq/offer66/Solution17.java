package main.com.lwq.offer66;

/**
 * @Author: Lwq
 * @Date: 2018/10/11 22:09
 * @Version 1.0
 * @Describe
 */
/*
输入两棵二叉树A，B，判断B是不是A的子结构。
（ps：我们约定空树不是任意一个树的子结构）
 */
public class Solution17 {
    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        boolean res = false;
        if(root1!=null&&root2!=null){
            if(root1.val==root2.val){
                res = doesTree1HaveTree2(root1,root2);
            }
            if(!res){
                res = HasSubtree(root1.left,root2);
            }
            if(!res){
                res = HasSubtree(root1.right,root2);
            }
        }
        return res;
    }

    private boolean doesTree1HaveTree2(TreeNode root1, TreeNode root2) {
        if(root2==null){
            return true;
        }
        if(root1==null){
            return false;
        }
        if(root1.val!=root2.val){
            return false;
        }
        return doesTree1HaveTree2(root1.left,root2.left)&&doesTree1HaveTree2(root1.right,root2.right);
    }
}
