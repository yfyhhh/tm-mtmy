package com.tm.entity;


public class Video {

  private Long videoId;
  private Long videoAuthorId;
  private Integer videoType;
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

  public Integer getVideoType() {
    return videoType;
  }

  public void setVideoType(Integer videoType) {
    this.videoType = videoType;
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
