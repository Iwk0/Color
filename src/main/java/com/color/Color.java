package com.color;

import com.color.dto.ColorRequest;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Color {

    @Id
    private Long id;

    private Short red = 0;
    private Short green = 0;
    private Short blue = 0;

    private Color(ColorRequest colorRequest) {
        updateValueByType(colorRequest.getType(), colorRequest.getColor());
    }

    public static Color create(ColorRequest colorRequest) {
        return new Color(colorRequest);
    }

    public Color update(ColorRequest colorRequest) {
        updateValueByType(colorRequest.getType(), colorRequest.getColor());

        return this;
    }

    private void updateValueByType(ColorRequest.Type type, short color) {
        if (ColorRequest.Type.RED == type) {
            red = color;
        } else if (ColorRequest.Type.GREEN == type) {
            green = color;
        } else {
            blue = color;
        }
    }
}
