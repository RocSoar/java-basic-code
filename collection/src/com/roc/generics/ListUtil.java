package com.roc.generics;

import java.util.ArrayList;
import java.util.Arrays;

public class ListUtil {
    private ListUtil() {

    }

    public static <T> void addAll(ArrayList<T> list, T... elements) {
        list.addAll(Arrays.asList(elements));
    }
}
