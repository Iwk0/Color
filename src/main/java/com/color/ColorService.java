package com.color;

import com.color.dto.ColorRequest;
import com.color.dto.ColorResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class ColorService {

    private final ColorRepository colorRepository;

    public Mono<ColorResponse> create(ColorRequest colorRequest) {
        return colorRepository
                .findLastColor()
                .flatMap(color -> colorRepository.save(color.update(colorRequest)))
                .switchIfEmpty(colorRepository.save(Color.create(colorRequest)))
                .map(ColorResponse::new);
    }
}
