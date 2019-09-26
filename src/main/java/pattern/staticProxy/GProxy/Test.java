package pattern.staticProxy.GProxy;

public class Test {
    public static void main(String[] args) {
        try {
            Person object = (Person)new Mei().getInstance(new Person());
//            object.gongzuo();
            System.out.println(object.getClass());
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
