package com.siriusxi.ms.store.ps;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@SpringBootApplication
@ComponentScan("com.siriusxi.ms.store")
public class ProductServiceApplication {

  private static final Logger log = LogManager.getLogger(ProductServiceApplication.class);

  public static void main(String[] args) {
    ConfigurableApplicationContext ctx =
        SpringApplication.run(ProductServiceApplication.class, args);

    var mongoDbHost = ctx.getEnvironment().getProperty("spring.data.mongodb.host");
    var mongoDbPort = ctx.getEnvironment().getProperty("spring.data.mongodb.port");
    log.info("Connected to MongoDb: " + mongoDbHost + ":" + mongoDbPort);
  }
}
