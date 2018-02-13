package com.heu.poet.tszz.treasure;

import org.springframework.data.annotation.Id;

/**
 * @author MengQi
 * @create 2018-02-03 17:39
 */
public class Treasure {
    @Id
    private String id;
    private String name;
    private int type;
    private String typeName;
    private String imgUri;
    private int sequence = -1;
    private String text;
    private String title;
    private String titleEng;
    private String detail;
    private String content;
    private String audioUri;
    private String videoUri;

    public Treasure() {
        super();
    }

    public Treasure(String id, String name, int type, String typeName, String imgUri, int sequence, String text, String title, String titleEng, String detail, String content, String audioUri, String videoUri) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.typeName = typeName;
        this.imgUri = imgUri;
        this.sequence = sequence;
        this.text = text;
        this.title = title;
        this.titleEng = titleEng;
        this.detail = detail;
        this.content = content;
        this.audioUri = audioUri;
        this.videoUri = videoUri;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getImgUri() {
        return imgUri;
    }

    public void setImgUri(String imgUri) {
        this.imgUri = imgUri;
    }

    public int getSequence() {
        return sequence;
    }

    public void setSequence(int sequence) {
        this.sequence = sequence;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitleEng() {
        return titleEng;
    }

    public void setTitleEng(String titleEng) {
        this.titleEng = titleEng;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAudioUri() {
        return audioUri;
    }

    public void setAudioUri(String audioUri) {
        this.audioUri = audioUri;
    }

    public String getVideoUri() {
        return videoUri;
    }

    public void setVideoUri(String videoUri) {
        this.videoUri = videoUri;
    }
}
