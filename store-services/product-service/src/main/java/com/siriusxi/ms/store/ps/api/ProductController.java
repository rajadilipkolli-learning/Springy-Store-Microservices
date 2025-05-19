package com.siriusxi.ms.store.ps.api;

import com.siriusxi.ms.store.api.core.product.ProductEndpoint;
import com.siriusxi.ms.store.api.core.product.ProductService;
import com.siriusxi.ms.store.api.core.product.dto.Product;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 * Class <code>ProductController</code> is the implementation of the main Product Endpoint API
 * definition.
 *
 * @see ProductEndpoint
 * @author mohamed.taman
 * @version v5.8
 * @since v3.0 codename Storm
 */
@RestController
public class ProductController implements ProductEndpoint {

  private static final Logger log = LogManager.getLogger(ProductController.class);

  /** Product service business logic interface. */
  private final ProductService prodService;

  @Autowired
  public ProductController(@Qualifier("ProductServiceImpl") ProductService prodService) {
    this.prodService = prodService;
  }

  /** {@inheritDoc} */
  @Override
  public Mono<Product> getProduct(int id, int delay, int faultPercent) {
    return prodService.getProduct(id, delay, faultPercent);
  }
}
