package com.heu.poet.tszz.accesstoken;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.bson.Document;
import org.joda.time.DateTime;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author MengQi
 * @create 2018-02-18 19:02
 */
@Service
public class AccessTokenService {
    private final AccessTokenRepository accessTokenRepository;

    public AccessTokenService(AccessTokenRepository accessTokenRepository) {
        this.accessTokenRepository = accessTokenRepository;
    }

    public Map<String, String> getUsefulAccessToken() {
        DateTime dateTime = new DateTime();
        long timestamp = dateTime.getMillis() / 1000;
        AccessToken accessToken = accessTokenRepository.findAccessTokenByTimestampGreaterThan(timestamp - 7100);
        Map<String, String> map = new HashMap<>();
        if (accessToken == null) {

            final String appid = "wx0616b5c2924f4ec9";
            final String secret = "5716e782c828003e6d54bb93843eb82e";
            final String url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=" + appid + "&secret=" + secret;
            boolean flag = true;

            while (flag) {
                try (CloseableHttpClient httpclient = HttpClients.createDefault()) {
                    HttpGet httpGet = new HttpGet(url);
                    // Create a custom response handler
                    ResponseHandler<String> responseHandler = response -> {
                        int status = response.getStatusLine().getStatusCode();
                        if (status >= 200 && status < 300) {
                            HttpEntity entity = response.getEntity();
                            return entity != null ? EntityUtils.toString(entity) : null;
                        } else {

                            map.put("msg", "error");
                            throw new ClientProtocolException("Unexpected response status: " + status);
                        }
                    };

                    String responseBody = httpclient.execute(httpGet, responseHandler);
                    System.out.println(responseBody);
                    Document document = Document.parse(responseBody);

                    if (document.getString("access_token") != null) {
                        flag = false;
                        accessToken = new AccessToken();
                        accessToken.setAccess_token(document.getString("access_token"));
                        accessToken.setTimestamp(timestamp);
                        accessToken.setExpires_in(7200);
                        accessTokenRepository.insert(accessToken);
                        map.put("msg", "ok");
                        map.put("access_token", document.getString("access_token"));
                    } else {
                        map.put("msg", "error");
                    }
                    httpclient.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }


        } else {
            map.put("msg", "ok");
            map.put("access_token", accessToken.getAccess_token());
        }

        return map;
    }

}
