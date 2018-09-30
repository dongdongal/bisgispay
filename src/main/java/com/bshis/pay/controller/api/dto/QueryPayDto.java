package com.bshis.pay.controller.api.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Author: ddliu6
 * @Description:
 * @Date: Created in 18:01 2018/9/28
 * @Modified By:
 */
@Data
@EqualsAndHashCode
public class QueryPayDto {

    private String hAppid;//医院ID，系统生成唯一的UUID

    private String hospitalName;//医院名称

    private int tradingPlatform;//交易平台 0 微信 1 支付宝

    private String paymentType; //缴费类型 0 门诊缴费 1住院缴费

    private String hospitalOrderNo;//医院订单号

    private String totalFee;//订单总金额

    private String patientName;//患者姓名

    private String tollCollectorId;//收费员ID

    private String tollCollectorName;//收费员姓名

    private String dateOfCharge;//收费日期




}
