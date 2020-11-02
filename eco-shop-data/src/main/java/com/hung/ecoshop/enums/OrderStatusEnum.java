package com.hung.ecoshop.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum OrderStatusEnum implements CodeEnum{
    NEW("0", "New OrderMain"),
    FINISHED("1", "Finished"),
    CANCELED("2", "Canceled")
    ;

    private  String value;
    private String name;
}
