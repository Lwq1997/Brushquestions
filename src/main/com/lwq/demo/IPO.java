package main.com.lwq.demo;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Author: Lwq
 * @Date: 2018/9/21 12:26
 * @Version 1.0
 * @Describe
 */
/*
类似于资源分配问题，两个数组，一个数需要的资源，一个是收益的资源，执行K个项目，最后的收益是多少
 */
public class IPO {
    public static class Node {
        public int p;
        public int c;

        public Node(int p, int c) {
            this.p = p;
            this.c = c;
        }
    }
    public static class MinCostComparator implements Comparator<Node>{

        @Override
        public int compare(Node o1, Node o2) {
            return o1.c-o2.c;
        }
    }

    public static class MaxProfitComparator implements Comparator<Node>{

        @Override
        public int compare(Node o1, Node o2) {
            return o2.p-o1.p;
        }
    }

    public static int findMaximizedCapital(int k,int W,int[] Profits,int[] Capital){
        Node[] nodes = new Node[Profits.length];
        for(int i = 0; i < nodes.length ; i++){
            nodes[i] = new Node(Profits[i],Capital[i]);
        }
        PriorityQueue<Node> minCost = new PriorityQueue<>(new MinCostComparator());
        PriorityQueue<Node> maxProfit = new PriorityQueue<>(new MaxProfitComparator());
        for(int i = 0; i < nodes.length ; i++){
            minCost.add(nodes[i]);
        }
        for(int i = 0; i < k;i++){
            while (!minCost.isEmpty()&&minCost.peek().c<=W){
                maxProfit.add(minCost.poll());
            }
            if(maxProfit.isEmpty()){
                return W;
            }
            W += maxProfit.poll().p;
        }
        return W;
    }
}
