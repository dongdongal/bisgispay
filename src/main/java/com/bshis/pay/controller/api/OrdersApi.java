package com.bshis.pay.controller.api;

import com.bshis.pay.common.Results;
import com.bshis.pay.controller.api.dto.QueryPayDto;
import com.bshis.pay.service.IBishisAppService;
import com.github.binarywang.wxpay.service.WxPayService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: ddliu6
 * @Description:微信以及支付宝下单支付API
 * @Date: Created in 22:36 2018/9/27
 * @Modified By:
 */
@Log4j2
@RestController
@RequestMapping("/api")
public class OrdersApi extends BaseApi{

    @Autowired
    private IBishisAppService bishisAppService;

    @Autowired
    private WxPayService wxPayService;

    /**
     * @Description:支付
     * @auther: ddliu6
     * @date:  2018/9/27
     * @param: []
     * @return: com.bshis.pay.common.Results<?>
     */
    @RequestMapping("/pay")
    public Results<?> pay(QueryPayDto queryPay){
        try{
            if(queryPay.getTradingPlatform()
                    ==Results.tradingPlatform.TENPAY){ //微信支付
                //获取以及设置当前用户微信配置信息
                wxPayService.setConfig(bishisAppService.getWxPayConfig(queryPay.getHAppid()));

            }
        }catch (Exception e){
            log.error("下单支付：",e);
            return Results.ResultFlag(Results.ResultFlag.FAIL);
        }
        return Results.ResultFlag(Results.ResultFlag.SUCCESS);
    }

}
