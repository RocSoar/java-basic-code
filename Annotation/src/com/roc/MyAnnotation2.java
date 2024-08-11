package com.roc;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotation2 {
    //value属性, 是特殊属性
//    若有且仅有一个value属性, 在使用时可以不用写名字, 直接传值
//    当有其他属性, 若其他属性全部有默认值, 在使用时可以不用写value名字, 直接传值
//    否则, 需要写value的名字
    String value();
}
