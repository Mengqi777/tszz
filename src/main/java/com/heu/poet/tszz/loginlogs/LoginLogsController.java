package com.heu.poet.tszz.loginlogs;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author MengQi
 * @create 2018-02-24 09:53
 */
@RestController
@RequestMapping("loginlogs")
@SuppressWarnings(value = "unused")
public class LoginLogsController {
    private final LoginLogsRepository loginLogsRepository;

    private final LoginLogsService service;

    public LoginLogsController(LoginLogsRepository loginLogsRepository, LoginLogsService service) {
        this.loginLogsRepository = loginLogsRepository;
        this.service = service;
    }



    @RequestMapping(value = "add", method = RequestMethod.POST)
    public LoginLogs add(@RequestBody LoginLogs loginLogs, HttpServletRequest request) {
        return service.add(loginLogs,request);
    }

}
