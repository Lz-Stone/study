package pattern.delegate.leader;

public class TargetA implements Target{
    @Override
    public void doing( String commond ) {
        System.out.println("我是员工A，我开始做comondA");
    }
}
