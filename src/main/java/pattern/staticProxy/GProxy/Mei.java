package pattern.staticProxy.GProxy;


import java.lang.reflect.Method;

public class Mei implements GPInvocationHandler {
    private Person target;
    public Object getInstance(Person target) throws Exception{
        this.target= target;
        Class<?> clazz = target.getClass();
        return GProxy.newProxyInsatance(new GPClassLoader(),clazz.getInterfaces(),this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("代理之前的工作开始");
        method.invoke(this,target,args);
        System.out.println("工作结束，准备回家");
        return null;
    }
}
