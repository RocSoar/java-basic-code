package com.roc.myapi;

public class RegexDemo {
    public static void main(String[] args) {
//        System.out.println("abc".matches("[^A-Z][a-zA-Z][a-z]"));
//        System.out.println("a".matches("[a-dm-p]"));
//        System.out.println("d".matches("[a-z&&[def]]"));
//        System.out.println("哈".matches("."));
//        System.out.println("a".matches("\\w*"));

//        System.out.println("1234567890123456789a".matches("[1-9][0-9]{5,19}"));

//        手机号正则
//        System.out.println("18366655695".matches("1[3-9]\\d{9}"));
//      座机号正则
//        System.out.println("020-2324242".matches("0[1-9]\\d{1,2}-?[1-9]\\d{4,9}"));
        System.out.println("400-618-9090".matches("(\\d{3}-?){2}\\d{4}"));
        System.out.println("400-618-9090".matches("400-?[1-9]\\d{2}-?[1-9]\\d{3}"));
//        邮箱正则
//        System.out.println("lsyyd@outlook.com.cn"
//                .matches("\\w+@[\\w&&[^_]]+(\\.[a-zA-Z]{2,3}){1,2}"));

//        24小时制正则
//        System.out.println("00:00:00".matches("(([01]\\d)|(2[0-3]))(:[0-5]\\d){2}"));

//        System.out.println("rocsoar".matches("\\w{4,16}"));
//        System.out.println("12345678901234567X".matches("[1-9]\\d{16}[xX\\d]"));
//        System.out.println("12345678901234567X".matches("[1-9]\\d{16}(\\d|x|X)"));
//        System.out.println("12345678901234567X".matches("[1-9]\\d{16}(\\d|(?i)x)"));
//
////        身份证号正则
//        String regex = "[1-9]\\d{5}(18|19|20)\\d{2}(0[1-9]|1[012])(0[1-9]|[12]\\d|3[01])\\d{3}[\\dxX]";
//        System.out.println("12345619921231567X"
//                .matches(regex));
//
//        System.out.println("abC".matches("(?i)abc"));  //忽略abc的大小写
//        System.out.println("Abc".matches("((?i)a)bc"));  //忽略a的大小写
    }
}
