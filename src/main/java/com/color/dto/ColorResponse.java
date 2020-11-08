package com.color.dto;

import com.color.Color;
import lombok.Getter;

@Getter
public class ColorResponse {

    private final short r;
    private final short g;
    private final short b;

    public ColorResponse(Color color) {
        r = color.getR();
        g = color.getG();
        b = color.getB();
    }
}
