package pattern.staticProxy.GProxy;

import javax.tools.JavaCompiler;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.FileWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class GProxy {
    public static final String ln ="\r\n";


    public static Object newProxyInsatance(GPClassLoader classLoader,Class<?>[] inerfaces,GPInvocationHandler h){
        try {
            //1.动态生成源代码 java文件
            String s =generateSrc(inerfaces);
            //2.java 文件输出磁盘
            String filePateh = GProxy.class.getResource("").getPath();
            File file=new File(filePateh + "$Proxy0.java");
            FileWriter fw= new FileWriter(file);
            fw.write(s);
            fw.flush();
            fw.close();
            //3.转成class文件
            JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
            StandardJavaFileManager manager =compiler.getStandardFileManager(null,null,null);
            Iterable iterable = manager.getJavaFileObjects(file);
            JavaCompiler.CompilationTask task =  compiler.getTask(null,null,null,null,null,iterable);
            task.call();
            manager.close();
            //4.加载进JVM中
           Class<?> proxyClass = classLoader.findClass("$Proxy0");
           Constructor constructor= proxyClass.getConstructor(GPInvocationHandler.class);

            //5.返回代理对象
            return constructor.newInstance();
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    private  static String generateSrc(Class<?>[] interfaces){
        StringBuffer sb = new StringBuffer();
        sb.append("package com.roncoo.education.staticProxy.GProxy;"+ln);
        sb.append("import com.roncoo.education.staticProxy.GProxy.Person;" +ln);
        sb.append("import java.lang.reflect.Method;"+ln);
        sb.append("public class $Proxy0 implements "+ interfaces[0].getName()+"{"+ln);
        sb.append("private GPInvocationHandler h;"+ln);
        sb.append("public $Proxy0(GPInvocationHandler h) {" + ln);
        sb.append("this.h = h;");
        sb.append("}"+ln);
        for(Method m: interfaces[0].getMethods()){
            sb.append("public "+m.getReturnType().getName() +" " +m.getName() +" () {"+ln);
                sb.append("try{"+ln);
                    sb.append("Method m = "+interfaces[0].getName() +".class.getMethod(\""+m.getName()+"\",new Class[]{});"+ln);
                    sb.append(" this.h.invoke(this,m,null);"+ ln);
                sb.append("}catch(Throwable e){"+ln);
                sb.append("e.printStackTrace();" +ln);
                sb.append("}");
            sb.append("}");

        }
        sb.append("}"+ln);
        return sb.toString();
    }
}
