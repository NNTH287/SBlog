package vn.edu.fpt.sblog_api_gateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiGatewayConfiguration {

    @Bean
    public RouteLocator apiGatewayRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(p -> p.path("/api/users/**")
                        .uri("lb://sblog-user-service")
                )
                .route(p -> p.path("/login")
                        .uri("lb://sblog-authentication-service")
                )
                .route(p -> p.path("/api/posts/**")
                        .uri("lb://sblog-post-service")
                )
                .build();
    }
}
