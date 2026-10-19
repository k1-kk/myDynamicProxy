package com.example.mydynamicproxy1;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyUtil {

    public static Star createProxy(BigStar bigStar) {

        Star star = (Star) Proxy.newProxyInstance(
                ProxyUtil.class.getClassLoader(),       // 类加载器
                new Class[]{Star.class},                // 接口的class字节码文件
                // 用来指定生成的代理对象要干什么事情
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

                        if ("sing".equals(method.getName())) {
                            System.out.println("准备话筒，收钱");
                        } else if ("dance".equals(method.getName())) {
                            System.out.println("准备场地，收钱");
                        }

                        return method.invoke(bigStar, args);
                    }
                }
        );
        return star;
    }
}
