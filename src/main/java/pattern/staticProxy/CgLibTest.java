package pattern.staticProxy;

public class CgLibTest {
    public static void main(String[] args) {
        try {
            Zhangsan object = (Zhangsan)new CgLibProxy().getInstance(Zhangsan.class);
            object.findLove();
            System.out.println(object.getClass());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
