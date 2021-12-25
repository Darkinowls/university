package project;

import project.interfaces.IWatch;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyTime implements InvocationHandler {

    private IWatch watch;

    public ProxyTime(IWatch watch) {
        this.watch = watch;
    }

    public IWatch getProxy() {
        ClassLoader classLoader = watch.getClass().getClassLoader();
        Class[] classInterfaces = watch.getClass().getInterfaces();

        return (IWatch) Proxy.newProxyInstance(classLoader, classInterfaces, new ProxyTime(watch));
    }

    @Override
    public Object invoke(Object o, Method method, Object[] objects) throws Throwable {


        if (method.getParameterCount() != 0 && method.getName().startsWith("set")  /*.matches("^set[a-zA-Z]+$")*/)
            throw new Exception(method.getName() + " is a setter! We disrespect it!");


        return method.invoke(watch, objects);
    }
}