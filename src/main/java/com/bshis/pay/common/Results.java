package com.bshis.pay.common;

import com.google.gson.Gson;
import lombok.Data;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author: ddliu6
 * @Description:
 * @Date: Created in 22:39 2018/9/27
 * @Modified By:
 */
@Data
public class Results<T> {

    private String msg;  //消息

    private T data; //数据

    private boolean flag; //标识成功与失败 true or false



    public Results(String msg, T data, boolean flag) {
        this.msg = msg;
        this.data = data;
        this.flag = flag;
    }

    public Results(String msg, boolean flag) {
        this.flag = flag;
        this.msg = msg;
    }

    public static Results ResultFlag(boolean flag) {
       return new Results("",flag);
    }

    public static Results ResultFlag(boolean flag,String msg) {
        return new Results(msg,flag);
    }

    public static void Results2Json(HttpServletResponse response,Results<?> results){
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
        try {
            response.getWriter().write(new Gson().toJson(results));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    public interface ResultFlag{
        boolean SUCCESS = true;
        boolean FAIL = false;
    }


    public interface tradingPlatform{
        int TENPAY = 0; //微信支付
        int ALIPAY = 1;//支付宝支付
    }


}
