package com.mysite.sbb.global;

import com.mysite.sbb.global.annotation.Util;

@Util
public class UpdateUtil {

    public static <T> T getUpdatedValue(T currentValue, T oldValue){
        if(currentValue != null){
            return currentValue;
        }
        return oldValue;
    }

}
