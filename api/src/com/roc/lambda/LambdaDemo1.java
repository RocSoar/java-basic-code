package com.roc.lambda;

import java.util.Arrays;
import java.util.List;

public class LambdaDemo1 {
    public static void main(String[] args) {

//        method(System.out::println);

//        String[] strArr = {"abc", "a", "abcd", "ab"};

//        Arrays.sort(strArr, (o1, o2) -> o1.length() - o2.length());
//        System.out.println(Arrays.stream(strArr).toList());
//        System.out.println(Arrays.stream(strArr).sorted(((o1, o2) -> o1.length() - o2.length())).toList());
        Student s1 = new Student("roc", 18, 180);
        Student s2 = new Student("gpx", 19, 181);
        Student s3 = new Student("adaptive", 20, 182);
        Student s4 = new Student("david", 18, 183);
        Student s5 = new Student("admire", 20, 182);
        Student[] arr = {s1, s2, s3, s4, s5};

        List<Student> list = Arrays.stream(arr).sorted((o1, o2) -> o1.getAge() > o2.getAge() ? 1 :
                o1.getAge() < o2.getAge() ? -1 :
                        o1.getHeight() > o2.getHeight() ? 1 :
                                o1.getHeight() < o2.getHeight() ? -1 :
                                        o1.getName().compareTo(o2.getName())).toList();

        List<Student> list2 = Arrays.stream(arr).sorted((o1, o2) -> {
            int temp = o1.getAge() - o2.getAge();
            temp = temp == 0 ? o1.getHeight() - o2.getHeight() : temp;
            temp = temp == 0 ? o1.getName().compareTo(o2.getName()) : temp;
            return temp;
        }).toList();
        System.out.println(list);
        System.out.println(list2);
        System.out.println(list == list2);
        System.out.println(list.equals(list2));

        System.out.println("a".compareTo("z"));
    }

    public static void method(Swim s) {
        s.swimming(12);
    }
}

@FunctionalInterface
interface Swim {
    public abstract void swimming(int a);
}
