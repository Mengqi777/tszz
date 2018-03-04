package com.heu.poet.tszz.loginlogs;

import com.heu.poet.tszz.customer.UserInfo;
import org.springframework.data.annotation.Id;

/**
 * @author MengQi
 * @create 2018-02-24 09:49
 */
public class LoginLogs {
    @Id
    private String id;

    private String ip;

    private String dateTime;

    private String nickName;

    private String page;

    private UserInfo userInfo;

    public LoginLogs() {
        super();
    }

    public LoginLogs(String id, String ip, String dateTime, String nickName, String page, UserInfo userInfo) {
        this.id = id;
        this.ip = ip;
        this.dateTime = dateTime;
        this.nickName = nickName;
        this.page = page;
        this.userInfo = userInfo;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }
}
