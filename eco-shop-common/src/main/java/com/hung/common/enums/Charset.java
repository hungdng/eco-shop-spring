package com.hung.common.enums;

import com.hung.ecoshop.enums.CodeEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Charset implements CodeEnum {
    WINDOWS_31J("Windows-31J", "")
    , WINDOWS_ISO_2022_1("X-WINDOWS-ISO2022JP", "")
    , SHIFT_JIS("Shift_JIS", "")
    , EUC_JP("EUC-JP", "")
    , ISO_2022_1("ISO-2022-JP", "")
    , UTF_8("UTF-8", "")
    , MS932("MS932", "")
    ;

    private final String value;
    private final String name;
}
