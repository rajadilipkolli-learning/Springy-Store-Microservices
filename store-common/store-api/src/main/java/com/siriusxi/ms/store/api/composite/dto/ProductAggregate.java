package com.siriusxi.ms.store.api.composite.dto;

import java.util.List;
import java.util.Objects;
/**
 * Record <code>ProductAggregate</code> that hold all the product aggregate information.
 *
 * @implNote Since it is a record and not normal POJO, so it needs some customizations
 * to be serialized to JSON and this is done with method
 * <code>GlobalConfiguration.jacksonCustomizer()</code>.
 *
 * @see java.lang.Record
 * @see com.siriusxi.ms.store.util.config.GlobalConfiguration
 * @author mohamed.taman
 * @version v4.6
 * @since v0.1
 */
public class ProductAggregate {
    private final int productId;
    private final String name;
    private final int weight;
    private final List<RecommendationSummary> recommendations;
    private final List<ReviewSummary> reviews;
    private final ServiceAddresses serviceAddresses;

    public ProductAggregate(int productId, String name, int weight,
            List<RecommendationSummary> recommendations, List<ReviewSummary> reviews,
            ServiceAddresses serviceAddresses) {
        this.productId = productId;
        this.name = name;
        this.weight = weight;
        this.recommendations = recommendations;
        this.reviews = reviews;
        this.serviceAddresses = serviceAddresses;
    }

    public int productId() { return productId; }
    public String name() { return name; }
    public int weight() { return weight; }
    public List<RecommendationSummary> recommendations() { return recommendations; }
    public List<ReviewSummary> reviews() { return reviews; }
    public ServiceAddresses serviceAddresses() { return serviceAddresses; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProductAggregate)) return false;
        ProductAggregate that = (ProductAggregate) o;
        return productId == that.productId
                && weight == that.weight
                && Objects.equals(name, that.name)
                && Objects.equals(recommendations, that.recommendations)
                && Objects.equals(reviews, that.reviews)
                && Objects.equals(serviceAddresses, that.serviceAddresses);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId, name, weight, recommendations, reviews, serviceAddresses);
    }

    @Override
    public String toString() {
        return "ProductAggregate{" +
                "productId=" + productId +
                ", name='" + name + "'" +
                ", weight=" + weight +
                ", recommendations=" + recommendations +
                ", reviews=" + reviews +
                ", serviceAddresses=" + serviceAddresses +
                '}';
    }
}