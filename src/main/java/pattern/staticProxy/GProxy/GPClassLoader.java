package pattern.staticProxy.GProxy;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class GPClassLoader extends ClassLoader{
    private File clasaPathFile;
    public GPClassLoader(){
        String classPath = GPClassLoader.class.getResource("").getPath();
        this.clasaPathFile= new File(classPath);
    }

    @Override
    protected Class<?> findClass(String name) {
        String  l= GPClassLoader.class.getPackage().getName()+"."+name;
        String className = GPClassLoader.class.getResource("").getPath()+"."+name;

        if (className != null){
            File classFile = new File(className.replaceAll("\\.","/")+".class");
            if(classFile.exists()){
                FileInputStream in= null;
                ByteArrayOutputStream out= null;
                try{
                    in = new FileInputStream(classFile);
                    out = new ByteArrayOutputStream();
                    byte[] buff = new byte[1024];
                    int len;
                    while ((len = in.read(buff)) != -1){
                        out.write(buff,0,len);
                    }
                    return defineClass(className,out.toByteArray(),0,out.size());

                }catch (Exception e){
                    e.printStackTrace();
                }finally {
                    try {
                        if (null != in) {
                            in.close();
                        }
                        if (null != out) {
                            out.close();
                        }
                    }catch(IOException e){
                        e.printStackTrace();
                    }

                }

            }

        }
        return null;
    }
}
