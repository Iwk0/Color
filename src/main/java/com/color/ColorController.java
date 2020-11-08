package com.color;

import com.color.dto.ColorRequest;
import com.color.dto.ColorResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "colors")
@RequiredArgsConstructor
public class ColorController {

    private final ColorService colorService;

    @PostMapping
    //It is possible to be added as filter but for this purpose it is no needed
    @CrossOrigin(origins = "http://localhost:4200")
    private Mono<ColorResponse> create(@Valid @RequestBody ColorRequest colorRequest) {
        return colorService.create(colorRequest);
    }
}