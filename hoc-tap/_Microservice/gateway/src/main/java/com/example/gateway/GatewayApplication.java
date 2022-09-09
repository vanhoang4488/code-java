package com.example.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.config.GatewayAutoConfiguration;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class, args);
    }

//	@Bean
//	public RouteLocator routeLocator(RouteLocatorBuilder builder){
//
//		return  builder.routes()
//				.route( route ->
//						route
//								.path("/api/**")
//								.filters(RenameUri -> RenameUri.setPath("/youtube"))
//								.uri("https://www.youtube.com")
//				)
//				.build();
//	}
}
