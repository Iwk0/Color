package com.color;

import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;

public interface ColorRepository extends ReactiveCrudRepository<Color, Long> {

    @Query(value = "SELECT * FROM color ORDER BY id DESC LIMIT 1")
    Mono<Color> findLastColor();
}