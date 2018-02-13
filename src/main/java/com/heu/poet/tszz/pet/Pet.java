package com.heu.poet.tszz.pet;


import org.springframework.data.annotation.Id;


/**
 * @author MengQi
 * @create 2018-02-03 17:14
 */
public class Pet {

    @Id
    private String id;

    private String userId;
    private String name;
    private String travelingId = "";
    private int type = 0;

    private int statusCode = 0;

    public Pet() {
        super();
    }

    public Pet(String id, String userId, String name, String travelingId, int type, int statusCode) {
        this.id = id;
        this.userId = userId;
        this.name = name;
        this.travelingId = travelingId;
        this.type = type;
        this.statusCode = statusCode;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTravelingId() {
        return travelingId;
    }

    public void setTravelingId(String travelingId) {
        this.travelingId = travelingId;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }
}
