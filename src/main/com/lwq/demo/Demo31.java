package main.com.lwq.demo;

/**
 * @Author: Lwq
 * @Date: 2018/9/14 14:17
 * @Version 1.0
 * @Describe
 */
/*
找出一个数组中两个相邻差值最大的数
 */
public class Demo31 {
    public static void main(String[] args) {
        int[] arr = new int[]{8,6,3,2,10,4,1,9};
        System.out.println(maxGap(arr));
    }

    private static int maxGap(int[] arr) {
        int len = arr.length;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < len ;i++){
            min = Math.min(arr[i],min);
            max = Math.max(arr[i],max);
        }
        if(min==max){
            return 0;
        }
        boolean[] hasNum = new boolean[len+1];
        int[] mins = new int[len+1];
        int[] maxs = new int[len+1];
        for(int i = 0; i <len;i++){
            int bid = backet(i,len,min,max);
            mins[bid] = hasNum[bid]?Math.min(mins[bid],arr[i]):arr[i];
            maxs[bid] = hasNum[bid]?Math.max(maxs[bid],arr[i]):arr[i];
            hasNum[bid] = true;
        }
        int res = 0;
        int last = maxs[0];
        for(int i=0;i<len;i++){
            if(hasNum[i]){
                res = Math.max(res,mins[i]-last);
                last = maxs[i];
            }
        }
        return res;
    }

    private static int backet(int i, int len, int min, int max) {
        return (max-i)*len/(max-min);
    }
}
