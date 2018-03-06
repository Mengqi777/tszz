package com.heu.poet.tszz.customer;


import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author MengQi
 * @create 2018-01-08 15:58
 */
@Service
public class CustomerService {

    private Logger logger=Logger.getLogger(CustomerService.class.getName());

    private CustomerRepository customerRepository;

    private String rootPath = System.getProperty("user.dir");



    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }


    public Map<String, Object> login(String code, String userInfo, HttpServletRequest request) throws IOException {

        Customer customer;
        Map<String, Object> map = new HashMap<>();
        final String appid = "wx0616b5c2924f4ec9";
        final String secret = "5716e782c828003e6d54bb93843eb82e";
        String url = "https://api.weixin.qq.com/sns/jscode2session?appid=" + appid + "&secret=" + secret + "&js_code=" + code + "&grant_type=authorization_code";

        CloseableHttpClient httpclient = HttpClients.createDefault();
        try {
            HttpGet httpGet = new HttpGet(url);

            // Create a custom response handler
            ResponseHandler<String> responseHandler = response -> {
                int status = response.getStatusLine().getStatusCode();
                if (status >= 200 && status < 300) {
                    HttpEntity entity = response.getEntity();
                    return entity != null ? EntityUtils.toString(entity) : null;
                } else {
                    throw new ClientProtocolException("Unexpected response status: " + status);
                }
            };

            String responseBody = httpclient.execute(httpGet, responseHandler);
            System.out.println(responseBody);
            Document document = Document.parse(responseBody);
            Document userInfoDoc = Document.parse(userInfo);
            UserInfo user = new UserInfo();
            user.setAvatarUrl(userInfoDoc.getString("avatarUrl"));
            user.setCity(userInfoDoc.getString("city"));
            user.setCountry(userInfoDoc.getString("country"));
            user.setGender(userInfoDoc.getInteger("gender"));
            user.setLanguage(userInfoDoc.getString("language"));
            user.setNickName(userInfoDoc.getString("nickName"));
            user.setProvince(userInfoDoc.getString("province"));
            customer = customerRepository.findCustomerByOpenId((String) document.get("openid"));
            if (customer == null) {
                customer = new Customer();
                customer.setOpenId((String) document.get("openid"));
                customer.setUserInfo(user);
                customer.setNickName(userInfoDoc.getString("nickName"));
                customer = customerRepository.insert(customer);
            }

            request.getSession().setAttribute("_session_user", customer);
            String sessionId = request.getSession().getId();
            map.put("sessionId", sessionId);
            map.put("customer", customer);
        } finally {
            httpclient.close();
        }
        logger.log(Level.INFO,customer.getNickName());
        return map;
    }


    public Customer register(Customer customer, HttpServletRequest request) {
        Customer customerOld = customerRepository.findCustomerByOpenId(customer.getOpenId());
        if (customerOld == null)
            customer = customerRepository.insert(customer);
        else customer = customerOld;
        request.getSession().setAttribute("_session_user", customer);
        return customer;
    }


}
