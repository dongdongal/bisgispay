package com.bshis.pay.controller;


import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import com.bshis.pay.common.controller.BaseController;
import org.springframework.web.servlet.ModelAndView;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 东小哥
 * @since 2018-09-27
 */
@Controller
@RequestMapping("/bishis-user")
public class BishisUserController extends BaseController {

    @RequestMapping("/index")
    public ModelAndView index(){

        return new ModelAndView("index");
    }

}

