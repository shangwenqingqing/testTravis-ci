package cn.payingcloud.clientdemo.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/")
public class NotifyController {
    @RequestMapping("notifyResult")
    @ResponseBody
    public String notifyResultPay(@RequestBody String reqBody) {
        System.out.println("请求结果通知"+reqBody);
        return "success";
    }
}
