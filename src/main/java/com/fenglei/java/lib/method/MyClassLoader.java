package com.fenglei.java.lib.method;

public class MyClassLoader extends ClassLoader {
    public static class Test {
        public String id;
        public Test() {
            id = "test";
        }
    }


    public static void main(String[] args) {
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();

        try {
            Class klass = classLoader.loadClass(Test.class.getName());
            Test test = (Test) klass.newInstance();
            System.out.println(test.id + " " + test.getClass().getName());
            System.out.println(test.id + " getClassLoader  " + test.getClass().getClassLoader());
            System.out.println(test.id + " getClassLoader().getParent "
                    + test.getClass().getClassLoader().getParent());
            System.out.println(test.id + " test.getClass().getClassLoader().getParent().getParent() "
                    + test.getClass().getClassLoader().getParent().getParent());


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }


    }
}
