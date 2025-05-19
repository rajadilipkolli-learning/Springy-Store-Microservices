package com.siriusxi.ms.store.rs.service;

import com.siriusxi.ms.store.api.core.recommendation.RecommendationService;
import com.siriusxi.ms.store.api.core.recommendation.dto.Recommendation;
import com.siriusxi.ms.store.rs.persistence.RecommendationRepository;
import com.siriusxi.ms.store.util.exceptions.InvalidInputException;
import com.siriusxi.ms.store.util.http.ServiceUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service("RecommendationServiceImpl")
public class RecommendationServiceImpl implements RecommendationService {

  private static final Logger log = LogManager.getLogger(RecommendationServiceImpl.class);

  private final RecommendationRepository repository;

  private final RecommendationMapper mapper;

  private final ServiceUtil serviceUtil;

  @Autowired
  public RecommendationServiceImpl(
      RecommendationRepository repository, RecommendationMapper mapper, ServiceUtil serviceUtil) {
    this.repository = repository;
    this.mapper = mapper;
    this.serviceUtil = serviceUtil;
  }

  @Override
  public Recommendation createRecommendation(Recommendation body) {

    isValidProductId(body.getProductId());

    return repository
            .save(mapper.apiToEntity(body))
            .log()
            .onErrorMap(
                    DuplicateKeyException.class,
                    ex -> new InvalidInputException("Duplicate key, Product Id: "
                            + body.getProductId() + ", Recommendation Id:"
                            + body.getRecommendationId()))
            .map(mapper::entityToApi).block();
  }

  @Override
  public Flux<Recommendation> getRecommendations(int productId) {

    isValidProductId(productId);

    return repository
            .findByProductId(productId)
            .log()
            .map(mapper::entityToApi)
            .map(e -> {
              e.setServiceAddress(serviceUtil.getServiceAddress());
              return e;
            });

      //FIXME check how to add log to flux
    //log.debug("getRecommendations: response size: {}", list.size());
  }

  @Override
  public void deleteRecommendations(int productId) {
    isValidProductId(productId);

    log.debug(
        """ 
           deleteRecommendations: tries to delete recommendations 
           for the product with productId: {}
           """,
        productId);

    repository
            .deleteAll(repository.findByProductId(productId))
            .block();
  }

  private void isValidProductId(int productId) {
    if (productId < 1) throw new InvalidInputException("Invalid productId: " + productId);
  }
}
