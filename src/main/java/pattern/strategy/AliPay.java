package pattern.strategy;

public class AliPay implements Payment{

    @Override
    public PaySt pay(String uid, double amount) {
        System.out.println("欢迎使用支付宝");
        return new PaySt(200,"支付成功",amount);
    }
}
