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

    private Short r = 0;
    private Short g = 0;
    private Short b = 0;

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
            r = color;
        } else if (ColorRequest.Type.GREEN == type) {
            g = color;
        } else {
            b = color;
        }
    }
}
