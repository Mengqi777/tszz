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


    public SleepStory() {
super();    }

    public SleepStory(String id, String dateTime, String content, String title, String author) {
        this.id = id;
        this.dateTime = dateTime;
        this.content = content;
        this.title = title;
        this.author = author;
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
