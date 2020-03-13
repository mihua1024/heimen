package heimen.ltd.service.login;

import java.util.Map;

public interface LoginService {
    /**
     * 用户登录获取，用户微信信息
     * @param reqbody
     * @return
     */
    Object login_info(Map<String, String> reqbody);

    /**
     * 解密用户手机号
     * @param reqbody
     * @return
     */
    Object decode_AEC(Map reqbody);

}
