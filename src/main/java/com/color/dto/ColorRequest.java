package com.color.dto;

import lombok.Getter;
import org.hibernate.validator.constraints.Range;

@Getter
public class ColorRequest {

    @Range(max = 255, message = "Range is out of bound 0 - 255")
    private short color;
    private Type type;

    public enum Type {
        RED, GREEN, BLUE
    }
}