package main.com.lwq.offer66;

/**
 * @Author: Lwq
 * @Date: 2018/10/16 16:36
 * @Version 1.0
 * @Describe
 */

/**
 * HZ偶尔会拿些专业问题来忽悠那些非计算机专业的同学。
 * 今天测试组开完会后,他又发话了:在古老的一维模式识别中,
 * 常常需要计算连续子向量的最大和,当向量全为正数的时候,
 * 问题很好解决。但是,如果向量中包含负数,是否应该包含某个负数,
 * 并期望旁边的正数会弥补它呢？例如:{6,-3,-2,7,-15,1,2,2},
 * 连续子向量的最大和为8(从第0个开始,到第3个为止)。给一个数组，
 * 返回它的最大连续子序列的和，你会不会被他忽悠住？(子向量的长度至少是1)
 */
public class Solution30 {
    public static void main(String[] args) {
        System.out.println(FindGreatestSumOfSubArray(new int[]{1,-2,3,10,-4,7,2,-5}));
        System.out.println(FindGreatestSumOfSubArray02(new int[]{1,-2,3,4,-3}));
    }

    /**
     * 普通办法
     * @param array
     * @return
     */
    public static int FindGreatestSumOfSubArray(int[] array) {
        if(array.length==0||array==null){
            return 0;
        }
        int curSum = 0;
        int greatestSum = Integer.MIN_VALUE;
        for(int i = 0; i < array.length ; i++){
            if(curSum<=0){
                curSum=array[i];
            }else {
                curSum+=array[i];
            }
            if(curSum>greatestSum){
                greatestSum = curSum;
            }
        }
        return greatestSum;
    }

    /**
     * 动态规划
     *
     * F（i）：以array[i]为末尾元素的子数组的和的最大值，子数组的元素的相对位置不变
     * F（i）=max（F（i-1）+array[i] ， array[i]）
     * res：所有子数组的和的最大值
     * res=max（res，F（i））
     *
     * @param array
     * @return  最大子序列的和
     */
    public static int FindGreatestSumOfSubArray02(int[] array) {
        int res = array[0];
        int max = array[0];
        for(int i = 1; i < array.length; i++){
            max = Math.max(max+array[i],array[i]);
            res = Math.max(max,res);
        }
        return res;
    }
}
