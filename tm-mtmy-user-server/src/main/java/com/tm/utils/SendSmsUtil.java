package com.tm.utils;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.profile.DefaultProfile;
import com.google.gson.Gson;

/**
 * 发送短信
 */
public class SendSmsUtil {

    public static String loginSendSms(String phoneNumber) {

        DefaultProfile profile = DefaultProfile.getProfile("cn-hangzhou", "LTAI5tGAfCbyfRga7ui1U9Xi", "QQQAljx8pZJ42hinBAdK4EGWyBGsbR");
        /** use STS Token
         DefaultProfile profile = DefaultProfile.getProfile(
         "<your-region-id>",           // The region ID
         "<your-access-key-id>",       // The AccessKey ID of the RAM account
         "<your-access-key-secret>",   // The AccessKey Secret of the RAM account
         "<your-sts-token>");          // STS Token
         **/

        IAcsClient client = new DefaultAcsClient(profile);

        SendSmsRequest request = new SendSmsRequest();
        request.setSignName("河南天之马");
        request.setTemplateCode("SMS_243476098");
        request.setPhoneNumbers(phoneNumber);
        //生成一个随机验证码发送到手机
        String str = String.valueOf(Math.random()).substring(2, 8);
        request.setTemplateParam("{\"code\":\""+"快到期啦"+"\"}");

        try {
            SendSmsResponse response = client.getAcsResponse(request);
            System.out.println(new Gson().toJson(response));
        } catch (ServerException e) {
            e.printStackTrace();
        } catch (ClientException e) {
            System.out.println("ErrCode:" + e.getErrCode());
            System.out.println("ErrMsg:" + e.getErrMsg());
            System.out.println("RequestId:" + e.getRequestId());
        }
        return str;
    }
}
