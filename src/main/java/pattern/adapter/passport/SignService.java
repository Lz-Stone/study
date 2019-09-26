package pattern.adapter.passport;
import pattern.adapter.Member;
import pattern.adapter.ResultMsg;

public class SignService {
    public ResultMsg regist(String userName, String password){
        return new ResultMsg(200,"注册成功",new Member());
    }

    public ResultMsg login(String userName,String password){
        return null;
    }
}
