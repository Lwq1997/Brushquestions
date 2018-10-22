package main.com.lwq.offer66;

/**
 * @Author: Lwq
 * @Date: 2018/10/18 20:03
 * @Version 1.0
 * @Describe
 */

/**
 * 给定一个数组A[0,1,...,n-1],
 * 请构建一个数组B[0,1,...,n-1],其中B中的元素
 * B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。
 * 不能使用除法。
 */
public class Solution51 {
    public static void main(String[] args) {
        multiply(new int[]{1,2,3,4});
    }

    /**
     * B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]
     * 从左到右算 B[i]=A[0]*A[1]*...*A[i-1]
     * 从右到左算B[i]*=A[i+1]*...*A[n-1]
     * @param A
     * @return
     */
     public static int[] multiply(int[] A) {
        int len = A.length;
        int[] B = new int[len];
        if(len!=0){
            int re = 1;
            for(int i = 0; i < len;re *= A[i++]){
                B[i] = re;
            }
            re = 1;
            for(int i = len-1 ; i >= 0; re*=A[i--]){
                B[i] *= re;
            }
        }
        return B;
    }
}
