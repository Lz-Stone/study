package pattern.strategy;

public class JDPay implements Payment{

    @Override
    public PaySt pay(String uid, double amount) {
        System.out.println("欢迎使用京东白条");
        return new PaySt(200,"支付成功",amount);
    }
}
