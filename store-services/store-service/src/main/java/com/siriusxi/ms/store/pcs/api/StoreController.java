package com.siriusxi.ms.store.pcs.api;

import com.siriusxi.ms.store.api.composite.StoreEndpoint;
import com.siriusxi.ms.store.api.composite.StoreService;
import com.siriusxi.ms.store.api.composite.dto.ProductAggregate;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class StoreController implements StoreEndpoint {

  private static final Logger log = LogManager.getLogger(StoreController.class);

  /** Store service business logic interface. */
  private final StoreService storeService;

  @Autowired
  public StoreController(@Qualifier("StoreServiceImpl") StoreService storeService) {
    this.storeService = storeService;
  }

  /**
   * {@inheritDoc}
   *
   * @return final product.
   */
  @Override
  public Mono<ProductAggregate> getProduct(int id, int delay, int faultPercent) {
    return storeService.getProduct(id, delay, faultPercent);
  }

  /**
   * {@inheritDoc}
   *
   * @return nothing.
   */
  @Override
  public Mono<Void> createProduct(ProductAggregate body) {
    return storeService.createProduct(body);
  }

  /**
   * {@inheritDoc}
   *
   * @return nothing.
   */
  @Override
  public Mono<Void> deleteProduct(int id) {
    return storeService.deleteProduct(id);
  }
}
