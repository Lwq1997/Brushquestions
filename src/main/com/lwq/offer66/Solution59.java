package main.com.lwq.offer66;

/**
 * @Author: Lwq
 * @Date: 2018/10/19 15:28
 * @Version 1.0
 * @Describe
 */

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

/**
 * 请实现一个函数按照之字形打印二叉树，
 * 即第一行按照从左到右的顺序打印，第二层按照从右至左的顺序打印，
 * 第三行按照从左到右的顺序打印，其他行以此类推。
 */
public class Solution59 {
    /**
     * 利用Java中的LinkedList的底层实现是双向链表的特点。
     *  1)可用做队列,实现树的层次遍历
     *  2)可双向遍历,奇数层时从前向后遍历，偶数层时从后向前遍历
     * @param pRoot
     * @return
     */
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if(pRoot==null){
            return res;
        }
        ArrayList<Integer> list = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.addLast(null);   //层分隔符
        queue.addLast(pRoot);
        boolean leftToRight = true;
        while (queue.size()!=1){
            TreeNode node = queue.removeFirst();
            if(node==null){   //到达分隔符
                Iterator<TreeNode> iterator = null;
                if(leftToRight){
                    iterator = queue.iterator();   //从前往后遍历
                 }else{
                    iterator =  queue.descendingIterator(     )                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           ;//从后往前遍历
                }
                leftToRight  = !leftToRight;
                while (iterator.hasNext()){
                    TreeNode temp = iterator.next()                      ;
                    list.add(temp.val);
                }
                res.add(new ArrayList<Integer>(list));
                list.clear();
                queue.addLast(null);
                continue;
            }
            if(node.left!=null){
                queue.addLast(node.left);
            }
            if (node.right != null) {
                queue.addLast(node.right);
            }
        }
        return res;
    }
    public static ArrayList<ArrayList<Integer>> Print02(TreeNode pRoot) {
        int layer = 1;
        //奇数层节点
        Stack<TreeNode> s1 = new Stack<>();
        s1.push(pRoot);
        //偶数层节点
        Stack<TreeNode> s2 = new Stack<>();
        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
        while (!s1.isEmpty()||!s2.isEmpty()){
            if(layer%2!=0){
                ArrayList<Integer> temp = new ArrayList<>();
                while (!s1.isEmpty()){
                    TreeNode node = s1.pop();
                    if(node!=null){
                        temp.add(node.val);
                        System.out.println(node.val+" ");
                        s2.push(node.left);
                        s2.push(node.right);
                    }
                }
                if(!temp.isEmpty()){
                    list.add(temp);
                    layer++;
                    System.out.println();
                }
            }else {
                ArrayList<Integer> temp = new ArrayList<Integer>();
                while (!s2.empty()) {
                    TreeNode node = s2.pop();
                    if(node != null) {
                        temp.add(node.val);
                        System.out.print(node.val + " ");
                        s1.push(node.right);
                        s1.push(node.left);
                    }
                }
                if (!temp.isEmpty()) {
                    list.add(temp);
                    layer++;
                    System.out.println();
                }
            }
        }
        return list;
    }
}
