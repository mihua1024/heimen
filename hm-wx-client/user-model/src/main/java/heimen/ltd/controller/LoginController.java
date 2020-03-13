package heimen.ltd.controller;

import heimen.ltd.service.login.LoginService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;

@RestController
public class LoginController {

    @Resource
    private LoginService loginService;

    //微信端登录
    @PostMapping(value = "/login.html")
    public Object login_info(@RequestBody Map<String, String> reqbody) {
     return loginService.login_info(reqbody);
    }

    //手机号解密
    @PostMapping(value = "/decode.html")
    public Object decode_AEC(@RequestBody Map reqbody) {
        return loginService.decode_AEC(reqbody);
    }

}
