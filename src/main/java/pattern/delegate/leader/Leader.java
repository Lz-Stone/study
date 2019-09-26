package pattern.delegate.leader;

import java.util.HashMap;
import java.util.Map;

public class Leader implements Target{
    private Map<String,Target> target = new HashMap<>();
    public Leader(){
        target.put("加密",new TargetA());
        target.put("登陆",new TargetB());

    }

    @Override
    public void doing(String commond) {
        target.get(commond).doing(commond);
    }
}
