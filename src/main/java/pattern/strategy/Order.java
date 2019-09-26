package pattern.strategy;

public class Order {
    private  String orderId;
    private  String uid;
    private  double amount;

    public Order(String orderId, String uid, double amount) {
        this.orderId = orderId;
        this.uid = uid;
        this.amount = amount;
    }

    //这里使用策略模式，完美的解决了switch的过程，更不需要写if...elseif...else
    public PaySt pay(PayType payType){
        return payType.get().pay(this.uid,this.amount);
    }
}
