package com.xinyan.sell.utils;

/**
 * Administrator
 * 2018/11/20 0020
 * 数字金额处理工具
 */
public class MathUtil {

    private static final Double MONEY_RANGE=0.01;

    /**
     * 比较两个金额是否相等
     * @param val1
     * @param val2
     * @return
     */
    public static Boolean compareTo(Double val1,Double val2){
        Double result = Math.abs(val1 - val2);
        if(result < MONEY_RANGE){
            return true;
        }else{
            return false;
        }
    }


}
