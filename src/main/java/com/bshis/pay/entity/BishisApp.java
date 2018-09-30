package com.bshis.pay.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 应用表，存储微信支付宝相关信息
 * </p>
 *
 * @author 东小哥
 * @since 2018-09-28
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class BishisApp extends Model<BishisApp> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.UUID)
    private String id;

    /**
     * 用户ＩＤ
     */
    private String userId;

    /**
     * 0微信 1支付宝
     */
    private Integer type;

    /**
     * 微信或者支付宝appid
     */
    private String appid;

    /**
     * 微信或者支付宝密钥
     */
    private String secret;

    /**
     * 商户平台ID
     */
    private String mckId;

    /**
     * 商户平台密钥
     */
    private String mckSecret;

    /**
     * 创建时间

     */
    private LocalDateTime createTime;

    /**
     * 0 默认状态 1删除
     */
    private Integer status;

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
