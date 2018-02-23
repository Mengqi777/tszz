package com.heu.poet.tszz.travel;

import com.heu.poet.tszz.treasure.Treasure;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;


/**
 * @author MengQi
 * @create 2018-02-03 17:36
 */
@Document
@SuppressWarnings(value = "unused")
public class Travel {
    @Id
    private String id;
    private String userId;
    private String petId;
    private String petName = "";
    private String startTime = "";
    private String endTime = "";
    private long endTimestamp = 0;
    private long startTimestamp = 0;
    private List<String> logs;
    private List<Treasure> treasures;
    private int fishNumber = 0;
    private int statusCode = 0;
    private int starNumber = 0;

    private int foodNumber = 0;


    public Travel() {
        super();
    }

    public Travel(String id, String userId, String petId, String petName, String startTime, String endTime, long endTimestamp, long startTimestamp, List<String> logs, List<Treasure> treasures, int fishNumber, int statusCode, int starNumber, int foodNumber) {
        this.id = id;
        this.userId = userId;
        this.petId = petId;
        this.petName = petName;
        this.startTime = startTime;
        this.endTime = endTime;
        this.endTimestamp = endTimestamp;
        this.startTimestamp = startTimestamp;
        this.logs = logs;
        this.treasures = treasures;
        this.fishNumber = fishNumber;
        this.statusCode = statusCode;
        this.starNumber = starNumber;
        this.foodNumber = foodNumber;
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

    public String getPetId() {
        return petId;
    }

    public void setPetId(String petId) {
        this.petId = petId;
    }

    public String getPetName() {
        return petName;
    }

    public void setPetName(String petName) {
        this.petName = petName;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public long getEndTimestamp() {
        return endTimestamp;
    }

    public void setEndTimestamp(long endTimestamp) {
        this.endTimestamp = endTimestamp;
    }

    public long getStartTimestamp() {
        return startTimestamp;
    }

    public void setStartTimestamp(long startTimestamp) {
        this.startTimestamp = startTimestamp;
    }

    public List<String> getLogs() {
        return logs;
    }

    public void setLogs(List<String> logs) {
        this.logs = logs;
    }

    public List<Treasure> getTreasures() {
        return treasures;
    }

    public void setTreasures(List<Treasure> treasures) {
        this.treasures = treasures;
    }

    public int getFishNumber() {
        return fishNumber;
    }

    public void setFishNumber(int fishNumber) {
        this.fishNumber = fishNumber;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public int getStarNumber() {
        return starNumber;
    }

    public void setStarNumber(int starNumber) {
        this.starNumber = starNumber;
    }

    public int getFoodNumber() {
        return foodNumber;
    }

    public void setFoodNumber(int foodNumber) {
        this.foodNumber = foodNumber;
    }
}
