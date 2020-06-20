/*
 * @program: 2020618
 * @description
 * 饿汉模式的单例
 * 天生是线程安全的
 * @author: mrs.yang
 * @create: 2020 -06 -20 14 :02
 */
//有时候通过final修饰类，避免有人定义该类的子类来构造对象
public final class Demo2 {
    //需要保存仅有的一个对象在静态属性中
    private static final Demo2 instance;
    static {
        //只发生一次
        instance=new Demo2();
    }
    //提供一个方法，返回这个对象
    //被调用好多次
    public static Demo2 getInstance(){
        return instance;
    }
    //将构造方法标记为私有的，减少误用可能
    private Demo2(){
    }

    public static void main(String[] args) {
        Demo2 demo2=Demo2.getInstance();
    }
}
