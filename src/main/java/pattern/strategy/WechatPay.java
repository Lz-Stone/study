package pattern.strategy;

public class WechatPay implements Payment{

    @Override
    public PaySt pay(String uid, double amount) {
        System.out.println("欢迎使用微信支付");
        System.out.println("直接从微信红包扣款");
        return new PaySt(200,"支付成功",amount);
    }
}
