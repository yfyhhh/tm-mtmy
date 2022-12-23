package com.tm.entity.vo;

public class VideoVo {
    private Long videoId;
    private Long videoAuthorId;
    private String videoUrl;
    private Integer videoCount;
    private Integer thumbsUpCount;

    public Long getVideoId() {
        return videoId;
    }

    public void setVideoId(Long videoId) {
        this.videoId = videoId;
    }

    public Long getVideoAuthorId() {
        return videoAuthorId;
    }

    public void setVideoAuthorId(Long videoAuthorId) {
        this.videoAuthorId = videoAuthorId;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public Integer getVideoCount() {
        return videoCount;
    }

    public void setVideoCount(Integer videoCount) {
        this.videoCount = videoCount;
    }

    public Integer getThumbsUpCount() {
        return thumbsUpCount;
    }

    public void setThumbsUpCount(Integer thumbsUpCount) {
        this.thumbsUpCount = thumbsUpCount;
    }
}
