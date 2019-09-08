package test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ArithemeticCalculateProxy {

	ArithemeticCalculate target;
	
	public ArithemeticCalculateProxy(ArithemeticCalculate target) {
		this.target = target;
	}
	
	public ArithemeticCalculate getLoggingProxy() {
		ArithemeticCalculate proxy = null;
		ClassLoader loader = target.getClass().getClassLoader();
		Class[] interfaces = new Class[] {ArithemeticCalculate.class};
		InvocationHandler h = new InvocationHandler() {
			
			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				System.out.println("before");
				Object result = method.invoke(target, args);
				System.out.println("after");
				return result;
			}
		};
		proxy = (ArithemeticCalculate) Proxy.newProxyInstance(loader, interfaces, h);
		return proxy;
	}
}
