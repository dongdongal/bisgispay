package com.bshis.pay.utils;

import org.apache.logging.log4j.util.Strings;

import java.util.UUID;

/**
 * @Author: ddliu6
 * @Description:
 * @Date: Created in 19:43 2018/9/27
 * @Modified By:
 */
public final class GUID {

    public static String generate() {

        return UUID.randomUUID().toString().replace("-", Strings.EMPTY).toUpperCase();
    }

}
