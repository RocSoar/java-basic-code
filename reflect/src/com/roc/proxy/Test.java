package com.roc.proxy;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class Test {
    public static void main(String[] args) {
        ProxyFactory pf = ProxyFactory.getInstance();

        Function<Integer, List<Integer>> func = n -> {
            List<Integer> list = new ArrayList<>();
            for (int i = 1; i < n; i++) {
                boolean isPrime = true;
                for (int j = 2; j < i; j++) {
                    if (i % j == 0) {
                        isPrime = false;
                        break;
                    }
                }
                if (isPrime)
                    list.add(i);
            }
            return list;
        };

        Function<Integer, List<Integer>> proxy = pf.createProxy(func, HandlerType.TIMING, HandlerType.LOGGING);
        List<Integer> res = proxy.apply(1000);
        System.out.println(res);

//        MyService<String> myService = new MyServiceImpl();
//        MyService<String> proxy = pf.createProxy(myService, HandlerType.LOGGING, HandlerType.TIMING);
//        String s = proxy.doSomething("测试");
//        proxy.doSomethingElse();
//        System.out.println(s);
    }
}
