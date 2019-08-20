package com.fenglei.java.lib.method;

public class MethodDispatcher {

    public static abstract class Human {
        public abstract void sayHello();
    }

    public static class Boy extends Human {
        @Override
        public void sayHello() {
            System.out.println(" I am Boy inner, Hello");
        }
    }

    public static class Girl extends Human {
        @Override
        public void sayHello() {
            System.out.println(" I am Girl inner, Hello");
        }
    }

    public static void sayHello(Human human) {
        System.out.println(" I am human, Hello");
    }

    public static void sayHello(Boy boy) {
        System.out.println(" I am a boy, Hello");
    }

    public static void sayHello(Girl human) {
        System.out.println(" I am a girl, Hello");
    }

    public static void main(String[] args) {
        Boy b = new Boy();
        Girl girl = new Girl();

        sayHello(b);
        sayHello(girl);

        b.sayHello();
        girl.sayHello();

        /*Test out
         *
         *I am a boy, Hello
         *I am a girl, Hello
         *I am Boy inner, Hello
         *I am Girl inner, Hello
         * */
    }
}
