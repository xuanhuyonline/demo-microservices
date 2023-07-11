package s3.corp.apigateway.config;

import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.cloud.gateway.filter.ratelimit.RedisRateLimiter;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import reactor.core.publisher.Mono;


@Configuration
public class GatewayConfig {
    @Bean
    public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(r -> r
                        .path("/api/user-details/**")
                        .uri("http://localhost:8080/"))
                .route(r -> r
                        .path("/api/v1/**")
                        .filters(f -> f.requestRateLimiter(c -> c.setRateLimiter(redisRateLimiter()).setStatusCode(HttpStatus.TOO_MANY_REQUESTS)))
                        //.filters(f -> f.requestRateLimiter().configure(c->c.setRateLimiter(redisRateLimiter())))
                        .uri("http://localhost:8081/"))
                .build();
    }

    @Bean
    public RedisRateLimiter redisRateLimiter() {
        return new RedisRateLimiter(1, 2);
    }

    @Bean
    public KeyResolver userKeyResolver() {
        return exchange -> Mono.just("1");
    }
}
