package com.bshis.pay.common;


import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.bshis.pay.common.controller.BaseController;


/**
 * @Description: 代码生成器
 * @auther: ddliu6
 * @date: 21:58 2018/9/26
 * @param: 
 * @return: 
 */
public class MpGenerator {

    private AutoGenerator generator = new AutoGenerator();

    {
        //加载配置
        generator.setDataSource(new DataSourceConfig()
                .setDriverName("com.mysql.jdbc.Driver")
                .setUsername("root")
                .setPassword("xiuxiu")
                .setUrl("jdbc:mysql://127.0.0.1:3306/bishis_pay?useUnicode=true&characterEncoding=utf-8")
                .setDbType(DbType.MYSQL));
        //全局配置
        generator.setGlobalConfig(new GlobalConfig()
                .setOutputDir(System.getProperty("user.dir")+"/src/main/java")
                .setAuthor("东小哥")
                .setActiveRecord(true)
                .setIdType(IdType.UUID));
        //包配置
        generator.setPackageInfo(new PackageConfig()
                .setParent("com.bshis.pay"));
        //自定义策略
        generator.setStrategy(new StrategyConfig()
                .setColumnNaming(NamingStrategy.underline_to_camel)
                .setTablePrefix("T_")
                .setEntityBuilderModel(true)
                .setInclude("t_bishis_app")
                .setControllerMappingHyphenStyle(true)
                .setSuperControllerClass(BaseController.class.getName())
                .setEntityLombokModel(true)
                 .setEntityColumnConstant(true)
                .setNaming(NamingStrategy.underline_to_camel));

        //自定义注入配置
        generator.setCfg(new InjectionConfig() {
            @Override
            public void initMap() {

            }
        });

    }

    public void init(){
        generator.execute();
    }

    public static void main(String[] args) {
        new MpGenerator().init();
    }

}
