package pattern.delegate;
import pattern.delegate.controller.MemberAction;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class ServletDispacher {

    private List<Handler> handlerMapping = new ArrayList<Handler>();

    public ServletDispacher(List<Handler> handlerMapping) {
        try {
            Class<?> memberActionClass = MemberAction.class;
            handlerMapping.add(new Handler().setController(memberActionClass.newInstance())
                    .setMethod(memberActionClass.getMethod("getMemberById",new Class[]{String.class}))
                    .setUrl("/web/getMethod/json"));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void doService(HttpServletRequest request, HttpServletResponse response){
        doDispatch(request,response);
    }
    public void doDispatch(HttpServletRequest request, HttpServletResponse response){
        //1获取请求url
        //按照j2ee标准，每个url对应一个servlet url由浏览器输入
        String uri =request.getRequestURI();
        //2servlet拿到uri后，要做权衡
        //根据用户请求，去找到对应的java类

        //3通过拿到的url去handlerMapping中（我们认为是策略常量）
        Handler handler = null;
        for (Handler h: handlerMapping){
            if(uri.equals(h.getUrl())){
                handler = h;
                break;
            }
        }
        //4将具体的任务分发给method，通过反射去获取相应的方法
        Object object = null;
        try {
            object= handler.getMethod().invoke(handler.getController(),request.getParameter("mid"));
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        //5获取method的执行结果，通过response返回
//        response.getWriter().write();

    }


    class Handler{
        private Object controller;
        private Method method;
        private String url;

        public Object getController() {
            return controller;
        }

        public Handler setController(Object controller) {
            this.controller = controller;
            return this;
        }

        public Method getMethod() {
            return method;
        }

        public Handler setMethod(Method method) {
            this.method = method;
            return this;
        }

        public String getUrl() {
            return url;
        }

        public Handler setUrl(String url) {
            this.url = url;
            return this;
        }
    }
}
