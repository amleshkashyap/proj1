package com;

import com.repositories.CustomerRepository;
import io.vertx.core.Vertx;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories(basePackageClasses = CustomerRepository.class)
public class ServerMain {
    private static Logger logger = LoggerFactory.getLogger(ServerMain.class);

    public static final Vertx vertx = Vertx.vertx();

    public static void main(String args[]) {

        logger.info("Server Started\n");
        SpringApplication.run(ServerMain.class, args);
    }
}
