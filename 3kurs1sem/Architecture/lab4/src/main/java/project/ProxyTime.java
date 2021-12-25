//package project;
//
//import project.models.Watch;
//
//import java.lang.reflect.InvocationHandler;
//import java.lang.reflect.Method;
//import java.lang.reflect.Proxy;
//
//public class ProxyTime implements InvocationHandler {
//
//    private Watch watch;
//
//    public ProxyTime(Watch watch) {
//        this.watch = watch;
//    }
//
//    public Watch getProxy() {
//        ClassLoader classLoader = watch.getClass().getClassLoader();
//        Class[] classInterfaces = watch.getClass().getInterfaces();
//
//        return (Watch) Proxy.newProxyInstance(classLoader, classInterfaces, new ProxyTime(watch));
//    }
//
//    @Override
//    public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
//
//
//        if (method.getParameterCount() != 0 && method.getName().startsWith("set"))
//            throw new Exception(method.getName() + " is a setter! We disrespect it!");
//
//
//        return method.invoke(watch, objects);
//    }
//}