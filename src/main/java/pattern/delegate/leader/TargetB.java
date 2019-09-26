package pattern.delegate.leader;

public class TargetB implements Target {
    @Override
    public void doing(String commod) {
        System.out.println("我是员工B，我开始做comondB");
    }
}
