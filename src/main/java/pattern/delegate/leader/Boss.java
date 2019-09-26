package pattern.delegate.leader;

public class Boss {

    //委派模式就是静态代理和策略模式的一种特殊组合，在spring中广泛应用
    //客户请求（Boss），委派者（Leader），被委派者（Target）
    //委派者要持有被委派者的引用
    //代理模式注重的是过程，委派模式注重的是结果
    //策略模式注重的是外部的可扩展，委派模式注重的是内部的灵活和复用
    public static void main(String[] args) {
        new Leader().doing("登陆");
    }
}
