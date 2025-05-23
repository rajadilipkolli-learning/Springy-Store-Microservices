package com.siriusxi.ms.store.rs.infra;

import com.siriusxi.ms.store.api.core.recommendation.RecommendationService;
import com.siriusxi.ms.store.api.core.recommendation.dto.Recommendation;
import com.siriusxi.ms.store.api.event.Event;
import com.siriusxi.ms.store.util.exceptions.EventProcessingException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

import static java.lang.String.*;

@EnableBinding(Sink.class)
public class MessageProcessor {

    private static final Logger log = LogManager.getLogger(MessageProcessor.class);

    private final RecommendationService service;

    @Autowired
    public MessageProcessor(@Qualifier("RecommendationServiceImpl") RecommendationService service) {
        this.service = service;
    }

    @StreamListener(target = Sink.INPUT)
    public void process(Event<Integer, Recommendation> event) {

        log.info("Process message created at {}...", event.getEventCreatedAt());

        switch (event.getEventType()) {
            case CREATE -> {
                Recommendation recommendation = event.getData();
                log.info("Create recommendation with ID: {}/{}", recommendation.getProductId(),
                        recommendation.getRecommendationId());
                service.createRecommendation(recommendation);
            }
            case DELETE -> {
                int productId = event.getKey();
                log.info("Delete recommendations with ProductID: {}", productId);
                service.deleteRecommendations(productId);
            }
            default -> {
                String errorMessage =
                        "Incorrect event type: "
                                .concat(valueOf(event.getEventType()))
                                .concat(", expected a CREATE or DELETE event");
                log.warn(errorMessage);
                throw new EventProcessingException(errorMessage);
            }
        }

        log.info("Message processing done!");
    }

}
