package com.heu.poet.tszz.customer;

import com.heu.poet.tszz.pet.Pet;
import com.heu.poet.tszz.treasure.Treasure;
import org.springframework.data.annotation.Id;

import java.util.ArrayList;
import java.util.List;

/**
 * 消费者
 *
 * @author MengQi
 * @create 2018-01-08 15:04
 */
@SuppressWarnings(value = "unused")
public class Customer {

    @Id
    private String id;

    private String openId;
    private String nickName;
    private UserInfo userInfo;
    private String role = "";
    private String status = "normal";
    private String registered = "n";
    private int statusCode = 0;
    private List<Pet> pets = new ArrayList<>();

    private List<Treasure> treasures = new ArrayList<>();


    public Customer() {
        super();
    }

    public Customer(String id, String openId, String nickName, UserInfo userInfo, String role, String status, String registered, int statusCode, List<Pet> pets, List<Treasure> treasures) {
        this.id = id;
        this.openId = openId;
        this.nickName = nickName;
        this.userInfo = userInfo;
        this.role = role;
        this.status = status;
        this.registered = registered;
        this.statusCode = statusCode;
        this.pets = pets;
        this.treasures = treasures;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRegistered() {
        return registered;
    }

    public void setRegistered(String registered) {
        this.registered = registered;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public List<Pet> getPets() {
        return pets;
    }

    public void setPets(List<Pet> pets) {
        this.pets = pets;
    }

    public List<Treasure> getTreasures() {
        return treasures;
    }

    public void setTreasures(List<Treasure> treasures) {
        this.treasures = treasures;
    }
}

