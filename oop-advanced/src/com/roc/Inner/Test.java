package com.roc.Inner;

public class Test {
    public static void main(String[] args) {
        Outer.Inner oi = new Outer().new Inner();

        Outer outer = new Outer();
        Outer.Inner oi2 = outer.new Inner();
    }
}
