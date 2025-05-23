package com.siriusxi.ms.store.rs.persistence;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.mapping.Document;

import static java.lang.String.format;

@Document(collection = "recommendations")
@CompoundIndex(
    name = "prod-rec-id",
    unique = true,
    def = "{'productId': 1, 'recommendationId' : 1}")
public class RecommendationEntity {

  @Id private String id;
  @Version private Integer version;
  private int productId;
  private int recommendationId;
  private String author;
  private int rating;
  private String content;

  public RecommendationEntity() {}

  public RecommendationEntity(
      int productId, int recommendationId, String author, int rating, String content) {
    this.productId = productId;
    this.recommendationId = recommendationId;
    this.author = author;
    this.rating = rating;
    this.content = content;
  }

  public String getId() { return id; }
  public void setId(String id) { this.id = id; }
  public Integer getVersion() { return version; }
  public void setVersion(Integer version) { this.version = version; }
  public int getProductId() { return productId; }
  public void setProductId(int productId) { this.productId = productId; }
  public int getRecommendationId() { return recommendationId; }
  public void setRecommendationId(int recommendationId) { this.recommendationId = recommendationId; }
  public String getAuthor() { return author; }
  public void setAuthor(String author) { this.author = author; }
  public int getRating() { return rating; }
  public void setRating(int rating) { this.rating = rating; }
  public String getContent() { return content; }
  public void setContent(String content) { this.content = content; }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    RecommendationEntity that = (RecommendationEntity) o;
    return productId == that.productId && recommendationId == that.recommendationId && rating == that.rating &&
           java.util.Objects.equals(id, that.id) &&
           java.util.Objects.equals(version, that.version) &&
           java.util.Objects.equals(author, that.author) &&
           java.util.Objects.equals(content, that.content);
  }

  @Override
  public int hashCode() {
    return java.util.Objects.hash(id, version, productId, recommendationId, author, rating, content);
  }

  @Override
  public String toString() {
    return "RecommendationEntity{" +
        "id='" + id + '\'' +
        ", version=" + version +
        ", productId=" + productId +
        ", recommendationId=" + recommendationId +
        ", author='" + author + '\'' +
        ", rating=" + rating +
        ", content='" + content + '\'' +
        '}';
  }
}
