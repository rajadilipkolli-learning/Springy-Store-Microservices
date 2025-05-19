package com.siriusxi.ms.store.api.core.review.dto;

public class Review {
  private int productId;
  private int reviewId;
  private String author;
  private String subject;
  private String content;
  private String serviceAddress;

  public Review() {}

  public Review(int productId, int reviewId, String author, String subject, String content, String serviceAddress) {
    this.productId = productId;
    this.reviewId = reviewId;
    this.author = author;
    this.subject = subject;
    this.content = content;
    this.serviceAddress = serviceAddress;
  }

  public int getProductId() {
    return productId;
  }

  public void setProductId(int productId) {
    this.productId = productId;
  }

  public int getReviewId() {
    return reviewId;
  }

  public void setReviewId(int reviewId) {
    this.reviewId = reviewId;
  }

  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  public String getSubject() {
    return subject;
  }

  public void setSubject(String subject) {
    this.subject = subject;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public String getServiceAddress() {
    return serviceAddress;
  }

  public void setServiceAddress(String serviceAddress) {
    this.serviceAddress = serviceAddress;
  }

  @Override
  public String toString() {
    return "Review{" +
        "productId=" + productId +
        ", reviewId=" + reviewId +
        ", author='" + author + '\'' +
        ", subject='" + subject + '\'' +
        ", content='" + content + '\'' +
        ", serviceAddress='" + serviceAddress + '\'' +
        '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Review review = (Review) o;
    return productId == review.productId &&
        reviewId == review.reviewId &&
        java.util.Objects.equals(author, review.author) &&
        java.util.Objects.equals(subject, review.subject) &&
        java.util.Objects.equals(content, review.content) &&
        java.util.Objects.equals(serviceAddress, review.serviceAddress);
  }

  @Override
  public int hashCode() {
    return java.util.Objects.hash(productId, reviewId, author, subject, content, serviceAddress);
  }
}
