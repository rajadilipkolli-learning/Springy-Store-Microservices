package com.siriusxi.ms.store.api.composite.dto;

/**
 * Record <code>ServiceAddresses</code> that hold all services addresses involved in the product
 * call.
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
public class ServiceAddresses {
    private final String storeService;
    private final String productService;
    private final String reviewService;
    private final String recommendationService;

    public ServiceAddresses(String storeService, String productService,
            String reviewService, String recommendationService) {
        this.storeService = storeService;
        this.productService = productService;
        this.reviewService = reviewService;
        this.recommendationService = recommendationService;
    }

    public String storeService() { return storeService; }
    public String productService() { return productService; }
    public String reviewService() { return reviewService; }
    public String recommendationService() { return recommendationService; }
}
