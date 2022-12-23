package com.tm.entity;


public class TextComments {

  private Long commentId;
  private String commentStr;
  private Long commentUserId;
  private Long textId;
  private Integer thumbsUpCount;
  private Long commentTime;

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

  public Long getTextId() {
    return textId;
  }

  public void setTextId(Long textId) {
    this.textId = textId;
  }

  public Integer getThumbsUpCount() {
    return thumbsUpCount;
  }

  public void setThumbsUpCount(Integer thumbsUpCount) {
    this.thumbsUpCount = thumbsUpCount;
  }

  public Long getCommentTime() {
    return commentTime;
  }

  public void setCommentTime(Long commentTime) {
    this.commentTime = commentTime;
  }
}
