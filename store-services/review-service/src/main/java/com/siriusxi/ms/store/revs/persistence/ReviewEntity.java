package com.siriusxi.ms.store.revs.persistence;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(
        name = "review",
    indexes = {
      @Index(name = "review_unique_idx", unique = true, columnList = "productId, reviewId")
    })
public class ReviewEntity {

  @Id
  @GeneratedValue(strategy = IDENTITY)
  private int id;

  @Version private int version;

  private int productId;
  private int reviewId;
  @NotBlank
  @Size(min = 6, max = 50)
  private String author;
  @NotBlank
  private String subject;
  @NotBlank
  private String content;

  public ReviewEntity() {}

  public ReviewEntity(int productId, int reviewId, String author, String subject, String content) {
    this.productId = productId;
    this.reviewId = reviewId;
    this.author = author;
    this.subject = subject;
    this.content = content;
  }

  public int getId() { return id; }
  public void setId(int id) { this.id = id; }
  public int getVersion() { return version; }
  public void setVersion(int version) { this.version = version; }
  public int getProductId() { return productId; }
  public void setProductId(int productId) { this.productId = productId; }
  public int getReviewId() { return reviewId; }
  public void setReviewId(int reviewId) { this.reviewId = reviewId; }
  public String getAuthor() { return author; }
  public void setAuthor(String author) { this.author = author; }
  public String getSubject() { return subject; }
  public void setSubject(String subject) { this.subject = subject; }
  public String getContent() { return content; }
  public void setContent(String content) { this.content = content; }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ReviewEntity that = (ReviewEntity) o;
    return productId == that.productId && reviewId == that.reviewId &&
           java.util.Objects.equals(author, that.author) &&
           java.util.Objects.equals(subject, that.subject) &&
           java.util.Objects.equals(content, that.content);
  }

  @Override
  public int hashCode() {
    return java.util.Objects.hash(productId, reviewId, author, subject, content);
  }

  @Override
  public String toString() {
    return "ReviewEntity{" +
        "id=" + id +
        ", version=" + version +
        ", productId=" + productId +
        ", reviewId=" + reviewId +
        ", author='" + author + '\'' +
        ", subject='" + subject + '\'' +
        ", content='" + content + '\'' +
        '}';
  }
}
