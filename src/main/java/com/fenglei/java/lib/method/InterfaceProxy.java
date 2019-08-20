package com.fenglei.java.lib.method;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

public class InterfaceProxy {


    @Target(METHOD)
    @Retention(RUNTIME)
    public @interface GET {
        String value() default "";
    }

    public interface Test {
        public void sayHello(String str);

        @GET("add")
        public int add(int i, int j);

        @GET("sub")
        public int sub(int i, int j);
    }


    public static void main(String[] args) {

        Test test = (Test) Proxy.newProxyInstance(Test.class.getClassLoader(),
                new Class<?>[]{Test.class}, new InvocationHandler() {
                    @Override
                    public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
                        if (method.getAnnotation(GET.class) != null) {
                            String v = method.getAnnotation(GET.class).value();
                            System.out.println(v  + " " + objects[0] + " " + objects[1]);
                            if (v.equals("add")) {
                                return (Integer)objects[0] + (Integer) objects[1];
                            } else if (v.equals("sub")) {
                                return (Integer)objects[0] - (Integer) objects[1];

                            }
                        }
                        return null;
                    }
                });

        test.sayHello("aaa");

        int sum = test.add(12, 14);
        System.out.println(sum);

        sum = test.sub(12, 14);
        System.out.println(sum);

    }

}
