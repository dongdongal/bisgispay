package com.bshis.pay.service;

import com.bshis.pay.entity.BishisApp;
import com.baomidou.mybatisplus.extension.service.IService;
import com.github.binarywang.wxpay.config.WxPayConfig;

/**
 * <p>
 * 应用表，存储微信支付宝相关信息 服务类
 * </p>
 *
 * @author 东小哥
 * @since 2018-09-28
 */
public interface IBishisAppService extends IService<BishisApp> {

    /**
     * @Description:根据appid获取当前医院信息
     * @auther: ddliu6
     * @date: 18:13 2018/9/28
     * @param: [appid]
     * @return: com.bshis.pay.entity.BishisApp
     */
    BishisApp getAppByHappId(String appid);

    /**
     * @Description:获取当前用户微信config信息
     * @auther: ddliu6
     * @date: 18:28 2018/9/28
     * @param: [appid]
     * @return: com.github.binarywang.wxpay.config.WxPayConfig
     */
    WxPayConfig getWxPayConfig(String appid);

}
