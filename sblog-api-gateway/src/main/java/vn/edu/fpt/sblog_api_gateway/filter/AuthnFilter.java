package vn.edu.fpt.sblog_api_gateway.filter;

import io.jsonwebtoken.Claims;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;
import vn.edu.fpt.sblog_api_gateway.util.JwtUtil;

import java.util.List;
import java.util.function.Predicate;

@Component
public class AuthnFilter implements GlobalFilter {
    private static final List<String> PUBLIC_URLS = List.of("/login");
    private final Predicate<ServerHttpRequest> authEnable = request -> PUBLIC_URLS
            .stream().noneMatch(uri -> request.getURI().getPath().startsWith(uri));

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        if (!authEnable.test(exchange.getRequest())) {
            return chain.filter(exchange);
        }

        String authHeader = exchange.getRequest().getHeaders().getFirst(HttpHeaders.AUTHORIZATION);

        if(authHeader != null && authHeader.startsWith("Bearer ")) {
            String token = authHeader.substring(7);

            if(!JwtUtil.isValid(token)) {
                return unauthorized(exchange);
            }

            Claims claims = JwtUtil.extractClaims(token);

            // Add claims to request header for downstream services
            ServerHttpRequest mutated = exchange.getRequest().mutate()
                    .header("X-User-Id", claims.getSubject())
                    .header("X-Role", (String) claims.get("role"))
                    .build();

            return chain.filter(exchange.mutate().request(mutated).build());
        }

        return unauthorized(exchange);
    }

    private Mono<Void> unauthorized(ServerWebExchange exchange) {
        exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
        return exchange.getResponse().setComplete();
    }
}
