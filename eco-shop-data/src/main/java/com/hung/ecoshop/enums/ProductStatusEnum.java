package com.hung.ecoshop.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ProductStatusEnum implements CodeEnum{
    UP("0", "Available"),
    DOWN("1", "Unavailable")
    ;
    private String value;
    private String name;

    public String getStatus(Integer code) {

        for(ProductStatusEnum statusEnum : ProductStatusEnum.values()) {
            if(statusEnum.getValue().equals(code)) return statusEnum.getName();
        }
        return "";
    }
}
