package com.siriusxi.ms.store.ps.persistence;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "products")
public class ProductEntity {
  @Id private String id;
  @Version private Integer version;
  @Indexed(unique = true)
  private int productId;
  private String name;
  private int weight;

  public ProductEntity() {}

  public ProductEntity(int productId, String name, int weight) {
    this.productId = productId;
    this.name = name;
    this.weight = weight;
  }

  public String getId() { return id; }
  public void setId(String id) { this.id = id; }
  public Integer getVersion() { return version; }
  public void setVersion(Integer version) { this.version = version; }
  public int getProductId() { return productId; }
  public void setProductId(int productId) { this.productId = productId; }
  public String getName() { return name; }
  public void setName(String name) { this.name = name; }
  public int getWeight() { return weight; }
  public void setWeight(int weight) { this.weight = weight; }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ProductEntity that = (ProductEntity) o;
    return productId == that.productId && weight == that.weight &&
           java.util.Objects.equals(id, that.id) &&
           java.util.Objects.equals(version, that.version) &&
           java.util.Objects.equals(name, that.name);
  }

  @Override
  public int hashCode() {
    return java.util.Objects.hash(id, version, productId, name, weight);
  }

  @Override
  public String toString() {
    return "ProductEntity{" +
        "id='" + id + '\'' +
        ", version=" + version +
        ", productId=" + productId +
        ", name='" + name + '\'' +
        ", weight=" + weight +
        '}';
  }
}
