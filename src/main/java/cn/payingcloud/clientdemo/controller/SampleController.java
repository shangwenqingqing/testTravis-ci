package cn.payingcloud.clientdemo.controller;

import cn.payingcloud.umf.PlaceOrderResponse;
import cn.payingcloud.umf.model.Payment;
import cn.payingcloud.umf.util.JsonUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import static cn.payingcloud.clientdemo.controller.Constant.*;


@Controller
@RequestMapping("/pay")
public class SampleController {
    @RequestMapping("/placeOrder")
    public String  placeOrder(@RequestBody String reqBody){
        Payment payment = JsonUtils.fromJson(reqBody,Payment.class);
        PlaceOrderResponse response=UMF_CLIENT.placeOrder(payment);
        if(response.successful())
            return response.getPaymentId();
        else
            return response.getRetMsg();
    }
    @RequestMapping("/confirm")
    public String confirmPay(@RequestBody String reqBody){
        Payment payment = JsonUtils.fromJson(reqBody,Payment.class);
        PlaceOrderResponse response=UMF_CLIENT.placeOrder(payment);
        if(response.successful())
            return "success";
        else
            return response.getRetMsg();
    }
}
