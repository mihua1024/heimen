package heimen.ltd.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Wxuser_info {
    /**
     * 微信用户编号
     */
    private String wxuser_id;
    //微信用户名
    private String wxuser_nickName;
    //微信所在省份
    private String wxuser_province;
    //微信所在城市
    private String wxuser_city;
    //微信绑定的手机号
    private String wxuser_phone;
    //用户微信头像
    private String wxuser_avatarUrl;
    //用户状态
    private Integer wxuser_state;
    //信息修改时间
    private Date wxuser_uptime;

    public Wxuser_info(String wxuser_id, String wxuser_nickName, String wxuser_province, String wxuser_city, String wxuser_phone, String wxuser_avatarUrl) {
        this.wxuser_id = wxuser_id;
        this.wxuser_nickName = wxuser_nickName;
        this.wxuser_province = wxuser_province;
        this.wxuser_city = wxuser_city;
        this.wxuser_phone = wxuser_phone;
        this.wxuser_avatarUrl = wxuser_avatarUrl;
    }

    public Wxuser_info() {
    }
}
