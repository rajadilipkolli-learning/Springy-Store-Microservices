package com.siriusxi.ms.store.revs.api;

import com.siriusxi.ms.store.api.core.product.ProductEndpoint;
import com.siriusxi.ms.store.api.core.review.ReviewEndpoint;
import com.siriusxi.ms.store.api.core.review.ReviewService;
import com.siriusxi.ms.store.api.core.review.dto.Review;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

/**
 * Class <code>ReviewController</code> is the implementation of the main Review Endpoint API
 * definition.
 *
 * @see ReviewEndpoint
 * @author mohamed.taman
 * @version v4.0
 * @since v3.0 codename Storm
 */
@RestController
public class ReviewController implements ReviewEndpoint {

  private static final Logger log = LogManager.getLogger(ReviewController.class);

  /** Review service business logic interface. */
  private final ReviewService reviewService;

  @Autowired
  public ReviewController(@Qualifier("ReviewServiceImpl") ReviewService reviewService) {
    this.reviewService = reviewService;
  }

  /** {@inheritDoc} */
  @Override
  public Flux<Review> getReviews(int productId) {
    return reviewService.getReviews(productId);
  }
}
