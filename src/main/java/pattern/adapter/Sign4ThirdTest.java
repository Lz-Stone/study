package pattern.adapter;
import pattern.adapter.passport.Sign4Third;

public class Sign4ThirdTest {
    public static void main(String[] args) {
        Sign4Third service = new Sign4Third();
        //不改变原来的代码，也能兼容新的需求
        service.loginForQQ("asdjsgdjakgs");
    }
}
