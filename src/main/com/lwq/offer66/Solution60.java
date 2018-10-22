package main.com.lwq.offer66;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: Lwq
 * @Date: 2018/10/19 19:29
 * @Version 1.0
 * @Describe
 */

/**
 * 从上到下按层打印二叉树，同一层结点从左至右输出。
 * 每一层输出一行。
 */
public class Solution60 {
    public static void main(String[] args) {
        TreeNode node = new TreeNode(8);;
        node.left = new TreeNode(6);
        node.right = new TreeNode(10);
        ArrayList<ArrayList<Integer>> lists = Print(node);
    }

    static ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if(pRoot == null){
            return result;
        }
        Queue<TreeNode> layer = new LinkedList<TreeNode>();
        ArrayList<Integer> layerList = new ArrayList<Integer>();
        layer.add(pRoot);
        int start = 0, end = 1;
        while(!layer.isEmpty()){
            TreeNode cur = layer.remove();
            layerList.add(cur.val);
            start++;
            if(cur.left!=null){
                layer.add(cur.left);
            }
            if(cur.right!=null){
                layer.add(cur.right);
            }
            if(start == end){
                end = layer.size();
                start = 0;
                result.add(layerList);
                layerList = new ArrayList<Integer>();
            }
        }
        return result;
    }
}