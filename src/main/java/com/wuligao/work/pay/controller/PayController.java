package com.wuligao.work.pay.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author wuligao
 * @date 2020/3/12 14:17
 */
@RequestMapping
@RestController
public class PayController {
    @GetMapping("/aliPay/notify")
    public void aliPayNotify(HttpServletRequest request){
        System.out.println("aliPay notify 专用地址");
    }

    @GetMapping("/aliPay/return")
    public void aliPayReturn(HttpServletRequest request){
        System.out.println("aliPay return 专用地址");
    }


}
