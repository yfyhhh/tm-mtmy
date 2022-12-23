package com.tm.entity;


public class GoodsComments {

  private Long commentId;
  private String commentStr;
  //商品打分(5颗星，可以半星 最低无星) 0123456789
  private Integer goodsScore;
  private Long commentUserId;
  private Long goodsId;
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

  public Integer getGoodsScore() {
    return goodsScore;
  }

  public void setGoodsScore(Integer goodsScore) {
    this.goodsScore = goodsScore;
  }

  public Long getCommentUserId() {
    return commentUserId;
  }

  public void setCommentUserId(Long commentUserId) {
    this.commentUserId = commentUserId;
  }

  public Long getGoodsId() {
    return goodsId;
  }

  public void setGoodsId(Long goodsId) {
    this.goodsId = goodsId;
  }

  public Long getCommentTime() {
    return commentTime;
  }

  public void setCommentTime(Long commentTime) {
    this.commentTime = commentTime;
  }
}
