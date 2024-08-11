package com.roc;

@MyAnnotation(aaa = 1, ccc = {"roc", "soar"})
public class Demo {

    @MyAnnotation(aaa = 2, ccc = {"susan"})
    @MyAnnotation2("hello")
    public void test() {
    }
}
