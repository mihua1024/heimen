package heimen.ltd.service.login.Impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import heimen.ltd.entity.AES;
import heimen.ltd.entity.UrlUtils;
import heimen.ltd.entity.Wxuser_info;
import heimen.ltd.service.login.LoginService;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class LoginServiceImpl implements LoginService {


    @Override
    public Object login_info(Map<String, String> reqbody) {
        //微信端登录code
        String wxCode = reqbody.get("code");
        String requestUrl = "https://api.weixin.qq.com/sns/jscode2session";

        Map<String, String> requestUrlParam = new HashMap<String, String>();
        requestUrlParam.put("appid", "wxe28c8e3b7cecd7a0");//小程序appId
        requestUrlParam.put("secret", "a975678b58eb44e885a657f50248cfb6");
        requestUrlParam.put("js_code", wxCode);//小程序端返回的code
        requestUrlParam.put("grant_type", "authorization_code");//默认参数

        //发送post请求读取调用微信接口获取openid用户唯一标识
        String wxReturnValue = UrlUtils.sendPost(requestUrl, requestUrlParam);
        System.err.println("响应结果" + wxReturnValue);

        //用到了Gson的JsonParser取出数据
        JsonParser jp = new JsonParser();
        //将json字符串转化成json对象
        JsonObject jo = jp.parse(wxReturnValue).getAsJsonObject();
        String openid = jo.get("openid").getAsString();
        String session_key = jo.get("session_key").getAsString();
//        String token= MD5Util.getMd5(openid+session_key);
//        redisService.setex(token,50000,openid);
        return session_key;
    }

    @Override
    public Object decode_AEC(Map reqbody) {
        System.out.println("map======="+reqbody);
        String session_key = reqbody.get("session_key").toString();
        String iv = reqbody.get("iv").toString();
        String encryptedData = reqbody.get("encryptedData").toString();
        Object userinfo = reqbody.get("userinfo");
        Map<String, String> map= (Map<String, String>) userinfo;
        String phone = AES.wxDecrypt(encryptedData, session_key, iv);
        Wxuser_info wx=new Wxuser_info("",map.get("nickName"),map.get("province"),map.get("city"),phone,map.get("avatarUrl"));
        return null;
    }
}
