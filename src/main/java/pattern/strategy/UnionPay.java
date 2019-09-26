package pattern.strategy;

public class UnionPay implements Payment{

    @Override
    public PaySt pay(String uid, double amount) {
        System.out.println("欢迎使用银联卡支付");
        return new PaySt(200,"支付成功",amount);
    }
}
