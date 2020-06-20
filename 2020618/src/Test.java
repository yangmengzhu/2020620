/**
 * @program: 2020618
 * @description
 * @author: mrs.yang
 * @create: 2020 -06 -18 19 :31
 */

public class Test {
    public synchronized void func(){

    }
   public static synchronized void func1(){

   }
   public void func2(){
        Object o=new Object();
        synchronized (o){

        }
        synchronized(this){

        }
        synchronized(Test.class){//括号内是对象的引用，不能为Null

        }
   }
    public static void main1(String[] args) {
     Integer i01=59;
     int i02=59;
     Integer i03=Integer.valueOf(59);
     Integer i04=new Integer(59);
        System.out.println(i01==i02);//true
        System.out.println(i01==i03);//true
        System.out.println(i02==i04);//true
      System.out.println(i03==i04);//false
    }

    public static void main(String[] args) {
        long rich=30*10;
        long strange=(1<<30)-1;
        System.out.println(rich+" "+strange);
    }


}
