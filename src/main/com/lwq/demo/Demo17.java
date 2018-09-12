package main.com.lwq.demo;

/**
 * @Author: Lwq
 * @Date: 2018/9/12 10:06
 * @Version 1.0
 * @Describe
 */
public class Demo17 {

    //定义打印的方法
    public synchronized void print(String str){
        notify();
        System.out.println(str);
        try {
            wait();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    //定义打印奇数的线程类
    class A implements Runnable{
        @Override
        public void run() {
            // TODO Auto-generated method stub
            for(int i=1;i<100;i+=2){
                print("A"+i);
            }
        }
    }

    //定义打印偶数的线程类
    class B implements Runnable{
        @Override
        public void run() {
            // TODO Auto-generated method stub
            for(int i=2;i<=100;i+=2){
                print("B"+i);
            }
        }
    }

    public static void main(String[] args) {
        Demo17 p = new Demo17();
        A a = p.new A();
        B b = p.new B();
        new Thread(a).start();
        new Thread(b).start();
    }
}
