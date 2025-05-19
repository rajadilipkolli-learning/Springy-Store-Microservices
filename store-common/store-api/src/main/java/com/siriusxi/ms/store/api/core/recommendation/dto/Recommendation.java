package com.siriusxi.ms.store.api.core.recommendation.dto;

public class Recommendation {
  private int productId;
  private int recommendationId;
  private String author;
  private int rate;
  private String content;
  private String serviceAddress;

  public Recommendation() {}

  public Recommendation(int productId, int recommendationId, String author, int rate, String content, String serviceAddress) {
    this.productId = productId;
    this.recommendationId = recommendationId;
    this.author = author;
    this.rate = rate;
    this.content = content;
    this.serviceAddress = serviceAddress;
  }

  public int getProductId() {
    return productId;
  }

  public void setProductId(int productId) {
    this.productId = productId;
  }

  public int getRecommendationId() {
    return recommendationId;
  }

  public void setRecommendationId(int recommendationId) {
    this.recommendationId = recommendationId;
  }

  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  public int getRate() {
    return rate;
  }

  public void setRate(int rate) {
    this.rate = rate;
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
    return "Recommendation{" +
        "productId=" + productId +
        ", recommendationId=" + recommendationId +
        ", author='" + author + '\'' +
        ", rate=" + rate +
        ", content='" + content + '\'' +
        ", serviceAddress='" + serviceAddress + '\'' +
        '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Recommendation that = (Recommendation) o;
    return productId == that.productId &&
        recommendationId == that.recommendationId &&
        rate == that.rate &&
        java.util.Objects.equals(author, that.author) &&
        java.util.Objects.equals(content, that.content) &&
        java.util.Objects.equals(serviceAddress, that.serviceAddress);
  }

  @Override
  public int hashCode() {
    return java.util.Objects.hash(productId, recommendationId, author, rate, content, serviceAddress);
  }
}
