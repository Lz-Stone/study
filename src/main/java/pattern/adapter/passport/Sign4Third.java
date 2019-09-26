package pattern.adapter.passport;
import pattern.adapter.ResultMsg;

public class Sign4Third extends SignService {
    public ResultMsg loginForQQ(String id){

        return loginForRegist(id,null);
    }

    public ResultMsg loginForWechat(String id){
        return null;
    }
    public ResultMsg loginForToken(String token){
        //通过token拿到用户信息，再重新登陆一次
        return null;
    }
    public ResultMsg loginForRegist(String userName,String password){
        super.regist(userName,null);
        return super.login(userName,null);
    }
}
