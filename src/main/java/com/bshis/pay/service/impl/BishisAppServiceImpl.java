package com.bshis.pay.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.bshis.pay.entity.BishisApp;
import com.bshis.pay.mapper.BishisAppMapper;
import com.bshis.pay.service.IBishisAppService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.binarywang.wxpay.config.WxPayConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 应用表，存储微信支付宝相关信息 服务实现类
 * </p>
 *
 * @author 东小哥
 * @since 2018-09-28
 */
@Service
public class BishisAppServiceImpl extends ServiceImpl<BishisAppMapper, BishisApp> implements IBishisAppService {

    private BishisAppMapper bishisAppMapper;

    public void setBishisAppMapper(BishisAppMapper bishisAppMapper) {
        this.bishisAppMapper = bishisAppMapper;
    }

    public BishisApp getAppByHappId(String appid){
          return new BishisApp().selectOne(new QueryWrapper<BishisApp>().eq("appid",appid));
    }

    public WxPayConfig getWxPayConfig(String appid){
        WxPayConfig config = new WxPayConfig();
        BishisApp app = getAppByHappId(appid);
        config.setAppId(app.getAppid());
        config.setMchId(app.getMckId());
        config.setMchKey(app.getMckSecret());
        return config;
    }
}
