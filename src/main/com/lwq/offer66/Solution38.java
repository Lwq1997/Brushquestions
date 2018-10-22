package main.com.lwq.offer66;

/**
 * @Author: Lwq
 * @Date: 2018/10/17 15:15
 * @Version 1.0
 * @Describe
 */

import java.util.LinkedList;
import java.util.Queue;

/**
 * 输入一棵二叉树，求该树的深度。从根结点到叶结点依次经过的结点
 * （含根、叶结点）形成树的一条路径，最长路径的长度为树的深度
 */
public class Solution38 {
    /**
     * 递归
     * @param root
     * @return
     */
    public int TreeDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        return Math.max(TreeDepth(root.left)+1,TreeDepth(root.right)+1);
    }

    /**
     * 非递归
     * @param root
     * @return
     */
    public int TreeDepth02(TreeNode root) {
        if(root==null){
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int depth = 0;
        int count = 0;
        int nextCOunt = 1;
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            count++;
            if(node.left!=null){
                queue.add(node.left);
            }
            if(node.right!=null){
                queue.add(node.right);
            }
            if(count==nextCOunt){
                nextCOunt = queue.size();
                count = 0;
                depth++;
            }
        }
        return depth;
    }
}
