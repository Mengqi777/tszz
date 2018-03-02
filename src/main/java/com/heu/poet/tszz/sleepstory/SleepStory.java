package com.heu.poet.tszz.sleepstory;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;


/**
 * @author MengQi
 * @create 2018-02-03 17:14
 */
@Document
@SuppressWarnings(value = "unused")
public class SleepStory {

    @Id
    private String id;

    private String dateTime;

    private String content = "";

    private String title;

    private String author;

    private String authorId;

    private String toWho;

    private String status;

    private int like = 0;

    private int dislike = 0;

    private List<String> likeList = new ArrayList<>();

    private List<String> dislikeList = new ArrayList<>();

    private long timestamp;

    public SleepStory() {
        super();
    }

    public SleepStory(String id, String dateTime, String content, String title, String author, String authorId, String toWho, String status, int like, int dislike, List<String> likeList, List<String> dislikeList, long timestamp) {
        this.id = id;
        this.dateTime = dateTime;
        this.content = content;
        this.title = title;
        this.author = author;
        this.authorId = authorId;
        this.toWho = toWho;
        this.status = status;
        this.like = like;
        this.dislike = dislike;
        this.likeList = likeList;
        this.dislikeList = dislikeList;
        this.timestamp = timestamp;
    }

    public List<String> getLikeList() {
        return likeList;
    }

    public int getLike() {
        return like;
    }

    public void setLike(int like) {
        this.like = like;
    }

    public int getDislike() {
        return dislike;
    }

    public void setDislike(int dislike) {
        this.dislike = dislike;
    }

    public void setLikeList(List<String> likeList) {
        this.likeList = likeList;
    }

    public List<String> getDislikeList() {
        return dislikeList;
    }

    public void setDislikeList(List<String> dislikeList) {
        this.dislikeList = dislikeList;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public String getAuthorId() {
        return authorId;
    }

    public void setAuthorId(String authorId) {
        this.authorId = authorId;
    }

    public String getToWho() {
        return toWho;
    }

    public void setToWho(String toWho) {
        this.toWho = toWho;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
