import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class ProxyTime implements InvocationHandler {

    private IWatch watch;

    public ProxyTime(IWatch watch) {
        this.watch = watch;
    }

    @Override
    public Object invoke(Object o, Method method, Object[] objects) throws Throwable {

        try {
            if (method.getParameterCount() != 0 && method.getName().startsWith("set")  /*.matches("^set[a-zA-Z]+$")*/)
                throw new Exception( method.getName() + " is a setter! We disrespect it!");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return method.invoke(watch, objects);
    }
}