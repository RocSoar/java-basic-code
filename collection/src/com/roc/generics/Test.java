package com.roc.generics;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        Persian persian = new Persian("abc", 1);
        LiHua liHua = new LiHua("qwe", 2);
        Husky husky = new Husky("bbb", 3);
        Teddy teddy = new Teddy("ccc", 4);

        List<Animal> list = new ArrayList<>();
        list.add(persian);
        list.add(liHua);
        list.add(husky);
        list.add(teddy);

        keepPet(list);
    }

    public static void keepPet(List<? super Teddy> list) {
        list.forEach(e -> ((Animal) e).display());
    }
}
