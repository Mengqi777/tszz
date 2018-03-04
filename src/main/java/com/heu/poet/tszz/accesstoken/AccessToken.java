package com.heu.poet.tszz.accesstoken;

import org.springframework.data.annotation.Id;

/**
 * @author MengQi
 * @create 2018-02-18 18:59
 */
public class AccessToken {

    @Id
    private String id;

    private String access_token;

    private long timestamp;

    private int expires_in;

    public AccessToken() {
        super();
    }

    public AccessToken(String id, String access_token, long timestamp, int expires_in) {
        this.id = id;
        this.access_token = access_token;
        this.timestamp = timestamp;
        this.expires_in = expires_in;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public int getExpires_in() {
        return expires_in;
    }

    public void setExpires_in(int expires_in) {
        this.expires_in = expires_in;
    }
}
