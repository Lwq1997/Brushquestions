package main.com.lwq.demo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: Lwq
 * @Date: 2018/9/24 12:04
 * @Version 1.0
 * @Describe
 */
/*
在一个数组中，第一个数删除，第二个数移动到末尾，第三个数删除，第四个数移动到末尾，最后把左右删除的数连接起来
 */
public class jiemiQQ {
    public static void main(String[] args) {
        int[] arr = {6,3,1,7,5,8,9,2,4};
        Queue queue = new LinkedList();
        ArrayList list  = new ArrayList();
        for(int i = 0; i < arr.length ; i++){
            queue.add(arr[i]);
        }
        while (!queue.isEmpty()){
            //将第一个元素出队，删除
            list.add(queue.poll());
            //将后面的元素入队
            if(!queue.isEmpty()){
                queue.add(queue.poll());
            }
        }
        for(int i =0; i <list.size();i++ ){
            System.out.print(list.get(i)+" ");
        }
    }

}
