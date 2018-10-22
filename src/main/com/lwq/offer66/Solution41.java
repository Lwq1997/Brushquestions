package main.com.lwq.offer66;

import java.util.ArrayList;

/**
 * @Author: Lwq
 * @Date: 2018/10/17 21:29
 * @Version 1.0
 * @Describe
 */

/**
 * 输出所有和为S的连续正数序列。
 * 序列内按照从小至大的顺序，序列间按照开始数字从小到大的顺序
 */
public class Solution41 {
    /**
     * 等差数列的求和公式：S = (1 + n) * n / 2,求出n的范围
     *
     * n为奇数时，序列中间的数正好是序列的平均值，所以条件为：(n & 1) == 1 && sum % n == 0；
     * n为偶数时，序列中间两个数的平均值是序列的平均值，而这个平均值的小数部分为0.5，所以条件为：(sum % n) * 2 == n.
     * @param sum
     * @return
     */
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>>  ans = new ArrayList<>();
        for(int n = (int) Math.sqrt(2*sum);n>=2;n--){
            if((n&1)==1&&sum%n==0||(sum%n)*2==n){
                ArrayList<Integer> list = new ArrayList<>();
                for(int j = 0,k = (sum/n)-(n-1)/2;j<n;j++,k++){
                    list.add(k);
                }
                ans.add(list);
            }
        }
        return ans;
    }
}
