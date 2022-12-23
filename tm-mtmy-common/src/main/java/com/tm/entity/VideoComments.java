package com.tm.entity;


public class VideoComments {

  private Long commentId;
  private String commentStr;
  private Long commentUserId;
  private Long videoId;
  private Integer thumbsUpCount;

  public Long getCommentId() {
    return commentId;
  }

  public void setCommentId(Long commentId) {
    this.commentId = commentId;
  }

  public String getCommentStr() {
    return commentStr;
  }

  public void setCommentStr(String commentStr) {
    this.commentStr = commentStr;
  }

  public Long getCommentUserId() {
    return commentUserId;
  }

  public void setCommentUserId(Long commentUserId) {
    this.commentUserId = commentUserId;
  }

  public Long getVideoId() {
    return videoId;
  }

  public void setVideoId(Long videoId) {
    this.videoId = videoId;
  }

  public Integer getThumbsUpCount() {
    return thumbsUpCount;
  }

  public void setThumbsUpCount(Integer thumbsUpCount) {
    this.thumbsUpCount = thumbsUpCount;
  }
}
