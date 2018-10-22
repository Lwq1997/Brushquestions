package main.com.lwq.offer66;

/**
 * @Author: Lwq
 * @Date: 2018/10/19 20:55
 * @Version 1.0
 * @Describe
 */
/*
请实现两个函数，分别用来序列化和反序列化二叉树
 */
public class Solution61 {
    public int index = -1;
    String Serialize(TreeNode root) {
        StringBuilder sb  =  new StringBuilder();
        if(root==null){
            sb.append("#,");
            return sb.toString();
        }
        sb.append(root.val+",");
        sb.append(Serialize(root.left));
        sb.append(Serialize(root.right));
        return sb.toString();
    }
    TreeNode Deserialize(String str) {
        index++;
        String[] strings = str.split(",");
        TreeNode node = null;
        if(!strings[index].equals("#")){
            node = new TreeNode(Integer.valueOf(strings[index]));
            node.left = Deserialize(str);
            node.right = Deserialize(str);
        }
        return node;
    }
}
