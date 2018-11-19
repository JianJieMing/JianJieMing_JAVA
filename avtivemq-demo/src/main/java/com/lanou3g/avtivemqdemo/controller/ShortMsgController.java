package com.lanou3g.avtivemqdemo.controller;

import com.lanou3g.avtivemqdemo.service.ShortMessagService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author 铭
 * 2018/11/19 10:43
 */
@RestController
public class ShortMsgController {

    @Resource
    private ShortMessagService shortMessagService;

    @RequestMapping("/send")
    public String send() {
        shortMessagService.sendVerifyCode();
        return "发送成功";
    }


}
