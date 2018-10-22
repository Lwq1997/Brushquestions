package main.com.lwq.offer66;

/**
 * @Author: Lwq
 * @Date: 2018/10/19 21:04
 * @Version 1.0
 * @Describe
 */

import java.util.Stack;

/**
 * 给定一棵二叉搜索树，请找出其中的第k小的结点。例如
 * （5，3，7，2，4，6，8）中，
 * 按结点数值大小顺序第三小结点的值为4。
 */
public class Solution62 {
    int index = 0;// 计数器
    TreeNode KthNode(TreeNode pRoot, int k) {
        if(pRoot!=null){
            TreeNode node = KthNode(pRoot.left,k);
            if(node!=null){
                return node;
            }
            index++;
            if(index==k){
                return pRoot;
            }
            node = KthNode(pRoot.right,k);
            if(node!=null){
                return node;
            }
        }
        return null;
    }
    TreeNode KthNode02(TreeNode pRoot, int k) {
        if(index>k||pRoot==null){
            return null;
        }
        TreeNode p = pRoot;
        Stack<TreeNode> LDRStack = new Stack<>();
        TreeNode kthNode = null;
        while (p!=null||LDRStack.isEmpty()){
            while (p!=null){
                LDRStack.push(p);
                p = p.left;
            }
            TreeNode node = LDRStack.pop();
            System.out.println(node.val+",");
            index++;
            if(index==k){
                kthNode = node;
            }
            p = node.right;
        }
        return kthNode;
    }

}
