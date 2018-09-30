package com.bshis.pay.Interceptor;

import com.bshis.pay.common.Results;
import com.bshis.pay.utils.MD5;
import com.bshis.pay.utils.collection.MapBuilder;
import com.bshis.pay.utils.collection.Maps;
import com.github.binarywang.wxpay.config.WxPayConfig;
import com.github.binarywang.wxpay.service.WxPayService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.*;

/**
 * @Author: ddliu6
 * @Description:判断接口签名
 * @Date: Created in 23:00 2018/9/27
 * @Modified By:
 */
public class ApiInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String params = request.getQueryString();
        if(StringUtils.isBlank(params)){
            Results.Results2Json(response,Results.ResultFlag(Results.ResultFlag.FAIL,"非法请求"));
            return false;
        }
        //验证签名
        if(!handler(toMap(params),request.getParameter("sign"))){
            Results.Results2Json(response,Results.ResultFlag(Results.ResultFlag.FAIL,"非法请求"));
            return false;
        }
        Results.Results2Json(response,new Results("访问成功",toMap(params),Results.ResultFlag.SUCCESS));
//        return super.preHandle(request, response, handler);
        return false;
    }


    private Map toMap(String params){
        //截取参数
        String[] strings = params.split("&");
        //处理map
        MapBuilder builder = Maps.builder();
        Arrays.stream(strings).forEach(str->{
            String[] param = str.split("=");
            try {
                builder.put(param[0],URLDecoder.decode(param[1],"UTF-8"));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        });
        //排序
       Map<String,String> paramsMap = sortMapByKey(builder.build());
       //去除sign
       if(paramsMap.containsKey("sign"))paramsMap.remove("sign");
       return paramsMap;
    }


    private boolean handler(Map map,String sign){
        if(StringUtils.isBlank(sign)){
            return false;
        }
        Iterator<Map.Entry> it = map.entrySet().iterator();
        StringBuffer buffer = new StringBuffer();
        while (it.hasNext()){
            Map.Entry entry = it.next();
            buffer.append(entry.getKey()).append("=").append(entry.getValue()).append("&");
        }
        //加密后对比
        return StringUtils.equals(MD5.getMD5Str(buffer.toString()
                .substring(0,buffer.length()-2)),sign);
    }


    /**
     * 使用 Map按key进行排序
     * @param map
     * @return
     */
    private static Map<String, String> sortMapByKey(Map<String, String> map) {
        if (map == null || map.isEmpty()) {
            return null;
        }
        Map<String, String> sortMap = new TreeMap<String, String>(
                new MapKeyComparator());
        sortMap.putAll(map);
        return sortMap;
    }


}

class MapKeyComparator implements Comparator<String> {

    @Override
    public int compare(String str1, String str2) {

        return str1.compareTo(str2);
    }
}
