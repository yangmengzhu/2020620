import java.util.Scanner;
import java.util.concurrent.TimeUnit;

/**
 * @program: 2020618
 * @description
 * @author: mrs.yang
 * @create: 2020 -06 -18 16 :27
 */

public class TestDemo {
    /*public static void main1(String[] args) {
        Thread.State[] values = Thread.State.values();
        for ( Thread.State v:values) {
            System.out.println(v);
        }
    }*/
    static class subThread extends Thread{
        @Override
        public void run() {
            Scanner scan=new Scanner(System.in);
                scan.nextLine();
                System.out.println("子线程即将退出");
            /*try{
                TimeUnit.SECONDS.sleep(5);
            }catch(InterruptedException e){
                e.printStackTrace();
            }*/
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t=new subThread();
        System.out.println(t.getState());
        t.start();
        System.out.println(t.getState());
        while(t.isAlive()){
            System.out.println(t.getState());
            TimeUnit.SECONDS.sleep(1);
        }
        System.out.println(t.getState());
    }
}
