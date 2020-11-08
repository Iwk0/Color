package com.color.dto;

import com.color.Color;
import lombok.Getter;

@Getter
public class ColorResponse {

    private final short red;
    private final short green;
    private final short blue;

    public ColorResponse(Color color) {
        red = color.getRed();
        green = color.getGreen();
        blue = color.getBlue();
    }
}
