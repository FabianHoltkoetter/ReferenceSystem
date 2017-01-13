package edu.hm.ba.kongo.infrastructure.registry;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * The Eureka Server for all Services.
 * Configure it in resources/application.properties.
 * (Port and Location can be found there)
 */
@SpringBootApplication
@EnableEurekaServer
public class RegistryserverApplication {

    /**
     * Start the Eureka-Server.
     *
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        SpringApplication.run(RegistryserverApplication.class, args);
    }
}
