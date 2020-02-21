package app.proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ImpatientProxy implements InvocationHandler {

  private Object obj;

  private ImpatientProxy(Object obj) {
    this.obj = obj;
  }

  public static Object newInstance(Object obj) {
    ClassLoader loader = obj.getClass().getClassLoader();
    Class[] classes = obj.getClass().getInterfaces();
    return Proxy.newProxyInstance(loader, classes, new ImpatientProxy(obj));
  }

  public Object invoke(Object proxy, Method m, Object[] args) throws Throwable {
    Object result;
    long t1 = System.currentTimeMillis();
    result = m.invoke(obj, args);
    long t2 = System.currentTimeMillis();
    if(t2 - t1 > 10) {
      System.out.println("> It takes " + (t2 - t1) + " millis to invoke " + m.getName()
        + "() with");
      for(int i = 0; i < args.length; i++) {
        System.out.println(">     arg[" + i + "]: " + args[i]);
      }
    }
    return result;
  }
}
