package com.heu.poet.tszz.loginlogs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

/**
 * @author MengQi
 * @create 2018-02-24 09:53
 */
@Service
public class LoginLogsService {

    private final LoginLogsRepository loginLogsRepository;
    @Autowired
    public LoginLogsService(LoginLogsRepository loginLogsRepository) {
        this.loginLogsRepository = loginLogsRepository;
    }


    public LoginLogs add(LoginLogs loginLogs, HttpServletRequest request){
        loginLogs.setIp(request.getRemoteAddr());
        loginLogs.setNickName(loginLogs.getUserInfo().getNickName());
        return loginLogsRepository.insert(loginLogs);
    }
}
