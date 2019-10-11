package pattern.ASM;

import java.lang.instrument.Instrumentation;

/**
 * @author Stone
 * @date 2019/9/27 11:08
 */
public class TestAgent {
    public static void agentmain(String args, Instrumentation inst) {
        //指定我们自己定义的Transformer，在其中利用Javassist做字节码替换
        inst.addTransformer(new TestTransformer(), true);
        try {
            //重定义类并载入新的字节码
            inst.retransformClasses(Base.class);
            System.out.println("Agent Load Done.");
        } catch (Exception e) {
            System.out.println("agent load failed!");
        }
    }

    public static void main(String[] args) {
       int[] a = {2,7,11,15};
    }

    public int[] twoSum(int[] nums, int target) {
        int a =nums.length;
        int[] result=new int[2];
        for(int i =0; i<a;i++){
            int c = target-nums[i];
            int b =i;
            while (b <a){
                if(nums[b] == c){
                    result[0] =i;
                    result[1] =b;
                }
                b++;
            }
        }
        return result;
    }

}
