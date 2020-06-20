/*
 * @program: 2020618
 * @description
 * 懒汉模式
 * @author: mrs.yang
 * @create: 2020 -06 -20 14 :30
 */

import java.util.Scanner;

public class Demo1 {
    private static volatile Demo1 instance=null;//加volatile保证对象不会被重排序
    public static  Demo1 getInstance(){//保证了线程安全
            if(instance==null){//没有被初始化
                synchronized(Demo1.class){
                    //走到这一步，instatce有可能是空，有可能不是空
                    if(instance==null){
                        //但是可能会被重排序
                        //这里因为有锁的存在只会执行一次，保证了单例
                        instance=new Demo1();
                        return instance;
                    }
                }
            }
        return instance;
    }

    public static void main1(String[] args) {
        //什么时候用到什么时候实例化
        Demo1 demo1=Demo1.getInstance();
    }

    public static void main2(String[] args) throws InterruptedException {
        Object p=new Object();
        Object q=new Object();
        synchronized(q){
            q.wait();
        }
    }
    public static final Object o=new Object();
    static class  SubThread extends Thread{
        @Override
        public void run() {
             try{
                 System.out.println("等待之前");
                 synchronized(o){
                     o.wait();
                 }
                 System.out.println("等待之后");
             }catch(InterruptedException e){
                 e.printStackTrace();
             }
        }
    }

    public static void main(String[] args) {
        SubThread thread=new SubThread();
        thread.start();
        Scanner scan=new Scanner(System.in);
        scan.nextLine();
        synchronized(o){
            o.notifyAll();
        }
    }
}
