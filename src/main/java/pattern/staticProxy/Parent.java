package pattern.staticProxy;

public class Parent {
    //拿到目标对象引用
    private Son son;
    public Parent(Son son){
        this.son = son;
    }

    public void findLove(){
        System.out.println();
    }
}
