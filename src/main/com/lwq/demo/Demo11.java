package main.com.lwq.demo;

/**
 * @Author: Lwq
 * @Date: 2018/9/10 23:22
 * @Version 1.0
 * @Describe
 */
/*
回文子串
 */
public class Demo11 {
    public static void main(String[] args) {
        System.out.println(longestPalindrome2("babcbabcbaccba"));
    }

/*
1.两侧比较法
以abba这样一个字符串为例来看，abba中，一共有偶数个字，第1位=倒数第1位，第2位=倒数第2位......第N位=倒数第N位
以aba这样一个字符串为例来看，aba中，一共有奇数个字符，排除掉正中间的那个字符后，第1位=倒数第1位......第N位=倒数第N位
所以，假设找到一个长度为len1的子串后，我们接下去测试它是否满足，第1位=倒数第1位，第2位=倒数第2位......第N位=倒数第N位，也就是说，去测试从头尾到中点，字符是否逐一对应相等。
*/
    private static String longestPalindromel(String s) {
        int maxPalinLength = 0;
        String longestPalindrome = null;
        int length = s.length();

        for(int i = 0; i < length;i++){
            for(int j = i;j < length;j++){
                int len = j-i;
                String cur = s.substring(i,j+1);
                if(isPalindrome(cur)){
                    if(len>maxPalinLength){
                        longestPalindrome = cur;
                        maxPalinLength = len;
                    }
                }
            }
        }
        return longestPalindrome;
    }

    private static boolean isPalindrome(String s) {
        for(int i = 0; i < s.length()/2 ; i++){
            if(s.charAt(i)!=s.charAt(s.length()-1-i)){
                return false;
            }
        }
        return true;
    }

/*
3.中心扩展法
因为回文字符串是以中心轴对称的，所以如果我们从下标 i 出发，用2个指针向 i 的两边扩展判断是否相等，那么只需要对0到
n-1的下标都做此操作，就可以求出最长的回文子串。但需要注意的是，回文字符串有奇偶对称之分，即"abcba"与"abba"2种类型，
因此需要在代码编写时都做判断。
     设函数int Palindromic ( string &s, int i ,int j) 是求由下标 i 和 j 向两边扩展的回文串的长度，那么对0至n-1的下标，调用2次此函数：
     int lenOdd =  Palindromic( str, i, i ) 和 int lenEven = Palindromic (str , i , j )，即可求得以i 下标为奇回文和偶回文的子串长度。
     接下来以lenOdd和lenEven中的最大值与当前最大值max比较即可。
     这个方法有一个好处是时间复杂度为O(n2)，且不需要使用额外的空间。*/
    private static String longestPalindrome2(String s) {
        if(s.isEmpty()){
            return null;
        }
        if(s.length()==1){
            return s;
        }
        String longest = s.substring(0,1);
        for(int i=0;i < s.length() ; i++){
            String tmp = help(s,i,i);
            if(tmp.length()>longest.length()){
                longest=tmp;
            }
            tmp = help(s,i,i+1);
            if(tmp.length()>longest.length()){
                longest=tmp;
            }
        }
        return longest;
    }

    private static String help(String s, int begin, int end) {
        while (begin>=0&&end<=s.length()-1&&s.charAt(begin)==s.charAt(end)){
            begin--;
            end++;
        }
        String subS = s.substring(begin+1,end);
        return subS;
    }


}
