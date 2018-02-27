package com.heu.poet.tszz.sleepstory;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


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

    private String content="";

    private String title;

    private String author;

    private String authorId;

    private String toWho;

    private String status;

    private int good=1;

    private int bad=1;

    private long timestamp;

    public SleepStory() {
super();    }

    public SleepStory(String id, String dateTime, String content, String title, String author, String authorId, String toWho, String status, int good, int bad, long timestamp) {
        this.id = id;
        this.dateTime = dateTime;
        this.content = content;
        this.title = title;
        this.author = author;
        this.authorId = authorId;
        this.toWho = toWho;
        this.status = status;
        this.good = good;
        this.bad = bad;
        this.timestamp = timestamp;
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

    public int getGood() {
        return good;
    }

    public void setGood(int good) {
        this.good = good;
    }

    public int getBad() {
        return bad;
    }

    public void setBad(int bad) {
        this.bad = bad;
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
