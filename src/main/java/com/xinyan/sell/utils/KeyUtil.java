package com.xinyan.sell.utils;

import java.util.UUID;

/**
 * Administrator
 * 2018/11/16 0014
 * 生成主键key
 */
public class KeyUtil {

    /**
     * 生成唯一主键 :UUID
     * @return
     */
    public static synchronized String generateUniqueKey() {
        return UUID.randomUUID().toString().replace("-", "");
    }



}
