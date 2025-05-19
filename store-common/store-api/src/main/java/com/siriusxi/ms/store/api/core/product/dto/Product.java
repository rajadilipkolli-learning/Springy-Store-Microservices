package com.siriusxi.ms.store.api.core.product.dto;

public class Product {
  private int productId;
  private String name;
  private int weight;
  private String serviceAddress;

  public Product() {}

  public Product(int productId, String name, int weight, String serviceAddress) {
    this.productId = productId;
    this.name = name;
    this.weight = weight;
    this.serviceAddress = serviceAddress;
  }

  public int getProductId() {
    return productId;
  }

  public void setProductId(int productId) {
    this.productId = productId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getWeight() {
    return weight;
  }

  public void setWeight(int weight) {
    this.weight = weight;
  }

  public String getServiceAddress() {
    return serviceAddress;
  }

  public void setServiceAddress(String serviceAddress) {
    this.serviceAddress = serviceAddress;
  }

  @Override
  public String toString() {
    return "Product{" +
        "productId=" + productId +
        ", name='" + name + '\'' +
        ", weight=" + weight +
        ", serviceAddress='" + serviceAddress + '\'' +
        '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Product product = (Product) o;
    return productId == product.productId &&
        weight == product.weight &&
        java.util.Objects.equals(name, product.name) &&
        java.util.Objects.equals(serviceAddress, product.serviceAddress);
  }

  @Override
  public int hashCode() {
    return java.util.Objects.hash(productId, name, weight, serviceAddress);
  }
}
