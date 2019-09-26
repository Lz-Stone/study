package pattern.staticProxy.GProxy;


public class Person implements PersonIF {

    public String name;
    public String age;

    @Override
    public void xuexi() {
        System.out.println("正在学习");
    }

    @Override
    public void yule() {
    }

    public void gongzuo(){
        System.out.println("我正在工作。。。。");
    }
}
